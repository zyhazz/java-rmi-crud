package entidades;

import java.io.Serializable;

public class Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		return "Pessoa{ Nome:" + this.getNome() + " Telefone:" + this.getTelefone() + " Email:" + this.getEmail() + "}";
	}
	private int id;
	private String nome;
	private String telefone;
	private String email;
}
