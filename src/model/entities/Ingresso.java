package model.entities;

import java.io.Serializable;

public class Ingresso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id_ingresso;
	private int id_partida;
	private String preco;
	private int quant_ingresso;
	private int id_estadio;
	
	public Ingresso(int id_partida, String preco, int quant_ingresso, int id_estadio) {
		this.id_partida = id_partida;
		this.preco = preco;
		this.quant_ingresso = quant_ingresso;
		this.id_estadio = id_estadio;
	}
	
	public Ingresso() {}

	public int getId_ingresso() {
		return id_ingresso;
	}

	public void setId_ingresso(int id_ingresso) {
		this.id_ingresso = id_ingresso;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public int getId_partida() {
		return id_partida;
	}

	public void setId_partida(int id_partida) {
		this.id_partida = id_partida;
	}

	public int getQuant_ingresso() {
		return quant_ingresso;
	}

	public void setQuant_ingresso(int quant_ingresso) {
		this.quant_ingresso = quant_ingresso;
	}

	public int getId_estadio() {
		return id_estadio;
	}

	public void setId_estadio(int id_estadio) {
		this.id_estadio = id_estadio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_ingresso;
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
		Ingresso other = (Ingresso) obj;
		if (id_ingresso != other.id_ingresso)
			return false;
		if (id_partida != other.id_partida)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ingresso [id_ingresso=" + id_ingresso + ", preco=" + preco + ", id_partida=" + id_partida
				+ ", quant_ingresso=" + quant_ingresso + ", id_estadio=" + id_estadio + "]";
	}
	
	
	
}
