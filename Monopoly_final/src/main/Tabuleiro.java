package main;

import java.util.ArrayList;
import tipos_cartas.Propriedade;
import tipos_cartas.Carta;

public class Tabuleiro {
	private ArrayList<Jogador> jogadores;
	private ArrayList<Propriedade> propriedades;
	private ArrayList<Carta> cartas; //nao estava no UML, mas ajuda muito a lidar com todas as cartas na ordem do id de cada uma. nao fiz metodo pra ela ainda.
	
	//Construtor.
	public Tabuleiro() {
		jogadores = new ArrayList<Jogador>();
		propriedades = new ArrayList<Propriedade>();
	}
	
	public void addJogador(Jogador jogadorNovo) {
		
		//verifica se o array esta vazio.
		if (jogadores.isEmpty()) {
			jogadores.add(jogadorNovo);

		}
		
		//verifica se o jogador ja esta no array.
		else if (!jogadores.contains(jogadorNovo)) {
			jogadores.add(jogadorNovo);
		}
	}
	
	public void removeJogador(Jogador jogadorRemovido) {
		
		//verifica se o array nao esta vazio e se o jogador procurado esta no array.
		if (!jogadores.isEmpty() && jogadores.contains(jogadorRemovido)) {
			jogadores.remove(jogadorRemovido);
		}
	}
	
	public void addPropriedade(Propriedade propriedadeNova) {

		//verifica se o array esta vazio.
		if (propriedades.isEmpty()) {
			propriedades.add(propriedadeNova);

		}
		
		//verifica se a propriedade ja esta no array.
		else if (!propriedades.contains(propriedadeNova)) {
			propriedades.add(propriedadeNova);
		}
		
	}
	
	public void removePropriedade(Propriedade propriedadeRemovida) {
		
		//verifica se o array nao esta vazio e se a propriedade procurada esta no array.
		if (!propriedades.isEmpty() && propriedades.contains(propriedadeRemovida)) {
			propriedades.remove(propriedadeRemovida);
		}
	}
}
