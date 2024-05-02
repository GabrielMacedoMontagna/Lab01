package main;

import java.util.ArrayList;
import java.util.Scanner;

import tipos_cartas.Propriedade;
import tipos_cartas.Carta;
import tipos_cartas.CartaSorte;
import tipos_cartas.Estacao;
import tipos_cartas.ServicoPublico;
import tipos_cartas.Terreno;

public class Tabuleiro {
	private ArrayList<Jogador> jogadores;
	private ArrayList<Propriedade> propriedades;
	private ArrayList<Carta> cartas; //nao estava no UML, mas ajuda muito a lidar com todas as cartas na ordem do id de cada uma. nao fiz metodo pra ela ainda.
	
	//Construtor.
	public Tabuleiro() {
		jogadores = new ArrayList<Jogador>();
		propriedades = new ArrayList<Propriedade>();
		cartas = new ArrayList<Carta>();
	}
	
	//getters.
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}
	
	//demais métodos.
	public void addJogador(Scanner leitura) {
		
		Jogador jogadorNovo = new Jogador(leitura.next(), leitura.next(), leitura.next(), leitura.next(), leitura.next());
		
		//verifica se o jogador ja esta no array.
		if (!jogadores.contains(jogadorNovo)) {
			jogadores.add(jogadorNovo);
		}
	}
	
	public void removeJogador(Jogador jogadorRemovido) {
		
		//verifica se o array nao esta vazio e se o jogador procurado esta no array.
		if (!jogadores.isEmpty() && jogadores.contains(jogadorRemovido)) {
			jogadores.remove(jogadorRemovido);
		}
	}
	
	public void addPropriedade(Scanner leitura) {
		int preco, aluguel;
		boolean adicionou = false;
		String nome, descricao;
		
		System.out.println("Defina o tipo da nova propriedade:");
		System.out.println("- Estação (digite 1).");
		System.out.println("- Serviço Público (digite 2).");
		System.out.println("- Terreno (digite 3).");
		
		int resposta = leitura.nextInt();
		leitura.nextLine(); //remove o \n que ficou depois de resposta.
		
		
		if (resposta != 1 && resposta != 2 && resposta != 3) {
			System.out.println("Comando incorreto, abortando nova propriedade.");
		}
		
		else {
			System.out.println("Digite o nome da propriedade:");
			nome = leitura.nextLine();
			
			System.out.println("Digite uma descrição breve para " + nome + ":");
			descricao = leitura.nextLine();
			
			System.out.println("Digite o preço de compra de " + nome + ":");
			preco = leitura.nextInt();
			
			System.out.println("Digite o valor do aluguel base de " + nome + ":");
			aluguel = leitura.nextInt();
			
			//terreno.
			if (resposta == 3) {
				System.out.println("Indique o valor de compra de uma casa em " + nome + ":");
				int precoCasa = leitura.nextInt();
				
				System.out.println("Indique o valor de compra do hotel em " + nome + ":");
				int precoHotel = leitura.nextInt();
				
				Terreno propNova = new Terreno(preco, aluguel, nome, descricao, 0, precoCasa, precoHotel, false);
				if (!propriedades.contains(propNova)) {
					propriedades.add(propNova);
					adicionou = true;
				}
			}
			
			//servico publico.
			else if (resposta == 2){
				ServicoPublico propNova = new ServicoPublico(preco, aluguel, nome, descricao);
				if (!propriedades.contains(propNova)) {
					propriedades.add(propNova);
					adicionou = true;
				}
			}
			
			//estacao.
			else if (resposta == 1){
				Estacao propNova = new Estacao(preco, aluguel, nome, descricao);
				if (!propriedades.contains(propNova)) {
					propriedades.add(propNova);
					adicionou =  true;
				}
			}
			
			if (!adicionou) {
				System.out.println(nome + "já faz parte do tabuleiro!");
			}
			
			else {
				System.out.println(nome + "foi adicionada com sucesso!");
			}	
		}
	}
	
	public void removePropriedade(Propriedade propriedadeRemovida) {
		
		//verifica se o array nao esta vazio e se a propriedade procurada esta no array.
		if (!propriedades.isEmpty() && propriedades.contains(propriedadeRemovida)) {
			propriedades.remove(propriedadeRemovida);
		}
	}
	
	public void addCartaSorte(Scanner leitura) {
		int movimento, efeito, tempo;
		float valor;
		String acao, restricao, descricao;
		CartaSorte CS;
		
		System.out.println("Descreva brevemente a função da carta no jogo/jogador:");
		
		descricao = leitura.nextLine();
		
		System.out.println("Digite qual o movimento da carta (se a peça vai pra frente ou pra trás no tabuleiro).");
		System.out.println("Se o movimento da carta for para trás, digite o valor negativo das casas.");
		System.out.println("Se não houver movimento, digite 0.");
		movimento = leitura.nextInt();
		
		System.out.println("Indique o efeito da carta. Se for positivo, digite 1; se for negativo, -1; se for neutro, 0.");
		efeito = leitura.nextInt();
		
		System.out.println("Indique o tempo de ação ou de duração da carta. Se a carta não tiver essa propriedade, digite 0.");
		tempo = leitura.nextInt();
		
		System.out.println("Se essa carta envolver pagamento ou recebimento de dinheiro, indique a quantia. Caso contrário, digite 0.");
		valor = leitura.nextFloat();
		leitura.nextLine(); //remove o \n que ficou depois de valor.

		System.out.println("Se essa carta gera alguma ação no jogo, descreva-a brevemente.");
		acao = leitura.nextLine();
		
		System.out.println("Se essa carta gera alguma restrição no jogo/jogador, descreva-a brevemente. Caso contrário, dê enter.");
		restricao = leitura.nextLine();
		
		CS = new CartaSorte(movimento, efeito, tempo, valor, descricao, acao, restricao);
		
		//verifica se a carta ja esta no tabuleiro.
		if (!cartas.contains(CS)) {
			cartas.add(CS);
			System.out.println("Carta adicionada com sucesso!");
		}
		
		else {
			System.out.println("A carta em questão já está no jogo.");
		}
	}
}
