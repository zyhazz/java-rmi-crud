package main;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dao.PessoaDao;
import interfaces.PessoaRMI;

public class RMIServer {
	RMIServer() {
		try {
			LocateRegistry.createRegistry(1212);
			PessoaRMI d = new PessoaDao();
			Naming.rebind("rmi://127.0.0.1:1212/PessoaService", d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//PessoaDao d = new PessoaDao();
		
		//Pessoa p = new Pessoa();
		//p.setNome("Diego");
		//p.setEmail("zyhazz@gmail.com");
		//p.setTelefone("988002221");
		
		//Pessoa p2 = new Pessoa();
		//p2.setNome("Angelica");
		//p2.setEmail("angelica@gmail.com");
		//p2.setTelefone("99889988");
		
		//d.addPessoa(p);
		//d.addPessoa(p2);

		new RMIServer();
		System.out.println("servidor rmi em execução");
	}
}