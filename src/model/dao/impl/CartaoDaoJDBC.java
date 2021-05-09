package model.dao.impl;

import java.sql.Connection;
import java.util.List;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Cartao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cartao deleteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cartao> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cartao> findByCpf(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
