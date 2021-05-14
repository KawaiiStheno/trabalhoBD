package model.dao;

import model.entities.Telefone;

public interface DaoTelefone {

	void insert(Telefone obj);
<<<<<<< HEAD
	void update(Telefone obj);
	void deleteByNumero(String numero);
	Telefone findByNumero(String numero);
	List<Telefone> findAll();
=======
	void update(String antigo, String novo);
	void deleteByFone(String fone);
	void findAll(Integer id_usuario);
>>>>>>> d07f0561e414185ab08faa2f11c3165a88074c4c
}
