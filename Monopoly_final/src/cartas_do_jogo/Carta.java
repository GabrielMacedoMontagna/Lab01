package cartas_do_jogo;

import main.Jogador;

public abstract class Carta {
	private int id;
	private String descricao;
	protected Jogador dono;
	private TipoCarta tipo;
	private static int contadorId = 0;
	
	//construtor sem dono.
	public Carta(String descricao, TipoCarta tipo) {
		contadorId++;
		this.id = contadorId;
		this.descricao = descricao;
		this.tipo = tipo;
		this.dono = null;
	}
	
	//construtor com dono.
	public Carta(String descricao, Jogador dono, TipoCarta tipo) {
		
		contadorId++;
		this.id = contadorId;
		this.descricao = descricao;
		this.dono = dono;
		this.tipo = tipo;
		dono.adicionaCarta(this);
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
	
	public TipoCarta getTipo() {
		return tipo;
	}
	
	//setters.
	public void setDono(Jogador donoNovo) {
		dono = donoNovo;
	}
}
