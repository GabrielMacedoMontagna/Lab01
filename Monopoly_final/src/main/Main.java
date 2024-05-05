package main;

import java.util.Scanner;

import tipos_cartas.CartaSorte;
import tipos_cartas.Estacao;
import tipos_cartas.ServicoPublico;
import tipos_cartas.Terreno;

public class Main {

	public static void main(String[] args) {
		//vamos instanciar o tabuleiro.
		Tabuleiro tabuleiro = new Tabuleiro();
		
		
		//vamos criar um scanner para receber as entradas.
		Scanner leitura = new Scanner(System.in);
		String input = "";
		
		//inicio do menu.
		System.out.println("Olá, bem-vindo ao Menu de Monopoly, o jogo dos negócios!");
		System.out.println("Você deseja personalizar o seu tabuleiro ou iniciar com o tabuleiro padrão?");
		System.out.println("- Personalizar o tabuleiro padrão (digite 1)");
		System.out.println("- Iniciar com o tabuleiro padrão (digite 2)");
		
		input = leitura.nextLine();
		
		while (!input.equals("1") && !input.equals("2")) {
			System.out.println("Comando incorreto, tente novamente.");
			input = leitura.nextLine();
		}
		
		//vai personalizar.
		if (input.equals("1")) {

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
		}
		
		else if (input.equals("2")) {
			
			//jogadores.
			Jogador J1 = new Jogador("Gabriel", "123.456.789-00", "gabriel@email.com", "fotoGabriel", "azul");
			tabuleiro.addJogador(J1);
			
			Jogador J2 = new Jogador("Esther", "123.456.789-00", "esther@email.com", "fotoEsther", "verde");
			tabuleiro.addJogador(J2);
			
			Jogador J3 = new Jogador("Fulano", "123.456.789-00", "fulano@email.com", "fotoFulano", "vermelho");
			tabuleiro.addJogador(J3);
			
			//propriedades.
			Terreno T1 = new Terreno(50, 30, "Copacabana", "terreno em Copacabana", J1, 0, 40, 70, false);
			tabuleiro.addPropriedade(T1);
			Terreno T2 = new Terreno(50, 30, "Barão Geraldo", "terreno em Barão Geraldo", J2, 0, 40, 70, false);
			tabuleiro.addPropriedade(T2);
			Terreno T3 = new Terreno(50, 30, "São Paulo", "terreno em São Paulo", 0, 40, 70, false);
			tabuleiro.addPropriedade(T3);
			
			Estacao E1 = new Estacao(50, 40, "Estação da Luz", "Importante estação de trem da capital paulista.", J1);
			tabuleiro.addPropriedade(E1);
			
			ServicoPublico SP1 = new ServicoPublico(70, 30, "Tratamento de água", "Serviço de tratamento de água; o aluguel é um múltiplo dos dados tirados pelo jogador.", J2);
			tabuleiro.addPropriedade(SP1);
			
			//cartas de sorte ou reves.
			CartaSorte CS1 = new CartaSorte(0, -1, 0, 0, "Prisão", "Fique duas rodadas na prisão!", "Não há restrição");
			tabuleiro.addCartaSorte(CS1);
			CartaSorte CS2 = new CartaSorte(0, 0, 0, 0, "Construção", "Construa em sua propriedade.", "A carta deve ser usada imediatamente.");
			tabuleiro.addCartaSorte(CS2);
			CartaSorte CS3 = new CartaSorte(0, 1, 0, 100, "Sorte", "Seu vizinho caloteiro finalmente te pagou! Receba 100 reais do jogador à sua esquerda.", "Não há restrição");
			tabuleiro.addCartaSorte(CS3);
			CartaSorte CS4 = new CartaSorte(0, -1, 0, -200, "Azar", "Você estava acima do limite de velocidade e foi multado! Pague 200 reais ao banco.", "Não há restrição");
			tabuleiro.addCartaSorte(CS4);
			CartaSorte CS5 = new CartaSorte(0, 1, 0, 0, "Liberdade", "Esta carta te liberta da prisão imediatamente!", "Use agora ou guarde-a para depois.");
			tabuleiro.addCartaSorte(CS5);
						
		}
		
		System.out.println("Muito bem, seu tabuleiro está pronto para o jogo!");
		boolean executando = true;
		
		while (executando) {
			System.out.println("###########################################################################");
			System.out.println("Escolha o que deseja fazer:");
			System.out.println("- Visualizar perfil geral do jogador (digite 1)");
			System.out.println("- Visualizar as propriedades do tabuleiro (digite 2)");
			System.out.println("- Finalizar programa (digite 3)");
			
			input = leitura.nextLine();
			
			if (input.equals("1")) {
				System.out.println("Digite o nome do jogador que você deseja verificar:");
				input = leitura.nextLine();
				
				for (int i = 0; i < tabuleiro.getJogadores().size(); i++) {
					if (input.equals(tabuleiro.getJogadores().get(i).getNome())) {
						System.out.println(tabuleiro.getJogadores().get(i));
						break;
					}
				}
			}
			
			else if (input.equals("2")) {
				for (int i = 0; i < tabuleiro.getPropriedades().size(); i++) {
					System.out.println(tabuleiro.getPropriedades().get(i));
				}
			}
			
			else if(input.equals("3")) {
				executando = false;
			}

		}
			
		leitura.close();
		
	}
}