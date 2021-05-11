package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Statement;

import dbProperties.DB;
import dbProperties.DbException;
import model.dao.DaoCartao;
import model.entities.Cartao;
import model.entities.Usuario;

public class CartaoDaoJDBC implements DaoCartao{

	private Connection conn;
	
	public CartaoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Cartao obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO cartao_credito"
					+ "(cpf, numero, validade, cod_seguranca)"
					+ "VALUES"
					+ "(?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getCpf());
			st.setString(2, obj.getNumero());
			st.setString(3, obj.getValidade());
			st.setInt(4, obj.getCod_segurança());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected>0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId_cartao(id);
				}
				DB.closeResultSet(rs);
			}else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Cartao obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE cartao_credito"
					+ "SET id_cartao = ?, cpf = ?, numero = ?, validade = ?, cod_seguranca = ?"
					+ "WHERE cpf = ?");
			
			st.setInt(1, obj.getId_cartao());
			st.setString(2, obj.getCpf());
			st.setString(3, obj.getNumero());
			st.setString(4, obj.getValidade());
			st.setInt(5, obj.getCod_segurança());
			st.setString(6, obj.getCpf());
			
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
			st = conn.prepareStatement("DELETE FROM cartao_credito WHERE id_cartao = ?");
			st.setInt(1, id);
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	private Cartao instantiateCartao(ResultSet rs, Usuario us) throws SQLException{
		Cartao obj = new Cartao();
		obj.setId_cartao(rs.getInt("id_cartao"));
		obj.setCpf(rs.getString("cpf"));
		obj.setNumero(rs.getString("numero"));
		obj.setValidade(rs.getString("validade"));
		obj.setCod_seguranca(rs.getInt("cod_seguranca"));
		obj.setUsuario(us);
		return obj;
	}
	
	
	@Override
	public List<Cartao> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT cartao_credito.*, usuario.cpf as Dono"
					+ "FROM cartap_credito INNER JOIN usuario"
					+ "ON cartao_credito.cpf = usuario.cpf");
			rs = st.executeQuery();
			
			List<Cartao> list = new ArrayList<>();
			Map<Integer, Usuario>map = new HashMap<>();
			
			while(rs.next()) {
				Usuario us = map.get(rs.getString("cpf"));
				
				Cartao obj = instantiateCartao(rs, us);
				list.add(obj);
			}
			return list;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Cartao> findByCpf(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
