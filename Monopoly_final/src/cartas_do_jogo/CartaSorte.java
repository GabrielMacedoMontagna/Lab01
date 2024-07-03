package cartas_do_jogo;

import main.Jogador;

public class CartaSorte extends Carta {
	private int movimento;
	private int efeito; //Aqui, vamos colocar quanto o jogador vai ganhar/perder de dinheiro.
	private int tempo;
	private float valor;
	private String acao;
	private String restricao;
	
	//construtor sem dono.
	public CartaSorte(int movimento, int efeito, int tempo, float valor, String descricao, String acao, String restricao, TipoCarta tipo) {
		
		super(descricao, tipo);

		this.movimento = movimento;
		this.efeito = efeito;
		this.tempo = tempo;
		this.valor = valor;
		this.acao = acao;
		this.restricao = restricao;
	}
	
	//construtor com dono.
	public CartaSorte(int movimento, int efeito, int tempo, float valor, String descricao, String acao, String restricao, Jogador dono, TipoCarta tipo) {
		
		super(descricao, dono, tipo);

		this.movimento = movimento;
		this.efeito = efeito;
		this.tempo = tempo;
		this.valor = valor;
		this.acao = acao;
		this.restricao = restricao;
	}
	
	//getters.
	
	public int getMovimento() {
		return movimento;
	}
	
	public int getEfeito() {
		return efeito;
	}
	
	public int getTempo() {
		return tempo;
	}
	
	public float getvalor() {
		return valor;
	}
	
	public String getAcao() {
		return acao;
	}
	
	public String getRestricao() {
		return restricao;
	}
	
	//setters.
	public void setMovimento(int movimento) {
		this.movimento = movimento;
	}
	
	public void setEfeito(int efeito) {
		this.efeito = efeito;
	}
	
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public void setRestricao(String restricao) {
		this.restricao = restricao;
	}
	
	@Override
	public String toString() {
		
		String out = "";
		
		if (super.getTipo().equals(TipoCarta.SORTE)) {
			out += "SORTE\n";
		}
		
		else if (super.getTipo().equals(TipoCarta.REVES)) {
			out += "REVÉS\n";
		}
		
		out += "Descrição: " + super.getDescricao() + "\n";
		out += "Ação: " + acao + "\n";
		//out += "Dono: " + super.getDono().getNome() + "\n"; nao precisa mais ter dono.
		out += "Movimento: " + movimento + "\n";
		out += "Efeito: " + efeito + "\n";
		out += "Tempo: " + tempo + "\n";
		out += "Valor: " + valor + "\n";
		out += "Restrição: " + restricao + "\n";
		
		return out;
	}
}
