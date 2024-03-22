
public class Peca {
	private int posicao;
	private String cor;
	
	//Construtor.
	public Peca(int posicao, String cor) {
		this.posicao = posicao;
		this.cor = cor;
	}
	
	//Getters e Setters.
	public int getPosicao() {
		return posicao;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
}
