package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.DaoEstadio;
import model.entities.Estadio;

public class EstadioDaoJDBC implements DaoEstadio{
	
	private Connection conn;
	
	public EstadioDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Estadio obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Estadio obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByNome(String nome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Estadio findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estadio findbtEstado(String estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estadio> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
