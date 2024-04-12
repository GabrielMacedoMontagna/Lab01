package main;

import java.util.ArrayList;

public class Tabuleiro {
	private ArrayList<Integer> jogadores;
	private ArrayList<Integer> propriedades;
	
	//Construtor.
	public Tabuleiro() {
	}
	
	public void addJogador(Integer id_jogador) {
		
		//verifica se o array esta vazio.
		if (jogadores.isEmpty()) {
			jogadores.add(id_jogador);

		}
		
		//verifica se o jogador ja esta no array.
		else if (!jogadores.contains(id_jogador)) {
			jogadores.add(id_jogador);
		}
	}
	
	public void removeJogador(Integer id_jogador) {
		
		//verifica se o array nao esta vazio e se o jogador procurado esta no array.
		if (!jogadores.isEmpty() && jogadores.contains(id_jogador)) {
			jogadores.remove(id_jogador);
		}
	}
	
	public void addPropriedade(Integer id_propriedade) {

		//verifica se o array esta vazio.
		if (propriedades.isEmpty()) {
			propriedades.add(id_propriedade);

		}
		
		//verifica se a propriedade ja esta no array.
		else if (!propriedades.contains(id_propriedade)) {
			propriedades.add(id_propriedade);
		}
		
	}
	
	public void removePropriedade(Integer id_propriedade) {
		
		//verifica se o array nao esta vazio e se a propriedade procurada esta no array.
		if (!jogadores.isEmpty() && jogadores.contains(id_propriedade)) {
			jogadores.remove(id_propriedade);
		}
	}
}
