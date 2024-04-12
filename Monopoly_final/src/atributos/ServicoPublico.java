package atributos;

public class ServicoPublico extends Propriedade {

	public ServicoPublico(int id, int preco, int aluguel, String nome, String proprietario) {
		super(id, preco, aluguel, nome, proprietario);
	}
	
	public int calcularAluguel(int dados) {
		return aluguel * dados;
	}
	
}