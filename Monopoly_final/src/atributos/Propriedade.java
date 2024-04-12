package atributos;
//
public class Propriedade {
	protected int id; //id da propriedade.
	protected int preco;
	protected int aluguel;
	protected String nome;
	protected String proprietario;
	private static int contador_id = 0;
	
	//Construtor
	public Propriedade(int preco, int aluguel, String nome, String proprietario) {
		
		contador_id++;
		this.id = contador_id;
		
		this.preco = preco;
		this.aluguel = aluguel;
		this.nome = nome;
		this.proprietario = proprietario;
	}
	
	//Getters
	public int getId() {
		return id;
	}
	
	public int getPreco() {
		return preco;
	}
	
	public int getAluguel() {
		return aluguel;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getProprietario() {
		return proprietario;
	}
	
	///Setters
	public void setPreco(int preco) {
		this.preco = preco;
	}
	
	public void setAluguel(int aluguel) {
		this.aluguel = aluguel;
	}
	
	public void setNome(String nome) {
		//Talvez nao precisasse de setter para o nome da propriedade.
		this.nome = nome;
	}
	
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	
	public int calcularAluguel() {
		return aluguel;
	}
}
