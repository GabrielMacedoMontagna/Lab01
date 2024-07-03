package cartas_do_jogo;

import main.Jogador;

public class Estacao extends Propriedade {
	private int tarifa;
	
	//construtor sem dono.
	public Estacao(int preco, int aluguel, int posicao, String nome, String descricao, TipoCarta tipo, int tarifa) {
		
		super(preco, aluguel, posicao, nome, descricao, tipo);
		this.tarifa = tarifa;
	}
	
	//construtor com dono.
	public Estacao(int preco, int aluguel, int posicao, String nome, String descricao, TipoCarta tipo, int tarifa, Jogador dono) {
		
		super(preco, aluguel, posicao, nome, descricao, tipo, dono);
	}

	@Override
	public int calcularAluguel() {
		//calcula o aluguel total ao somar o aluguel base com a tarifa.
		return super.getAluguel() + tarifa;
	}
	
	public String toString() {
		 String out = "";
		 
		 out += "ESTAÇÃO\n";
		 out += "Nome:" + super.getNome() + "\n";
		 out += "Descrição: " + super.getDescricao() + "\n";
		
		 if (super.getDono() == null){
			 out += "Dono: não possui dono\n";
		 }
		 else {
			 out += "Dono: " + super.getDono().getNome() + "\n";
		 }
		
		 out += "Preço: " + super.getPreco() + " reais.\n";
		 out += "Aluguel: " + super.getAluguel() + " reais.\n";
		 
		 return out;
	}
}
