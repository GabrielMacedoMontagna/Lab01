package atributos;

public class Estacao extends Propriedade {
	
	//Construtor.
	public Estacao(int preco, int aluguel, String nome, String proprietario) {
		super(preco, aluguel, nome, proprietario);
	}

	@Override
	public int calcularAluguel() {
		return aluguel;
	}
}
