package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.DaoPartida;
import model.entities.Partida;

public class PartidaDaoJDBC implements DaoPartida{

	private Connection conn;
	
	public PartidaDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Partida obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Partida obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Partida findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Partida findByEsporte(Integer idEsporte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Partida> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
