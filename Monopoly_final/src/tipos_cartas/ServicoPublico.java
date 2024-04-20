package tipos_cartas;

import main.Jogador;

public class ServicoPublico extends Propriedade {

	public ServicoPublico(int preco, int aluguel, String nome, String descricao, Jogador dono) {
		super(preco, aluguel, nome, descricao, dono);
	}
	
	public int calcularAluguel(int dados) {
		//multiplica o valor dos dados pelo aluguel base.
		return super.getAluguel() * dados;
	}
	
}