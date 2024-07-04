package main;

import java.util.*;

import cartas_do_jogo.*;

public class Main {
	
	public static Tabuleiro criaTabuleiro(Tabuleiro tabuleiro){
		
		//propriedades.
		Terreno T1 = new Terreno(50, 30, 1, "Copacabana", "terreno em Copacabana", TipoCarta.TERRENO, 0, 40, 70, false);
		tabuleiro.addPropriedade(T1);
		Terreno T2 = new Terreno(50, 30, 3, "Barão Geraldo", "terreno em Barão Geraldo", TipoCarta.TERRENO, 0, 40, 70, false);
		tabuleiro.addPropriedade(T2);
		Terreno T3 = new Terreno(50, 30, 6, "Bangu", "terreno em Bangu", TipoCarta.TERRENO, 0, 40, 70, false);
		tabuleiro.addPropriedade(T3);
		Terreno T4 = new Terreno(50, 30, 7, "Leblon", "terreno no Leblon", TipoCarta.TERRENO, 0, 40, 70, false);
		tabuleiro.addPropriedade(T4);
		Terreno T5 = new Terreno(50, 30, 10, "Ipanema", "terreno em Ipanema", TipoCarta.TERRENO, 0, 40, 70, false);
		tabuleiro.addPropriedade(T5);
		Terreno T6 = new Terreno(50, 30, 14, "Interlagos", "terreno em Interlagos", TipoCarta.TERRENO, 0, 40, 70, false);
		tabuleiro.addPropriedade(T6);
		Terreno T7 = new Terreno(50, 30, 15, "Morumbi", "terreno no Morumbi", TipoCarta.TERRENO, 0, 40, 70, false);
		tabuleiro.addPropriedade(T7);
		Terreno T8 = new Terreno(50, 30, 18, "Botafogo", "terreno em Botafogo", TipoCarta.TERRENO, 0, 40, 70, false);
		tabuleiro.addPropriedade(T8);


		//estacoes.
		Estacao E1 = new Estacao(50, 40, 4, "Estação da Luz", "Importante estação de trem da capital paulista.", TipoCarta.ESTACAO, 20);
		tabuleiro.addPropriedade(E1);
		Estacao E2 = new Estacao(50, 40, 11, "Estação da Sé", "Importante estação de trem da capital paulista.", TipoCarta.ESTACAO, 20);
		tabuleiro.addPropriedade(E2);
		Estacao E3 = new Estacao(50, 40, 19, "Estação Novo Hamburgo", "Importante estação de trem da região Sul.", TipoCarta.ESTACAO, 20);
		tabuleiro.addPropriedade(E3);
		
		ServicoPublico SP1 = new ServicoPublico(70, 30, 5, "Tratamento de água", "Serviço de tratamento de água; o aluguel é multiplicado pelo multiplicador.", TipoCarta.SERVICOPUBLICO, 3);
		tabuleiro.addPropriedade(SP1);
		ServicoPublico SP2 = new ServicoPublico(70, 30, 9, "Companhia de energia", "Serviço de distribuição de energia elétrica; o aluguel é multiplicado pelo multiplicador.", TipoCarta.SERVICOPUBLICO, 3);
		tabuleiro.addPropriedade(SP2);		
		ServicoPublico SP3 = new ServicoPublico(70, 30, 13, "Companhia de aviação", "Empresa de aviação; o aluguel é multiplicado pelo multiplicador.", TipoCarta.SERVICOPUBLICO, 3);
		tabuleiro.addPropriedade(SP3);
		ServicoPublico SP4 = new ServicoPublico(70, 30, 9, "Companhia de táxi", "Serviço de táxi; o aluguel é multiplicado pelo multiplicador.", TipoCarta.SERVICOPUBLICO, 3);
		tabuleiro.addPropriedade(SP4);
		
		//cartas de sorte ou reves.
		CartaSorte CS1 = new CartaSorte(0, -100, 0, 0, "Crime", "Você foi pego roubando! Pague 100 reais ao banco.", "A carta deve ser usada imediatamente.", TipoCarta.REVES);
		tabuleiro.addCartaSorte(CS1);
		CartaSorte CS2 = new CartaSorte(0, -50, 0, 0, "Obras", "Sua casa está em obra! Pague 50 reais ao banco.", "A carta deve ser usada imediatamente.", TipoCarta.REVES);
		tabuleiro.addCartaSorte(CS2);
		CartaSorte CS3 = new CartaSorte(0, 100, 0, 0, "Sorte", "Seu vizinho caloteiro finalmente te pagou! Receba 100 reais do banco.", "A carta deve ser usada imediatamente.", TipoCarta.SORTE);
		tabuleiro.addCartaSorte(CS3);
		CartaSorte CS4 = new CartaSorte(0, -200, 0, 0, "Azar", "Você estava acima do limite de velocidade e foi multado! Pague 200 reais ao banco.", "A carta deve ser usada imediatamente.", TipoCarta.REVES);
		tabuleiro.addCartaSorte(CS4);
		CartaSorte CS5 = new CartaSorte(0, 200, 0, 0, "Loteria", "Ganhou na loteria! Receba 200 reais do banco.", "A carta deve ser usada imediatamente.", TipoCarta.SORTE);
		tabuleiro.addCartaSorte(CS5);
		
		//no tabuleiro, as posicoes vazias do vetor sao as casas de sorte/reves do jogo.
		return tabuleiro;
	}
	
