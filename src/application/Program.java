package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoAplication;
import model.dao.DaoUsuario;
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
		
		daoUsuario.deleteBycpf("771221");
		
		sc.close();
	}

}
