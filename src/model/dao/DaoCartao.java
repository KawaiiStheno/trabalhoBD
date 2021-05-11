package model.dao;

import java.util.List;

import model.entities.Cartao;
import model.entities.Usuario;

public interface DaoCartao {

	void insert(Cartao obj);
	void update (Cartao obj);
	void deleteById(Integer id);
	List<Cartao> findAll();
	List<Cartao> findByCpf(Usuario usuario);
}
