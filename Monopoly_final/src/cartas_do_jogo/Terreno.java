package cartas_do_jogo;

//import main.Jogador;

public class Terreno extends Propriedade {
	private int numeroCasas;
	private int maxCasas = 4;
	private int valorCasa;
	private int valorHotel;
	private boolean hotel;
	
	//construtor sem dono.
	public Terreno(int preco, int aluguel, int posicao, String nome, String descricao, TipoCarta tipo, int numeroCasas, int valorCasa, int valorHotel, boolean hotel) {
		super(preco, aluguel, posicao, nome, descricao, tipo);
		
		this.numeroCasas = numeroCasas;
		this.maxCasas = 4;
		this.valorCasa = valorCasa;
		this.valorHotel = valorHotel;
		this.hotel = hotel;
	}
		
	//construtor com dono.
	/*public Terreno(int preco, int aluguel, int posicao, String nome, String descricao, TipoCarta tipo, Jogador dono, int numeroCasas, int valorCasa, int valorHotel, boolean hotel) {
		super(preco, aluguel, posicao, nome, descricao, tipo, dono);
		
		this.numeroCasas = numeroCasas;
		this.valorCasa = valorCasa;
		this.valorHotel = valorHotel;
		this.hotel = hotel;
	}*/
	
	//getters.
	public int getNumeroCasas() {
		return numeroCasas;
	}
	
	public int getMaxCasas() {
		return maxCasas;
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
	public boolean comprarCasa() {
		
		if (dono.getDinheiro() > valorCasa) {
			numeroCasas++;
			dono.movimentaConta(-valorCasa);
			return true;
		}
		
		return false;
	}
	//comprarHotel vai retornar o dinheiro do jogador apos a compra, se ele conseguir comprar.
	public boolean comprarHotel() {
		
		if (dono.getDinheiro() > valorHotel) {
			hotel = true;
			dono.movimentaConta(valorHotel);;
		}
		
		return hotel;
	}
	
	public String toString() {
		String out = "";
		
		out += "TERRENO\n";
		out += "Nome: " + super.getNome() + "\n";
		out += "Descrição: " + super.getDescricao() + "\n";
		
		if (super.getDono() == null) {
			out += "Dono: não possui dono\n";
		}
		else {
			out += "Dono: " + super.getDono().getNome() + "\n";
		}
		
		out += "Preço: " + super.getPreco() + " reais.\n";
		out += "Aluguel: " + super.getAluguel() + " reais.\n";
		out += "Preço da casa: " + valorCasa + " reais.\n";
		out += "Preço do hotel: " + valorHotel + " reais.\n";
		out += "Número de casas: " + numeroCasas + "\n";
		out += "Hotel construído?: " + hotel + "\n";
		
		return out;
	}

}
