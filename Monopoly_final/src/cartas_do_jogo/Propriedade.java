package cartas_do_jogo;

import main.Jogador;


public abstract class Propriedade extends Carta {
	private int preco;
	private int aluguel;
	private int posicao;
	protected Jogador dono;
	private String nome;
	
	//construtor sem dono.
	public Propriedade(int preco, int aluguel, int posicao, String nome, String descricao, TipoCarta tipo) {
		
		super(descricao, tipo);
		
				
		this.preco = preco;
		this.aluguel = aluguel;
		this.posicao = posicao;
		this.dono = null;
		this.nome = nome;
		this.posicao = posicao;
	}
	
	//construtor com dono.
	public Propriedade(int preco, int aluguel, int posicao, String nome, String descricao, TipoCarta tipo, Jogador dono) {
				
		super(descricao, dono, tipo);
		
				
		this.preco = preco;
		this.aluguel = aluguel;
		this.posicao = posicao;
		this.nome = nome;
		this.posicao = 1;
	}
	
	//getters.
	public int getPreco() {
		return preco;
	}
	
	public int getAluguel() {
		return aluguel;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getPosicao() {
		return posicao;
	}
	
	///setters.
	public void setPreco(int preco) {
		this.preco = preco;
	}
	
	public void setAluguel(int aluguel) {
		this.aluguel = aluguel;
	}
	
	public abstract int calcularAluguel();
}
