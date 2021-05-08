package entities;

import java.io.Serializable;

public class TipoEsporte implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome_esporte;
	
	public TipoEsporte(int id, String nome_esporte) {
		this.id = id;
		this.nome_esporte = nome_esporte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_esporte() {
		return nome_esporte;
	}

	public void setNome_esporte(String nome_esporte) {
		this.nome_esporte = nome_esporte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome_esporte == null) ? 0 : nome_esporte.hashCode());
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
		TipoEsporte other = (TipoEsporte) obj;
		if (id != other.id)
			return false;
		if (nome_esporte == null) {
			if (other.nome_esporte != null)
				return false;
		} else if (!nome_esporte.equals(other.nome_esporte))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoEsporte [id=" + id + ", nome_esporte=" + nome_esporte + "]";
	}
	
	
	

}