	public static Jogador verificaSaldo(Tabuleiro tabuleiro, Jogador jogadorAtual) {
		if (jogadorAtual.getDinheiro() == 0) {
			System.out.println(jogadorAtual.getNome() + " ficou sem dinheiro e está fora do jogo! =(");
			jogadorAtual.eliminar();
			tabuleiro.eliminar();
		}
		return jogadorAtual;
	}

	public static Jogador compraPropriedade(Jogador jogadorAtual, Propriedade propAtual) {
		System.out.println("Comprando...");
		try {
			//pausa a execucao por 3 segundos.
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
								
		//se tiver dinheiro para comprar.
		if (jogadorAtual.getDinheiro() > propAtual.getPreco()) {
			jogadorAtual.adicionaCarta(propAtual);
			jogadorAtual.movimentaConta(-propAtual.getPreco());
			System.out.println(propAtual.getNome() + " adquirido(a) com sucesso!");
			System.out.println("O novo saldo de " + jogadorAtual.getNome() + " é: " + jogadorAtual.getDinheiro() + " reais.");
		}
		
		else {
			System.out.println("Não foi possível comprar a propriedade " + propAtual.getNome() + ", pois o dinheiro na sua conta não é suficiente!");
		}
		return jogadorAtual;
	}
	
	public static Jogador compraCasa(Jogador jogadorAtual, Terreno terrenoAtual) {
		
		boolean conseguiu = terrenoAtual.comprarCasa();
		
		System.out.println("Comprando...");
		try {
			//pausa a execucao por 3 segundos.
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//se faltou dinheiro.
		if (!conseguiu) {
			System.out.println("Não foi possível comprar a casa pois o dinheiro na sua conta não é suficiente!");
		}
		
		else {
			System.out.println("Parabéns, casa comprada com sucesso!");
			System.out.println("O novo saldo de " + jogadorAtual.getNome() + " é: " + jogadorAtual.getDinheiro() + " reais.");
		}
		return jogadorAtual;
	}
	
	public static Jogador compraHotel(Jogador jogadorAtual, Terreno terrenoAtual) {
		
		boolean conseguiu = terrenoAtual.comprarHotel();
		
		System.out.println("Comprando...");
		try {
			//pausa a execucao por 3 segundos.
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//se faltou dinheiro.
		if (!conseguiu) {
			System.out.println("Não foi possível comprar o hotel pois o dinheiro na sua conta não é suficiente!");
		}
		
		else {
			System.out.println("Parabéns, hotel comprado com sucesso! Sua propriedade agora está no nível máximo.");
			System.out.println("O novo saldo de " + jogadorAtual.getNome() + " é: " + jogadorAtual.getDinheiro() + " reais.");
		}
		return jogadorAtual;
	}
	
	public static Jogador pagaAluguel(Tabuleiro tabuleiro, Jogador jogadorAtual, Propriedade propAtual, Scanner leitura) {
		
		System.out.println(jogadorAtual.getNome() + " parou em " + propAtual.getNome() + ", uma propriedade de " + propAtual.getDono().getNome());
		System.out.println("Pague o valor de " + propAtual.calcularAluguel() + " reais a " + propAtual.getDono().getNome());
		System.out.println("Pressione enter para pagar!");
		leitura.nextLine();
		System.out.println("Pagando...");
		
		try {
			//pausa a execucao por 3 segundos.
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//cobra o aluguel do jogador atual.
		jogadorAtual.movimentaConta(-propAtual.calcularAluguel());
		propAtual.getDono().movimentaConta(propAtual.calcularAluguel());
		
		System.out.println("O novo saldo de " + jogadorAtual.getNome() + " é: " + jogadorAtual.getDinheiro() + " reais.");
		System.out.println("O novo saldo de " + propAtual.getDono().getNome() + " é: " + propAtual.getDono().getDinheiro() + " reais.");
		
		//verifica se ele ficou com a conta zerada.
		jogadorAtual = verificaSaldo(tabuleiro, jogadorAtual);
		
		return jogadorAtual;
	}
	
	public static void jogo(Tabuleiro tabuleiro, Scanner leitura) {
		boolean jogando = true;
		int indiceJog = 0, posAntiga, posNova, indiceCarta;
		int efeitoCarta, resposta;
		String nomeJogAtual;
		Jogador jogadorAtual;
		
		//cria o dado
		int dado;
		Random random = new Random();
		int min = 1;
		int max = 7;		
		
		while (jogando) {
			
			jogadorAtual = tabuleiro.getJogadores().get(indiceJog);
			nomeJogAtual = tabuleiro.getJogadores().get(indiceJog).getNome();
			
			
			
			tabuleiro.salvaLog("Vez de " + nomeJogAtual);
			tabuleiro.salvaLog(jogadorAtual.toString());
			tabuleiro.salvaLog("\n");
			System.out.println("Pressione enter para jogar os dados! =)");
			leitura.nextLine();
			tabuleiro.salvaLog("Jogando os dados...");
			
			try {
				//pausa a execucao por 3 segundos.
				Thread.sleep(3000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			dado = random.nextInt(min, max);
			tabuleiro.salvaLog("Número tirado no dado: " + dado);
			
			//salva a posicao antiga para verificar se chegou no fim do tabuleiro.
			posAntiga = jogadorAtual.getPosicao();
			
			//chama a funcao de andar.
			jogadorAtual.andar(dado);
			posNova = jogadorAtual.getPosicao();
			
			tabuleiro.salvaLog("Jogador parou na casa " + posNova);
			
			//verifica se passou pelo comeco.
			if ((posAntiga + dado) >= tabuleiro.getTamTabuleiro()) {
				tabuleiro.salvaLog("Passou pela casa de início. Receba 200 reais!");
				jogadorAtual.movimentaConta(200);
			}
			
			tabuleiro.salvaLog("Informações da nova posição de " + nomeJogAtual + ":");
			
			Propriedade propAtual = tabuleiro.getVetorTabuleiro()[posNova];
			
			//se for casa de sorte/reves.
			if (propAtual == null) {
				tabuleiro.salvaLog("Casa de sorte ou revés! Pressione enter para pegar uma carta!");
				leitura.nextLine();
				tabuleiro.salvaLog("Pegando uma carta...");
				try {
					//pausa a execucao por 3 segundos.
					Thread.sleep(3000);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
				//vamos usar um try/catch para verificar se o array de cartas sorte/reves nao esta vazio.
				try {
					//gera o indice aleatoriamente e remove-a do monte.
					indiceCarta = random.nextInt(tabuleiro.getCartas().size()); //o primeiro erro surge aqui, vamos dar catch nele.
					CartaSorte cartaNova = tabuleiro.getCartas().get(indiceCarta);
					tabuleiro.getCartas().remove(indiceCarta);
					
					tabuleiro.salvaLog("A carta tirada foi:");
					tabuleiro.salvaLog(cartaNova.toString());
					efeitoCarta = cartaNova.getEfeito();
					
					//movimenta a conta do jogador com base no efeito da carta.
					jogadorAtual.movimentaConta(efeitoCarta);
					tabuleiro.salvaLog("Novo saldo de " + nomeJogAtual + ": " + jogadorAtual.getDinheiro());
					
					//verifica se ele ficou com a conta zerada.
					jogadorAtual = verificaSaldo(tabuleiro, jogadorAtual);
					
				} catch (IllegalArgumentException e) {
					tabuleiro.salvaLog("As cartas de sorte/revés acabaram! Vamos pular a vez de " + nomeJogAtual + " =(");
				}
			}
			
			//se for terreno.
			else if (propAtual.getTipo().equals(TipoCarta.TERRENO)) {
				Terreno terrenoAtual = (Terreno) tabuleiro.getVetorTabuleiro()[posNova];
				
				//se for terreno sem dono.
				if (terrenoAtual.getDono() == null) {
					tabuleiro.salvaLog(nomeJogAtual + " parou em um terreno sem dono!");
					tabuleiro.salvaLog("Informações do terreno:");
					tabuleiro.salvaLog("");
					tabuleiro.salvaLog(terrenoAtual.toString());
					tabuleiro.salvaLog("");
					tabuleiro.salvaLog("Deseja comprar o terreno?");
					tabuleiro.salvaLog("Seu saldo é: " + jogadorAtual.getDinheiro() + " reais.");
					tabuleiro.salvaLog("Sim (digite 1)");
					tabuleiro.salvaLog("Não (digite 2)");
					resposta = leitura.nextInt();
					leitura.nextLine();
					
					//se for comprar o terreno.
					if (resposta == 1) {
						jogadorAtual = compraPropriedade(jogadorAtual, terrenoAtual);
					}
					
					//se nao for comprar o terreno.
					else if (resposta == 2) {
						tabuleiro.salvaLog(nomeJogAtual + " não quis comprar o terreno.");
					}
				}
					
				//se o terreno for do jogador.
				else if (terrenoAtual.getDono().getNome().equals(nomeJogAtual)) { 
					tabuleiro.salvaLog(nomeJogAtual + " parou em " + terrenoAtual.getNome() + ", um terreno que já é seu! Veja as informações:");
					tabuleiro.salvaLog(terrenoAtual.toString());
					
					//verifica se tem hotel. Se tiver, a propriedade ja esta no nivel maximo.
					if (!terrenoAtual.getHotel()) {
						tabuleiro.salvaLog("Deseja fazer algo com o terreno?");
						
						//se ainda nao completou o numero de casas.
						if (terrenoAtual.getNumeroCasas() < terrenoAtual.getMaxCasas()) {
							tabuleiro.salvaLog("- Adicionar casa (digite 1)");
							tabuleiro.salvaLog("- Não (digite 2)");
							
							resposta = leitura.nextInt();
							leitura.nextLine();
							
							//adicionar casa.
							if (resposta == 1) {
								jogadorAtual = compraCasa(jogadorAtual, terrenoAtual);
							}
						}
						
						//aqui, ja completou o numero de casas, mas nao tem hotel.
						else {
							tabuleiro.salvaLog("- Adicionar hotel (digite 1)");
							tabuleiro.salvaLog("- Não (digite 2)");
							
							resposta = leitura.nextInt();
							leitura.nextLine();
							
							//adicionar hotel.
							if (resposta == 1) {
								jogadorAtual = compraHotel(jogadorAtual, terrenoAtual);
							}
						}
					}
					//terreno no nivel maximo.
					else {
						tabuleiro.salvaLog("Como o terreno já está no nível máximo, não há o que aprimorar.");
					}
				}
				
				//se o terreno for de outro jogador.
				else {
					jogadorAtual = pagaAluguel(tabuleiro, jogadorAtual, terrenoAtual, leitura);
				}
			}
			
			//se for servico publico.
			else if (propAtual.getTipo().equals(TipoCarta.SERVICOPUBLICO)) {
				ServicoPublico SPAtual = (ServicoPublico) propAtual;
				
				//servico publico sem dono.
				if (SPAtual.getDono() == null) {
					tabuleiro.salvaLog(nomeJogAtual + " parou em um serviço público sem dono!");
					tabuleiro.salvaLog("Informações do serviço público:");
					tabuleiro.salvaLog("");
					tabuleiro.salvaLog(SPAtual.toString());
					tabuleiro.salvaLog("");
					tabuleiro.salvaLog("Deseja comprar " + SPAtual.getNome() + "?");
					tabuleiro.salvaLog("Seu saldo é: " + jogadorAtual.getDinheiro() + " reais.");
					tabuleiro.salvaLog("Sim (digite 1)");
					tabuleiro.salvaLog("Não (digite 2)");
					resposta = leitura.nextInt();
					leitura.nextLine();
					
					//vai comprar o servico publico.
					if (resposta == 1) {
						jogadorAtual = compraPropriedade(jogadorAtual, SPAtual);
					}
					
					else if (resposta == 2) {
						tabuleiro.salvaLog(nomeJogAtual + " não quis comprar " + SPAtual.getNome());
					}
				}
				
				//servico publico eh do jogador atual.
				else if(SPAtual.getDono().getNome().equals(nomeJogAtual)) {
					tabuleiro.salvaLog(nomeJogAtual + " parou em " + SPAtual.getNome() + ", um serviço público que já é seu! Veja as informações:");
					tabuleiro.salvaLog(SPAtual.toString());
					tabuleiro.salvaLog("Como a propriedade já é de " + nomeJogAtual + ", não há o que comprar ou aprimorar.");
				}
				
				//servico publico eh de outro jogador.
				else {
					jogadorAtual = pagaAluguel(tabuleiro, jogadorAtual, SPAtual, leitura);
				}
			}
			
			//se for estacao
			else if (propAtual.getTipo().equals(TipoCarta.ESTACAO)) {
				Estacao estacaoAtual = (Estacao) propAtual;
				
				//se a estacao nao tiver dono.
				if (estacaoAtual.getDono() == null) {
					tabuleiro.salvaLog(nomeJogAtual + " parou em uma estação sem dono!");
					tabuleiro.salvaLog("Informações da estação:");
					tabuleiro.salvaLog("");
					tabuleiro.salvaLog(estacaoAtual.toString());
					tabuleiro.salvaLog("");
					tabuleiro.salvaLog("Deseja comprar " + estacaoAtual.getNome() + "?");
					tabuleiro.salvaLog("Seu saldo é: " + jogadorAtual.getDinheiro() + " reais.");
					tabuleiro.salvaLog("Sim (digite 1)");
					tabuleiro.salvaLog("Não (digite 2)");
					resposta = leitura.nextInt();
					leitura.nextLine();
					
					//vai comprar o servico publico.
					if (resposta == 1) {
						jogadorAtual = compraPropriedade(jogadorAtual, estacaoAtual);
					}
					
					else if (resposta == 2) {
						tabuleiro.salvaLog(nomeJogAtual + " não quis comprar " + estacaoAtual.getNome());
					}
				}
				
				//se a estacao for do jogador atual.
				else if (estacaoAtual.getDono().getNome().equals(nomeJogAtual)) {
					tabuleiro.salvaLog(nomeJogAtual + " parou em " + estacaoAtual.getNome() + ", uma estação que já é sua! Veja as informações:");
					tabuleiro.salvaLog(estacaoAtual.toString());
					tabuleiro.salvaLog("Como a propriedade já é de " + nomeJogAtual + ", não há o que comprar ou aprimorar.");
				}
				
				//se a estacao for de outro jogador.
				else {
					jogadorAtual = pagaAluguel(tabuleiro, jogadorAtual, estacaoAtual, leitura);
				}
			}
			
			//caso tenha restado somente um jogador, ele eh o campeao.
			if (tabuleiro.getEliminados() == (tabuleiro.getNumJog() - 1)) {
				tabuleiro.salvaLog("Temos um vencedor!");
				
				for (int i = 0; i < tabuleiro.getNumJog(); i++) {
					if (!tabuleiro.getJogadores().get(i).eliminado()) {
						tabuleiro.salvaLog("O jogador " + tabuleiro.getJogadores().get(i).getNome() + " é o grande campeão! =)");
					}
				}
				
				jogando = false;
			}
			
			else {
				tabuleiro.salvaLog("Pressione enter para passar a vez ao próximo jogador!");
				leitura.nextLine();
				tabuleiro.salvaLog("**************************************************************************************************");
				
				indiceJog++;
				if (indiceJog == tabuleiro.getNumJog()) {
					indiceJog = 0;
				}

				while (tabuleiro.getJogadores().get(indiceJog).eliminado()) {
					indiceJog++;
					
					if (indiceJog == tabuleiro.getNumJog()) {
						indiceJog = 0;
					}
				}
			}
		}
	}

	public static void main(String[] args) {		
		
		//vamos criar um scanner para receber as entradas.
		Scanner leitura = new Scanner(System.in);
		//String input = "";
		int numJogadores;
		
		//inicio do menu.
		System.out.println("Olá, bem-vindo ao Menu de Monopoly, o jogo dos negócios!");
		System.out.println("Digite o número de jogadores:");
		
		numJogadores = leitura.nextInt();
		leitura.nextLine();
		
		//vamos instanciar o tabuleiro.
		Tabuleiro tabuleiro = new Tabuleiro(numJogadores);
		
		//vamos limpar os registros antigos.
		tabuleiro.limpaLog();
		
		for (int i = 1; i <= numJogadores; i++) {
			System.out.println("Participante " + i + ":");
			tabuleiro.addJogador(leitura);
		}
		
		System.out.println("Vamos começar o jogo!");
		
		tabuleiro = criaTabuleiro(tabuleiro);
		
		jogo(tabuleiro, leitura);
		
		System.out.println("PRESSIONE ENTER PARA VER O REGISTRO DA AÇÕES NO JOGO:");
		leitura.nextLine();
		
		tabuleiro.lerLog();
			
		leitura.close();
		
	}
}