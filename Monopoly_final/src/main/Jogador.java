package main;

import java.util.ArrayList;

import tipos_cartas.Carta;

public class Jogador {
	private String nome;
	private int id;
	private String cpf;
	private String email;
	private String foto;
	private int dinheiro;
	private Peca peca;
	private ArrayList<Carta> cartas;
	private static int contador_id = 0;

	//Construtor.
	public Jogador(String nome, String cpf, String email, String foto, String corPeca) {
		
		this.nome = nome;
		
		if (nome == null) {
			this.id = 0;
		}
		
		else {
			contador_id++;
			this.id = contador_id;	
		}
		
		this.cpf = cpf;
		this.email = email;
		this.foto = foto;
		this.peca = new Peca(corPeca);
		this.cartas = new ArrayList<Carta>();
		dinheiro = 500;
	}
	
	//getters.
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
	
	public Peca getPeca() {
		return peca;
	}
	
	public ArrayList<Carta> getCartas() {
		//retorna todas as cartas do jogador.
		return cartas;
	}
	
	//setters.
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
	
	public void setPeca(Peca pecaNova) {
		peca = pecaNova;
	}
	
	//demais métodos.
	public void adicionaCarta(Carta cartaNova) {
		if (!cartas.contains(cartaNova)) {
			cartas.add(cartaNova);
		}
	}
	
	public String removeCarta(Carta cartaDescartada) {
		if (cartas.remove(cartaDescartada)) {
			return "Carta removida do jogador";
		}
		
		return "O jogador não tinha essa carta";
	}
	
	public boolean temCarta(Carta cartaBuscada) {
		return cartas.contains(cartaBuscada);
	}
	
	public String toString() {
		
		String out = "";
		
		out += "JOGADOR\n";
		out += "Nome: " + nome + "\n";
		out += "CPF: " + cpf + "\n";
		out += "E-mail: " + email + "\n";
		out += "Foto: " + foto + "\n";
		out += "Dinheiro disponível: " + dinheiro + "\n";
		out += "\nPeça de " + nome + ":\n" + peca;
		out += "\nCartas de " + nome + ":\n";
		
		if (cartas.size() == 0) {
			out += "Não possui cartas\n";
		}
		else {
			for (int i = 0; i < cartas.size(); i++) {
				out += cartas.get(i) + "\n";
			}
		}
		
		return out;
	}
}