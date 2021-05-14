package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbProperties.DB;
import dbProperties.DbException;
import dbProperties.DbIntegrityException;
import model.dao.DaoTipoEsporte;
import model.entities.TipoEsporte;

public class TipoEsporteDaoJDBC implements DaoTipoEsporte{

	private Connection conn;
	
	public TipoEsporteDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(TipoEsporte obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
<<<<<<< HEAD
					"INSERT INTO tipo_esporte "
					+ "(nome_esporte) "
					+ "VALUES "
					+ "(?)", Statement.RETURN_GENERATED_KEYS);
			
=======
					"INSERT INTO tipo_esporte"
					+ "(nome_esporte)"
					+ "VALUES"
					+ "(?)", 
					Statement.RETURN_GENERATED_KEYS);
>>>>>>> d07f0561e414185ab08faa2f11c3165a88074c4c
			st.setString(1, obj.getNome_esporte());
			
			int rowsAffected = st.executeUpdate();
			
<<<<<<< HEAD
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
			}else {
=======
			if(rowsAffected==0) {
>>>>>>> d07f0561e414185ab08faa2f11c3165a88074c4c
				throw new DbException("Unexpected error! No rows affected!");
			}
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
<<<<<<< HEAD
	public void update(TipoEsporte obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE tipo_esporte "
					+"SET nome_esporte = ?"
					+"WHERE id_esporte = ?");
			st.setString(1, obj.getNome_esporte());
			st.setInt(2, obj.getId());
			
			st.executeUpdate();
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM tipo_esporte WHERE id_esporte = ?");
			st.setInt(1, id);
			st.executeUpdate();
		
		}catch(SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public TipoEsporte findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM tipo_esporte WHERE id_esporte = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				TipoEsporte obj = new TipoEsporte();
				obj.setId(rs.getInt("id_esporte"));
				obj.setNome_esporte(rs.getString("nome_esporte"));
				return obj;
			}
			return null;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

=======
	public void deleteByNome_esporte(String nome_esporte) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM tipo_esporte WHERE nome_esporte = ? ");
			st.setString(1, nome_esporte);
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}
	
>>>>>>> d07f0561e414185ab08faa2f11c3165a88074c4c
	@Override
	public List<TipoEsporte> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
<<<<<<< HEAD
			st = conn.prepareStatement("SELECT * FROM tipo_esporte ORDER BY nome_esporte");
=======
			st = conn.prepareStatement("SELECT * FROM tipo_esporte");
>>>>>>> d07f0561e414185ab08faa2f11c3165a88074c4c
			rs = st.executeQuery();
			
			List<TipoEsporte> list = new ArrayList<>();
			
			while(rs.next()) {
				TipoEsporte obj = new TipoEsporte();
<<<<<<< HEAD
				obj.setId(rs.getInt("id_esporte"));
=======
				obj.setId_esporte(rs.getInt("id_esporte"));
>>>>>>> d07f0561e414185ab08faa2f11c3165a88074c4c
				obj.setNome_esporte(rs.getString("nome_esporte"));
				list.add(obj);
			}
			return list;
<<<<<<< HEAD
			
=======
>>>>>>> d07f0561e414185ab08faa2f11c3165a88074c4c
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
