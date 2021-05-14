package model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dbProperties.DB;
import dbProperties.DbException;
import dbProperties.DbIntegrityException;
import model.dao.DaoPartida;
import model.entities.Partida;

public class PartidaDaoJDBC implements DaoPartida{

	private Connection conn;
	
	public PartidaDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Partida obj) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO partida "
					+ "(id_partida, nome_partida, id_esporte, data_partida, id_estadio) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, obj.getId_partida());
			st.setString(2, obj.getNome_partida());
			st.setInt(3, obj.getId_esporte());
			st.setDate(4, new java.sql.Date(sdf.parse(obj.getData_partida().getTime())));
			st.setInt(5, obj.getId_estadio());
			
			int rowsAffected = st.executeUpdate();	
			
			if(rowsAffected==0) {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}catch (ParseException e) {
			e.printStackTrace();
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Partida obj) { //so pode alterar a data do jogo
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE partida "
					+ "SET data_partida = ? "
					+ "WHERE id_partida = ?");
			
			st.setDate(1, (Date) obj.getData_partida());
			st.setInt(2, obj.getId_partida());
			
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
			st = conn.prepareStatement("DELETE FROM partida WHERE id_partida = ?");
			st.setInt(1, id);
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Partida> findByEstadio(Integer id_estadio) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM partida WHERE nome_estadio = ?");
			st.setInt(1, id_estadio);
			rs = st.executeQuery();
			
			List<Partida> list = new ArrayList<>();
			
			while(rs.next()) {
				Partida obj = new Partida();
				obj.setId_partida(rs.getInt("id_partida"));
				obj.setNome_partida(rs.getString("nome_partida"));
				obj.setId_esporte(rs.getInt("id_esporte"));
				obj.setData_partida(rs.getDate("data_partida"));
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
	public List<Partida> findByEsporte(Integer id_esporte) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM partida WHERE id_esporte = ?");
			st.setInt(1, id_esporte);
			rs = st.executeQuery();
			
			List<Partida> list = new ArrayList<>();
			
			while(rs.next()) {
				Partida obj = new Partida();
				obj.setId_partida(rs.getInt("id_partida"));
				obj.setNome_partida(rs.getString("nome_partida"));
				obj.setId_estadio(rs.getInt("id_estadio"));
				obj.setData_partida(rs.getDate("data_partida"));
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
	public List<Partida> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM estadio");
			rs = st.executeQuery();
			
			List<Partida> list = new ArrayList<>();
			
			while(rs.next()) {
				Partida obj = new Partida();
				obj.setId_partida(rs.getInt("id_partida"));
				obj.setNome_partida(rs.getString("nome_partida"));
				obj.setId_esporte(rs.getInt("id_esporte"));
				obj.setData_partida(rs.getDate("data_partida"));
				obj.setId_estadio(rs.getInt("id_estadio"));
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

}
