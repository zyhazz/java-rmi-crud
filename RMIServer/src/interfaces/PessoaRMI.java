package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entidades.Pessoa;

public interface PessoaRMI extends Remote {
	public void addPessoa(Pessoa pessoa)throws RemoteException;
	public void deletePessoa(int id) throws RemoteException;
	public void updatePessoa(Pessoa pessoa) throws RemoteException;
	public List<Pessoa> getAllPessoas() throws RemoteException;
	public Pessoa getPessoaById(int id) throws RemoteException;
}