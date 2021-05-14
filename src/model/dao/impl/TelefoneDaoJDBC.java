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
import model.dao.DaoTelefone;
import model.entities.Telefone;

public class TelefoneDaoJDBC implements DaoTelefone {

	private Connection conn;

	public TelefoneDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Telefone obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO telefone " 
					+ "(numero, id_usuario) " 
					+ "VALUES " 
					+ "(?, ?)",	Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getNumero());
			st.setInt(2, obj.getId_usuario());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId_fone(id);
				}
			} else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Telefone obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE telefone " + "SET numero = ?" + "WHERE id_usuario = ?");
			st.setString(1, obj.getNumero());
			st.setInt(2, obj.getId_usuario());

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteByNumero(String numero) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM telefone WHERE numero = ?");
			
			st.setString(1, numero);
			
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public Telefone findByNumero(String numero) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT telefone.*,usuario.nome "
					+ "FROM telefone INNER JOIN usuario "
					+ "ON telefone.id_usuario = usuario.id_usuario "
					+ "WHERE telefone.numero = ?");
			st.setString(1, numero);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Telefone tel = new Telefone(rs.getInt("id_fone"), rs.getString("numero"), rs.getInt("id_usuario"));
				return tel;
			}
			return null;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Telefone> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT telefone.*,usuario.nome "
					+ "FROM telefone INNER JOIN usuario "
					+ "ON telefone.id_usuario = usuario.id_usuario "
					+ "ORDER BY id_fone");
		
			rs = st.executeQuery();
			List<Telefone> list = new ArrayList<>();
			
			while(rs.next()) {
				Telefone tel = new Telefone(rs.getInt("id_fone"), rs.getString("numero"), rs.getInt("id_usuario"));
				list.add(tel);
				return list;
			}
			return null;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
