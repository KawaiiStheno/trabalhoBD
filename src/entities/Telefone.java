package entities;

import java.io.Serializable;

public class Telefone implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String cpf;
	private int telefone;
	
	public Telefone(String cpf, int telefone) {
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
}
