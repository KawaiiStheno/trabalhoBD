package model.dao;

import java.util.List;

import model.entities.Telefone;

public interface DaoTelefone {

	void insert(Telefone obj);
	void update(Telefone obj);
	void deleteByNumero(String numero);
	Telefone findByNumero(String numero);
	List<Telefone> findAll();
}
