package model.dao;

import java.util.List;

import model.entities.Partida;

public interface DaoPartida {

	void insert(Partida obj);
	void update(Partida obj);
	void deleteById(Integer id);
	List<Partida> findByEstadio(Integer id_estadio);
	List<Partida> findByEsporte(Integer id_esporte);
	List<Partida> findAll();
}
