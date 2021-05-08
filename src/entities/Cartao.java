package entities;

import java.io.Serializable;

public class Cartao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id_cartao;
	private String cpf;
	private String numero;
	private String validade;
	private int cod_seguran�a;
	
	public Cartao(int id_cartao, String cpf, String numero, String validade, int cod_seguran�a) {
		this.id_cartao = id_cartao;
		this.cpf = cpf;
		this.numero = numero;
		this.validade = validade;
		this.cod_seguran�a = cod_seguran�a;
	}

	public int getId_cartao() {
		return id_cartao;
	}

	public void setId_cartao(int id_cartao) {
		this.id_cartao = id_cartao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public int getCod_seguran�a() {
		return cod_seguran�a;
	}

	public void setCod_seguran�a(int cod_seguran�a) {
		this.cod_seguran�a = cod_seguran�a;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod_seguran�a;
		result = prime * result + id_cartao;
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
		Cartao other = (Cartao) obj;
		if (cod_seguran�a != other.cod_seguran�a)
			return false;
		if (id_cartao != other.id_cartao)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cartao [id_cartao=" + id_cartao + ", cpf=" + cpf + ", numero=" + numero + ", validade=" + validade
				+ ", cod_seguran�a=" + cod_seguran�a + "]";
	}
	
	
	
}
