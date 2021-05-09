package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Partida implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id_partida;
	private int id_esporte;
	private String nome_partida;
	private Date data_partida;
	private Date horario_partida;
	
	public Partida(int id_partida, int id_esporte, String nome_partida, Date data_partida, Date horario_partida) {
		this.id_partida = id_partida;
		this.id_esporte = id_esporte;
		this.nome_partida = nome_partida;
		this.data_partida = data_partida;
		this.horario_partida = horario_partida;
	}

	public int getId_partida() {
		return id_partida;
	}

	public void setId_partida(int id_partida) {
		this.id_partida = id_partida;
	}

	public int getId_esporte() {
		return id_esporte;
	}

	public void setId_esporte(int id_esporte) {
		this.id_esporte = id_esporte;
	}

	public String getNome_partida() {
		return nome_partida;
	}

	public void setNome_partida(String nome_partida) {
		this.nome_partida = nome_partida;
	}

	public Date getData_partida() {
		return data_partida;
	}

	public void setData_partida(Date data_partida) {
		this.data_partida = data_partida;
	}

	public Date getHorario_partida() {
		return horario_partida;
	}

	public void setHorario_partida(Date horario_partida) {
		this.horario_partida = horario_partida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_esporte;
		result = prime * result + id_partida;
		result = prime * result + ((nome_partida == null) ? 0 : nome_partida.hashCode());
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
		Partida other = (Partida) obj;
		if (id_esporte != other.id_esporte)
			return false;
		if (id_partida != other.id_partida)
			return false;
		if (nome_partida == null) {
			if (other.nome_partida != null)
				return false;
		} else if (!nome_partida.equals(other.nome_partida))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Partida [id_partida=" + id_partida + ", id_esporte=" + id_esporte + ", nome_partida=" + nome_partida
				+ ", data_partida=" + data_partida + ", horario_partida=" + horario_partida + "]";
	}
	
	
	
}
