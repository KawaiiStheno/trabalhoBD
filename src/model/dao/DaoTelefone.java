package model.dao;

import java.util.List;

import model.entities.Telefone;

public interface DaoTelefone {

	void insert(Telefone obj);
	void update(Telefone obj);
	void deleteByCpf(String cpf);
	Telefone findBycpf(String cpf);
	List<Telefone> findAll();
}
