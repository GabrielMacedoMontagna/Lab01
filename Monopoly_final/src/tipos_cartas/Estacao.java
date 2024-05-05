package tipos_cartas;

import main.Jogador;

public class Estacao extends Propriedade {
	
	//construtor sem dono.
	public Estacao(int preco, int aluguel, String nome, String descricao) {
		
		super(preco, aluguel, nome, descricao);
	}
	
	//construtor com dono.
	public Estacao(int preco, int aluguel, String nome, String descricao, Jogador dono) {
		
		super(preco, aluguel, nome, descricao, dono);
	}

	@Override
	public int calcularAluguel() {
		return super.getAluguel();
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
		
		 out += "Preço: " + super.getPreco() + "\n";
		 out += "Aluguel: " + super.getAluguel() + "\n";
		 
		 return out;
	}
}
