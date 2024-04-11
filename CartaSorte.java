
public class CartaSorte {
	private int id;
	private int movimento;
	private int efeito; //Aqui, vamos adotar 1 como positivo, 0 como neutro e -1 como negativo.
	private int tempo;
	private float valor;
	private String descricao;//trtrtfg
	private String acao;
	private String restricao;
	
	//Construtor.
	public CartaSorte(int id, int movimento, int efeito, int tempo, float valor, String descricao, String acao, String restricao) {
		this.id = id;
		this.movimento = movimento;
		this.efeito = efeito;
		this.tempo = tempo;
		this.valor = valor;
		this.descricao = descricao;
		this.acao = acao;
		this.restricao = restricao;
	}
	
	//Getters e Setters.
	public int getId() {
		return id;
	}
	
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
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getAcao() {
		return acao;
	}
	
	public String getRestricao() {
		return restricao;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
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
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public void setRestricao(String restricao) {
		this.restricao = restricao;
	}
}
