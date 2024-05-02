package tipos_cartas;

import main.Jogador;

public class Estacao extends Propriedade {
	
	//construtor sem dono.
	public Estacao(int preco, int aluguel, String nome, String descricao) {
		
		super(preco, aluguel, nome, descricao);
	}
	
	//construtor com dono.
	public Estacao(int preco, int aluguel, String nome, String descricao, Jogador dono) {
		
		super(preco, aluguel, nome, descricao, dono);
	}

	@Override
	public int calcularAluguel() {
		return super.getAluguel();
	}
}
