package main;

public class Jogador {
	private String nome;
	private int id;
	private String cpf;
	private String email;
	private String foto;
	private int dinheiro;
	private static int contador_id = 0;

	//Construtor.
	public Jogador(String nome, String cpf, String email, String foto) {
		this.nome = nome;
		
		contador_id++;
		this.id = contador_id;
		
		this.cpf = cpf;
		this.email = email;
		this.foto = foto;
		dinheiro = 500;
	}
	
	//Getters e Setters.
	public String getNome() {
		return nome;
	}
	
	public int getId() {
		return id;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public int getDinheiro() {
		return dinheiro;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	public String toString() {
		return "Nome: " + nome + ", id: " + id + ", cpf: " + cpf + ", email: " + email + ", foto: " + foto + ", dinheiro: " + dinheiro;
	}

}