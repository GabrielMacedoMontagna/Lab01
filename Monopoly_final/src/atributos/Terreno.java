package atributos;

public class Terreno extends Propriedade {
	private int numeroCasas;
	private int valorCasa;
	private int valorHotel;
	private boolean hotel;
	
	//Construtor
	public Terreno(int preco, int aluguel, String nome, String proprietario, int numeroCasas, int valorCasa, int valorHotel, boolean hotel) {
		super(preco, aluguel, nome, proprietario);
		this.numeroCasas = numeroCasas;
		this.valorCasa = valorCasa;
		this.valorHotel = valorHotel;
		this.hotel = hotel;
	}
	
	//Getters
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
	
	//Setters
	public void setNumeroCasas(int numeroCasas) {
		this.numeroCasas = numeroCasas;
	}
	
	public void setValorCasa(int valorCasa) {
		this.valorCasa = valorCasa;
	}
	
	public void setValorHotel(int valorHotel) {
		this.valorHotel = valorHotel;
	}
	
	public void setHotel(boolean hotel) {
		this.hotel = hotel;
	}
	
	@Override
	public int calcularAluguel() {
		
		//Para calcular o aluguel do terreno, vamos multiplicar o valor base do aluguel pelo numero de casas.
		//se tiver hotel, o valor final do aluguel dobra.
		int aluguel_final = aluguel;
		
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
		
		if (dinheiro_jogador >= valorCasa) {
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
	
	
}
