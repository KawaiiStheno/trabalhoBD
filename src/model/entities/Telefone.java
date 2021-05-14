package model.entities;

import java.io.Serializable;

public class Telefone implements Serializable{
	
	private static final long serialVersionUID = 1L;

<<<<<<< HEAD
	private int id_fone;
	private String numero;
	private int id_usuario;
	
	public Telefone() {
		
=======
	private int id_usuario;
	private String fone;
	
	public Telefone(int id_usuario, String fone) {
		this.id_usuario = id_usuario;
		this.fone = fone;
>>>>>>> d07f0561e414185ab08faa2f11c3165a88074c4c
	}
	
	public Telefone() {}

<<<<<<< HEAD
	public Telefone(int id_fone, String numero, int id_usuario) {
		this.id_fone = id_fone;
		this.numero = numero;
		this.id_usuario = id_usuario;
	}

	public int getId_fone() {
		return id_fone;
	}

	public void setId_fone(int id_fone) {
		this.id_fone = id_fone;
	}

	public String getNumero() {
		return numero;
=======
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
>>>>>>> d07f0561e414185ab08faa2f11c3165a88074c4c
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_fone;
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
		Telefone other = (Telefone) obj;
		if (id_fone != other.id_fone)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefone [id_fone=" + id_fone + ", numero=" + numero + ", id_usuario=" + id_usuario + "]";
	}
	
	

	

	
	
	
}
