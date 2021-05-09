package model.dao;

import java.util.List;

import model.entities.Partida;

public interface DaoPartida {

	void insert(Partida obj);
	void update(Partida obj);
	void deleteById(Integer id);
	Partida findById(Integer id);
	Partida findByEsporte(Integer idEsporte);
	List<Partida> findAll();
}
