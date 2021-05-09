package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.DaoIngresso;
import model.entities.Ingresso;

public class IngressoDaoJDBC implements DaoIngresso{

	private Connection conn;
	
	public IngressoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Ingresso obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Ingresso obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Ingresso id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ingresso findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ingresso findByPartida(Integer idPartida) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ingresso findByEstadio(String nomeEstadio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ingresso> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
