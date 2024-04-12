package atributos;

public class Estacao extends Propriedade {
	
	//Construtor.
	public Estacao(int id, int preco, int aluguel, String nome, String proprietario) {
		super(id, preco, aluguel, nome, proprietario);
	}

	@Override
	public int calcularAluguel() {
		return aluguel;
	}
}
