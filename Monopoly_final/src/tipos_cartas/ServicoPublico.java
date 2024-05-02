package tipos_cartas;

import main.Jogador;

public class ServicoPublico extends Propriedade {

	//construtor sem dono.
	public ServicoPublico(int preco, int aluguel, String nome, String descricao) {
		super(preco, aluguel, nome, descricao);
	}	
	
	//construtor com dono.
	public ServicoPublico(int preco, int aluguel, String nome, String descricao, Jogador dono) {
		super(preco, aluguel, nome, descricao, dono);
	}
	
	public int calcularAluguel(int dados) {
		//multiplica o valor dos dados pelo aluguel base.
		return super.getAluguel() * dados;
	}
	
}