package main;

import java.util.ArrayList;
import java.util.Scanner;
import cartas_do_jogo.CartaSorte;
import cartas_do_jogo.Propriedade;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tabuleiro implements Salvavel {
	private int numJogadores;
	private int eliminados;
	private int tamTabuleiro = 20;
	private ArrayList<Jogador> jogadores;
	private ArrayList<CartaSorte> cartas;
	private Propriedade vetorTabuleiro[];
	
	//Construtor.
	public Tabuleiro(int numJogadores) {
		this.numJogadores = numJogadores;
		this.eliminados = 0;
		
		jogadores = new ArrayList<Jogador>();
		cartas = new ArrayList<CartaSorte>();
		vetorTabuleiro = new Propriedade[20];
	}
	
	//getters.
	public int getNumJog() {
		return numJogadores;
	}
	
	public int getEliminados() {
		return eliminados;
	}
	
	public int getTamTabuleiro() {
		return tamTabuleiro;
	}
	
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}
	
	public ArrayList<CartaSorte> getCartas(){
		return cartas;
	}
	
	public Propriedade[] getVetorTabuleiro() {
		return vetorTabuleiro;
	}
	
	//demais métodos.
	public void addJogador(Jogador jogadorNovo) {
		//verifica se o jogador ja esta no array.
		if (!jogadores.contains(jogadorNovo)) {
			jogadores.add(jogadorNovo);
		}
	}
	
	public void addJogador(Scanner leitura) {
		String nome, cpf, email, foto, corPeca;
		
		System.out.println("Digite o nome do participante:");
		nome = leitura.nextLine();
		
		System.out.println("Digite o CPF do participante:");
		cpf = leitura.nextLine();
		
		while (!Validacao.validarCpf(cpf)) {
			System.out.println("CPF inválido, tente novamente:");
			cpf = leitura.nextLine();
		}
		
		System.out.println("Digite o e-mail do participante:");
		email = leitura.nextLine();
		
		while (!Validacao.validarEmail(email)) {
			System.out.println("E-mail inválido, tente novamente:");
			email = leitura.nextLine();
		}
		
		System.out.println("Insira o link para foto do participante:");
		foto = leitura.nextLine();
		
		System.out.println("Qual a cor da peça do jogador?");
		corPeca = leitura.nextLine();
		
		Jogador jogadorNovo = new Jogador(nome, cpf, email, foto, corPeca);
		
		//verifica se o jogador ja esta no array.
		if (!jogadores.contains(jogadorNovo)) {
			jogadores.add(jogadorNovo);
		}
	}
	
	public void removeJogador(Jogador jogadorRemovido) {
		
		//verifica se o array nao esta vazio e se o jogador procurado esta no array.
		if (!jogadores.isEmpty() && jogadores.contains(jogadorRemovido)) {
			jogadores.remove(jogadorRemovido);
			numJogadores--;
		}
	}
	
	public void eliminar() {
		eliminados++;
	}
	
	public void addPropriedade(Propriedade propNova) {
		vetorTabuleiro[propNova.getPosicao()] = propNova;
	}
	
	public void addCartaSorte(CartaSorte CS) {
		//verifica se a carta ja esta no tabuleiro.
		if (!cartas.contains(CS)) {
			cartas.add(CS);
		}
	}
	
	//salvaLog.
	public void salvaLog(String acao) {
		String caminhoArquivo = "Log.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, true))){
			
			bw.write(acao);
			bw.newLine();
			
			System.out.println(acao);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void lerLog() {
		
		String caminhoArquivo = "Log.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void limpaLog() {
		String caminhoArquivo = "Log.txt";
		
		try (FileWriter fw = new FileWriter(caminhoArquivo)) {
			//esse bloco vazio limpa o Log das ações.
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
}
