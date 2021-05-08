package entities;

import java.io.Serializable;

public class Gerente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id_gerente;
	private String cpf;
	private int id_partida;
	
	public Gerente(int id_gerente, String cpf, int id_partida) {
		this.id_gerente = id_gerente;
		this.cpf = cpf;
		this.id_partida = id_partida;
	}

	public int getId_gerente() {
		return id_gerente;
	}

	public void setId_gerente(int id_gerente) {
		this.id_gerente = id_gerente;
	}

	public String getCpg() {
		return cpf;
	}

	public void setCpg(String cpg) {
		this.cpf = cpg;
	}

	public int getId_partida() {
		return id_partida;
	}

	public void setId_partida(int id_partida) {
		this.id_partida = id_partida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + id_gerente;
		result = prime * result + id_partida;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gerente other = (Gerente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id_gerente != other.id_gerente)
			return false;
		if (id_partida != other.id_partida)
			return false;
		return true;
	}
	
	
}
