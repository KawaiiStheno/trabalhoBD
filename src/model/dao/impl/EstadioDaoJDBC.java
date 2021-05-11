package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dbProperties.DB;
import dbProperties.DbException;
import model.dao.DaoEstadio;
import model.entities.Estadio;

public class EstadioDaoJDBC implements DaoEstadio{
	
	private Connection conn;
	
	public EstadioDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Estadio obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO estadio "
					+ "(nome_estadio, quant_ingresso, estado, cidade) "
					+ "VALUES "
					+ "(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNome_estadio());
			st.setInt(2, obj.getQuant_ingresso());
			st.setString(3, obj.getEstado());
			st.setString(4, obj.getCidade());
			
			if(st.executeUpdate()<0) {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Estadio obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE estadio "
					+ "SET quant_ingresso = ? "
					+ "WHERE nome_estadio = ?");
			
			st.setInt(1, obj.getQuant_ingresso());
			st.setString(2, obj.getNome_estadio());
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
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
