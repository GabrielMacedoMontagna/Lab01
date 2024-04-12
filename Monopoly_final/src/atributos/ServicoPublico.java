package atributos;

public class ServicoPublico extends Propriedade {

	public ServicoPublico(int preco, int aluguel, String nome, String proprietario) {
		super(preco, aluguel, nome, proprietario);
	}
	
	public int calcularAluguel(int dados) {
		//multiplica o valor dos dados pelo aluguel base.
		return aluguel * dados;
	}
	
}