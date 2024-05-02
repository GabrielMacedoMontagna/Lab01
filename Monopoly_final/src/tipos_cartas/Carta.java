package tipos_cartas;

import main.Jogador;

public class Carta {
	private int id;
	private String descricao;
	protected Jogador dono;
	private static int contadorId = 0;
	
	//construtor sem dono.
	public Carta(String descricao) {
		contadorId++;
		this.id = contadorId;
		this.descricao = descricao;
	}
	
	//construtor com dono.
	public Carta(String descricao, Jogador dono) {
		
		contadorId++;
		this.id = contadorId;
		this.descricao = descricao;
		this.dono = dono;
	}
	
	//getters.
	public int getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Jogador getDono() {
		return dono;
	}
	
	//setters.
	//aqui, nao faz sentido haver setter para id ou descricao da carta.
	public void setDono(Jogador donoNovo) {
		dono = donoNovo;
	}
}
