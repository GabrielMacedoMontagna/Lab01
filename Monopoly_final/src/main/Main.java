package main;

import java.util.Scanner;

//import tipos_cartas.Carta;
//import tipos_cartas.CartaSorte;
//import tipos_cartas.Estacao;
//import tipos_cartas.Propriedade;
//import tipos_cartas.ServicoPublico;
//import tipos_cartas.Terreno;

public class Main {

	public static void main(String[] args) {
		//vamos instanciar o tabuleiro.
		Tabuleiro tabuleiro = new Tabuleiro();
		
		
		//vamos criar um scanner para receber as entradas.
		Scanner leitura = new Scanner(System.in);
		String input = "";
		
		//inicio do menu.
		System.out.println("Olá, bem-vindo ao Menu de Monopoly, o jogo dos negócios!");

		boolean personalizando = true;
		while (personalizando) {
			System.out.println("###########################################################################");
			System.out.println("Escolha uma das opções abaixo para personalizar o seu tabuleiro:");
			System.out.println("- Adicionar jogador (digite 1)");
			System.out.println("- Adicionar uma carta de sorte ou revés (digite 2)");
			System.out.println("- Adicionar uma propriedade (digite 3)");
			System.out.println("- Encerrar personalização (digite 'fim')");
			
			input = leitura.nextLine();
						
			if (input.equals("fim")) {
				personalizando = false;
			}
			
			else if (input.equals("1")) {
				System.out.println("Digite Nome, CPF, e-mail, descrição de foto e cor da peça do jogador.");
				System.out.println("Deixe tudo separado por linha:");
				
				tabuleiro.addJogador(leitura);
				System.out.println("Jogador adicionado com sucesso!");
			}
			
			else if (input.equals("2")) {
				tabuleiro.addCartaSorte(leitura);
			}
			
			else if (input.equals("3")) {
				tabuleiro.addPropriedade(leitura);
			}
		}
			
		leitura.close();
		
	}
}