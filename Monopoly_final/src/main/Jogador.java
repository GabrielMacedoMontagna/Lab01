package main;

import java.util.ArrayList;

import cartas_do_jogo.Carta;

public class Jogador {
	private String nome;
	private int id;
	private String cpf;
	private String email;
	private String foto;
	private int dinheiro;
	private int posicao;
	private Peca peca;
	private boolean eliminado;
	private ArrayList<Carta> cartas; //talvez possa ser só um vetor de Propriedade.
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
		this.dinheiro = 500;
		this.posicao = 1;
		this.eliminado = false;
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
	
	public int getPosicao() {
		return posicao;
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
			cartaNova.setDono(this);
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
	
	public void movimentaConta(int valor) {
		dinheiro += valor; //valor pode ser positivo ou negativo.
		if (dinheiro < 0) {
			dinheiro = 0;
		}
	}
	
	/*public void perdeDinheiro(int valor) {
		dinheiro -= valor;
	}*/
	
	public void andar(int dados) {
		int tamanhoTabuleiro = 20;
		
		posicao += dados;
		
		if (posicao >= tamanhoTabuleiro) {
			posicao -= tamanhoTabuleiro;
		}
		
		peca.setPosicao(posicao);
	}
	
	public void eliminar() {
		eliminado = true;
	}
	
	public boolean eliminado() {
		return eliminado;
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