package model.dao;

import java.util.List;

import model.entities.Ingresso;

public interface DaoIngresso {

	void insert(Ingresso obj);
	void update(Ingresso obj);
	void deleteById(Ingresso id);
	Ingresso findById(Integer id);
	Ingresso findByPartida(Integer idPartida);
	Ingresso findByEstadio(String nomeEstadio);
	List<Ingresso> findAll();
}
