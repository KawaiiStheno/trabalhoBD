package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.DaoUsuario;
import model.entities.Usuario;

public class UsuarioDaoJDBC implements DaoUsuario{

	private Connection conn;
	
	public UsuarioDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBycpf(String cpf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario findByCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
