package model.dao;

import java.util.List;

import model.entities.TipoEsporte;

public interface DaoTipoEsporte {

	void insert(TipoEsporte obj);
	void update(TipoEsporte obj);
	void deleteById(Integer id);
	TipoEsporte findById(Integer id);
	List<TipoEsporte> findAll();
}
