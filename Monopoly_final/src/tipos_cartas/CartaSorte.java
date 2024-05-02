package tipos_cartas;

import main.Jogador;

public class CartaSorte extends Carta {
	private int movimento;
	private int efeito; //Aqui, vamos adotar 1 como positivo, 0 como neutro e -1 como negativo.
	private int tempo;
	private float valor;
	private String acao;
	private String restricao;
	
	//construtor sem dono.
	public CartaSorte(int movimento, int efeito, int tempo, float valor, String descricao, String acao, String restricao) {
		
		super(descricao);

		this.movimento = movimento;
		this.efeito = efeito;
		this.tempo = tempo;
		this.valor = valor;
		this.acao = acao;
		this.restricao = restricao;
	}
	
	//construtor com dono.
	public CartaSorte(int movimento, int efeito, int tempo, float valor, String descricao, String acao, String restricao, Jogador dono) {
		
		super(descricao, dono);

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
		
		String out = " ";
		
		out += "id: " + super.getId() + ", dono: \n" + super.getDono();
		out += ", movimento: " + movimento + ", efeito: " + efeito;
		out += ", tempo: " + tempo + ", valor: " + valor;
		out += ", descrição: " + super.getDescricao() + ", ação: " + acao;
		out += ", restrição: " + restricao;
		
		return out;
	}
}
