package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoAplication;
import model.dao.DaoCartao;
import model.dao.DaoEstadio;
import model.dao.DaoUsuario;
import model.entities.Cartao;
import model.entities.Estadio;
import model.entities.Usuario;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DaoUsuario daoUsuario = DaoAplication.createDaoUsuario();
		
		Usuario newUsuario = new Usuario("771221","ronal","roberto",12);
		daoUsuario.insert(newUsuario);
		
		Usuario newUsuario2 = new Usuario("771225","ron","roberta",12);
		daoUsuario.insert(newUsuario2);
		
		Usuario usu2 = daoUsuario.findByCpf("771221");
		usu2.setSenha("arroz");
		daoUsuario.update(usu2);
		
		Usuario us = daoUsuario.findByCpf("771221");
		System.out.println(us);
		
		List<Usuario> list = daoUsuario.findAll();
		
		for(Usuario u : list) {
			System.out.println(u);
		}
		
		DaoCartao daoCartao = DaoAplication.createDaoCartao();
		
		Cartao cartao = new Cartao("12345", "0434", 543, newUsuario);
		daoCartao.insert(cartao);
		
		List<Cartao> cartao2 = daoCartao.findAll();
		
		for(Cartao c : cartao2) {
			System.out.println(c);
		}
		
		daoUsuario.deleteBycpf("771221");
		daoUsuario.deleteBycpf("771225");
		
		System.out.println("\n");
		
		DaoEstadio daoEstadio = DaoAplication.createDaoEstadio();
		
		Estadio newEstadio = new Estadio("quadrado", 1, "DF", "Brasil");
		daoEstadio.insert(newEstadio);
		
		Estadio estadio = new Estadio("bolota", 45, "CE", "acre");
		daoEstadio.insert(estadio);
		
		Estadio teste = daoEstadio.findbtEstado("DF");
		System.out.println(teste);
		
		Estadio teste2 = daoEstadio.findByNome("bolota");
		System.out.println(teste2);
		
		List<Estadio> list2 = daoEstadio.findAll();
		
		for(Estadio e : list2) {
			System.out.println(e);
		}
		
		daoEstadio.deleteByNome("quadrado");
		daoEstadio.deleteByNome("bolota");
		
		
		
		
		sc.close();
	}

}
