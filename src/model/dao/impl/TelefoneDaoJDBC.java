package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.DaoTelefone;
import model.entities.Telefone;

public class TelefoneDaoJDBC implements DaoTelefone{

	private Connection conn;
	
	public TelefoneDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Telefone obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Telefone obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByCpf(String cpf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Telefone findBycpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Telefone> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
