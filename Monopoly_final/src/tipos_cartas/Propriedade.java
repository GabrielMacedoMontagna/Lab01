package tipos_cartas;

import main.Jogador;


public class Propriedade extends Carta {
	private int preco;
	private int aluguel;
	private String nome;
	
	//construtor sem dono.
	public Propriedade(int preco, int aluguel, String nome, String descricao) {
		
		super(descricao);
		
				
		this.preco = preco;
		this.aluguel = aluguel;
		this.nome = nome;
	}
	
	//construtor com dono.
	public Propriedade(int preco, int aluguel, String nome, String descricao, Jogador dono) {
				
		super(descricao, dono);
		
				
		this.preco = preco;
		this.aluguel = aluguel;
		this.nome = nome;
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
	
	///setters.
	public void setPreco(int preco) {
		this.preco = preco;
	}
	
	public void setAluguel(int aluguel) {
		this.aluguel = aluguel;
	}
	
	public int calcularAluguel() {
		return aluguel;
	}
}
