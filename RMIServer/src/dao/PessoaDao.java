package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entidades.*;
import interfaces.PessoaRMI;
import util.HibernateUtil;

public class PessoaDao extends UnicastRemoteObject implements PessoaRMI {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PessoaDao() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addPessoa(Pessoa pessoa) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(pessoa);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
    }

    public void deletePessoa(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Pessoa pessoa = (Pessoa) session.load(Pessoa.class, new Integer(id));
            session.delete(pessoa);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
    }

    public void updatePessoa(Pessoa pessoa) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(pessoa);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
    }

    public List<Pessoa> getAllPessoas() {
        List<Pessoa> pessoa = new ArrayList<Pessoa>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            pessoa = session.createQuery("from Pessoa").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
        return pessoa;
    }

    public Pessoa getPessoaById(int id) {
        Pessoa pessoa = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from pessoa where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            pessoa = (Pessoa) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
        return pessoa;
    }
}