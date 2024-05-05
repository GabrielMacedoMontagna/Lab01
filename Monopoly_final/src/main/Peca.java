package main;


public class Peca {
	private int posicao;
	private String cor;
	
	//Construtor.
	public Peca(String cor) {
		this.posicao = 0;
		this.cor = cor;
	}
	
	//Getters e Setters.
	public int getPosicao() {
		return posicao;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String toString() {
		
		String out = "";
		
		out += "Cor: " + cor + "\n";
		out += "Posição no tabuleiro: " + posicao + "\n";
		
		return out;
	}
}
