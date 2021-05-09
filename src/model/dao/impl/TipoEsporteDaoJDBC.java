package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.DaoTipoEsporte;
import model.entities.TipoEsporte;

public class TipoEsporteDaoJDBC implements DaoTipoEsporte{

	private Connection conn;
	
	public TipoEsporteDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(TipoEsporte obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TipoEsporte obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TipoEsporte findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoEsporte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
