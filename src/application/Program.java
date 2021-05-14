package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoAplication;
import model.dao.DaoCartao;
import model.dao.DaoEstadio;
import model.dao.DaoJogosDisponiveis;
import model.dao.DaoTipoEsporte;
import model.dao.DaoUsuario;
import model.entities.Cartao;
import model.entities.Estadio;
import model.entities.JogosDisponiveis;
import model.entities.TipoEsporte;
import model.entities.Usuario;

public class Program {

	public static void main(String[] args) throws ParseException{
		
		Scanner sc = new Scanner(System.in);
		int entrada=-1;
		
		DaoUsuario daoUsuario = DaoAplication.createDaoUsuario();
		DaoEstadio daoEstadio = DaoAplication.createDaoEstadio();
		DaoJogosDisponiveis daoJogos = DaoAplication.createDaoJogosDisponiveis();
		DaoCartao daoCartao = DaoAplication.createDaoCartao();
		DaoTipoEsporte daoTipoEsporte = DaoAplication.createDaoTipoEsporte();
		
		System.out.println("BEM VINDO!!!");
		while(entrada!=0) {
			System.out.print("O que deseja fazer?\n"
					+ "1 - Cadastrar um novo usuario;\n"
					+ "2 - Visualizar os Estádios;\n"
					+ "3 - Visualizar os Jogos Disponiveis;\n"
					+ "4 - Cadastrar um novo Cartao de Credito;\n"
					+ "5 - Visualizar os Tipos de Esporte;\n"
					+ "6 - Receber um arquivo externo;\n"
					+ "0 - Sair do Programa.\n"
					+ "Sua Escolha: ");
			entrada = sc.nextInt();
			switch(entrada) {
			case 1:
				System.out.print("\nDigite o seu nome: ");
				String nome = sc.nextLine();
				System.out.print("\nDigite a sua nova senha: ");
				String senha = sc.nextLine();
				System.out.print("\nDigite o seu cpf: ");
				String cpf = sc.nextLine();
				System.out.print("\nDigite a sua idade: ");
				int idade = sc.nextInt();
				Usuario usuario = new Usuario(cpf, senha, nome, idade);
				daoUsuario.insert(usuario);
				System.out.println("Usuario inserido com sucesso!");
				break;
			case 2:
				System.out.print("Como deseja encontrar os Estadios?\n"
						+ "1 - Encontrar por nome;\n"
						+ "2 - Encontrar por estado;\n"
						+ "3 - Encontrar todos."
						+ "Sua Escolha: ");
				int escolha = sc.nextInt();
				switch(escolha) {
				case 1:
					System.out.print("\nDigite o nome do Estadio: ");
					sc.nextLine();
					String nome_estadio = sc.nextLine();
					Estadio estadio = daoEstadio.findByNome(nome_estadio);
					System.out.println(estadio);
					break;
				case 2:
					System.out.println("\nDigite a sigla do estado (Ex: AM, DF, etc): ");
					sc.nextLine();
					String estado = sc.nextLine();
					Estadio estadio2 = daoEstadio.findbtEstado(estado);
					System.out.println(estadio2);
					break;
				case 3:
					List<Estadio> list = daoEstadio.findAll();
					for(Estadio e : list) {
						System.out.println(e);
					}
					break;
				}
			case 3:
				System.out.println("Como deseja encontrar as Partidas Disponiveis?\n"
						+ "1 - Encontrar pelo Id;\n"
						+ "2 - Encontrar todas.\n"
						+ "Sua Escolha: ");
				int escolha2 = sc.nextInt();
				switch(escolha2) {
				case 1:
					System.out.print("Digite o Id: ");
					int id = sc.nextInt();
					JogosDisponiveis jogos = daoJogos.findById(id);
					System.out.println(jogos);
					break;
				case 2:
					List<JogosDisponiveis> jogosDisp = daoJogos.findAll();
					for(JogosDisponiveis j : jogosDisp) {
						System.out.println(j);
					}
					break;
				}
			case 4:
				
				System.out.print("Primeiro, digite seu cpf: ");
				sc.nextLine();
				String cpfUsuario = sc.nextLine();
				Usuario usuario3 = daoUsuario.findByCpf(cpfUsuario);
				System.out.print("Digite o numero do cartao: ");
				String numero = sc.nextLine();
				System.out.print("Digite a data de validade: ");
				String validade = sc.nextLine();
				System.out.print("Digite o codigo de segurança: ");
				int cod_seguranca = sc.nextInt();
				
				Cartao cartao = new Cartao(numero, validade, cod_seguranca, usuario3);
				daoCartao.insert(cartao);
				System.out.println("Cartao inserido com sucesso");
				break;
			case 5:
				
				System.out.print("Como deseja encontar o tipo de esporte?"
						+ "1 - Encontar pelo Id;\n"
						+ "2 - Encontrar todos.\n"
						+ "Sua Escolha: ");
				
				int escolha3 = sc.nextInt();
				
				switch(escolha3) {
				
				case 1:
					
					System.out.print("Digite o Id do tipo de esporte: ");
					int idEsporte = sc.nextInt();
					
					TipoEsporte tipoEsporte = daoTipoEsporte.findById(idEsporte);
					System.out.println(tipoEsporte);
					
					break;
					
				case 2:
					
					List<TipoEsporte> listaEsporte = daoTipoEsporte.findAll();
					
					for(TipoEsporte t : listaEsporte) {
						System.out.println(t);
					}
					
					break;
				}
				
				break;
				
			case 6:
				
				sc.nextLine();
				System.out.print("Digite o caminho do arquivo: ");
				String sourceFileStr = sc.nextLine();
				
				try(BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){
					
					String itemCsv = br.readLine();
					while(itemCsv != null) {
						
						String[] fields = itemCsv.split(",");
						String nomeU = fields[0];
						String cpfU = fields[1];
						String senhaU = fields[2];
						int idadeU = Integer.parseInt(fields[3]);
						
						Usuario usuarioArquivo = new Usuario(cpfU, senhaU, nomeU, idadeU);
						daoUsuario.insert(usuarioArquivo);
					}
				}catch(IOException e) {
					System.out.println("ERROR READING FILE: "+ e.getMessage());
				}
				break;
			}
		}
		
		
		sc.close();
	}

}
