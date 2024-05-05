package tipos_cartas;

import main.Jogador;

public class Terreno extends Propriedade {
	private int numeroCasas;
	private int valorCasa;
	private int valorHotel;
	private boolean hotel;
	
	//construtor sem dono.
	public Terreno(int preco, int aluguel, String nome, String descricao, int numeroCasas, int valorCasa, int valorHotel, boolean hotel) {
		super(preco, aluguel, nome, descricao);
		
		this.numeroCasas = numeroCasas;
		this.valorCasa = valorCasa;
		this.valorHotel = valorHotel;
		this.hotel = hotel;
	}
		
	//construtor com dono.
	public Terreno(int preco, int aluguel, String nome, String descricao, Jogador dono, int numeroCasas, int valorCasa, int valorHotel, boolean hotel) {
		super(preco, aluguel, nome, descricao, dono);
		
		this.numeroCasas = numeroCasas;
		this.valorCasa = valorCasa;
		this.valorHotel = valorHotel;
		this.hotel = hotel;
	}
	
	//getters.
	public int getNumeroCasas() {
		return numeroCasas;
	}
	
	public int getValorCasa() {
		return valorCasa;
	}
	
	public int getValorHotel() {
		return valorHotel;
	}
	
	public boolean getHotel() {
		return hotel;
	}
	
	//setters.
	public void setNumeroCasas(int numeroCasas) {
		this.numeroCasas = numeroCasas;
	}
	
	public void setHotel(boolean hotel) {
		this.hotel = hotel;
	}
	
	@Override
	public int calcularAluguel() {
		
		//Para calcular o aluguel do terreno, vamos multiplicar o valor base do aluguel pelo numero de casas.
		//se tiver hotel, o valor final do aluguel dobra.
		int aluguel_final = super.getAluguel();
		
		if (numeroCasas > 0) {
			
			aluguel_final = numeroCasas * aluguel_final;
			
			if (hotel) {
				aluguel_final = 2 * aluguel_final;
			}
		}
		
		return aluguel_final;
	}
	
	//comprarCasa vai retornar o dinheiro do jogador apos a compra, se ele conseguir comprar.
	public int comprarCasa(int dinheiro_jogador) {
		
		if (dono.getDinheiro() >= valorCasa) {
			numeroCasas++;
			
			dinheiro_jogador -= valorCasa;
		}
		
		return dinheiro_jogador;
	}
	//comprarHotel vai retornar o dinheiro do jogador apos a compra, se ele conseguir comprar.
	public int comprarHotel(int dinheiro_jogador) {
		
		if (dinheiro_jogador >= valorHotel) {
			hotel = true;
			dinheiro_jogador -= valorHotel;
		}
		
		return dinheiro_jogador;
	}
	
	public String toString() {
		String out = "";
		
		out += "TERRENO\n";
		out += "Nome:" + super.getNome() + "\n";
		out += "Descrição: " + super.getDescricao() + "\n";
		
		if (super.getDono() == null) {
			out += "Dono: não possui dono\n";
		}
		else {
			out += "Dono: " + super.getDono().getNome() + "\n";
		}
		
		out += "Preço: " + super.getPreco() + "\n";
		out += "Aluguel: " + super.getAluguel() + "\n";
		out += "Preço da casa: " + valorCasa + "\n";
		out += "Preço do hotel: " + valorHotel + "\n";
		out += "Número de casas: " + numeroCasas + "\n";
		out += "Construiu hotel?: " + hotel + "\n";
		
		return out;
	}

}
