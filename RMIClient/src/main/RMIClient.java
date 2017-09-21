package main;

import java.rmi.Naming;
import java.util.List;

import entidades.Pessoa;
import interfaces.PessoaRMI;

public class RMIClient {
	public static void main(String[] args) {
		try {
			PessoaRMI p = (PessoaRMI) Naming.lookup("//127.0.0.1:1212/PessoaService");
			List<Pessoa> ps = p.getAllPessoas();

			for (int i = 0; i < ps.size(); i++) {
				System.out.println(ps.get(i));

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}