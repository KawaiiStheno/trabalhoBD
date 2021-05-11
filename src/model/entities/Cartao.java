package model.entities;

import java.io.Serializable;

public class Cartao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id_cartao;
	private String cpf;
	private String numero;
	private String validade;
	private int cod_seguranca;
	
	private Usuario usuario;
	
	public Cartao(String cpf, String numero, String validade, int cod_seguranca, Usuario usuario) {
		this.cpf = cpf;
		this.numero = numero;
		this.validade = validade;
		this.cod_seguranca = cod_seguranca;
		this.usuario = usuario;
	}

	public Cartao() {
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

	public int getCod_segurança() {
		return cod_seguranca;
	}

	public void setCod_seguranca(int cod_segurança) {
		this.cod_seguranca = cod_segurança;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod_seguranca;
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
		if (cod_seguranca != other.cod_seguranca)
			return false;
		if (id_cartao != other.id_cartao)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cartao [id_cartao=" + id_cartao + ", cpf=" + cpf + ", numero=" + numero + ", validade=" + validade
				+ ", cod_segurança=" + cod_seguranca + "]";
	}
	
	
	
}
