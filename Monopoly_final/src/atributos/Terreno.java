package atributos;

public class Terreno extends Propriedade {
	private int numeroCasas;
	private int valorCasa;
	private int valorHotel;
	private boolean hotel;
	
	//Construtor
	public Terreno(int id, int preco, int aluguel, String nome, String proprietario, int numeroCasas, int valorCasa, int valorHotel, boolean hotel) {
		super(id, preco, aluguel, nome, proprietario);
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
		return aluguel;
	}
}
