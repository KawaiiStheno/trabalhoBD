package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dbProperties.DB;
import dbProperties.DbException;
import model.dao.DaoGerente;
import model.entities.Gerente;

public class GerenteDaoJDBC implements DaoGerente{

	private Connection conn;
	
	public GerenteDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Gerente obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO gerente "
					+ "()");
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Gerente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Gerente findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gerente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
