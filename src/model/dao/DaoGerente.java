package model.dao;

import model.entities.Gerente;

public interface DaoGerente {

	void insert(Gerente obj);
	void update(Gerente obj);
	void deleteById(Integer id);
	Gerente findById(Integer id);
}
