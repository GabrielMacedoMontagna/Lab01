package main;

import java.util.Scanner;
import atributos.Propriedade;
import atributos.Terreno;
import atributos.Estacao;
import atributos.ServicoPublico;

public class Main {

	public static void main(String[] args) {
		//vamos instanciar o tabuleiro.
		Tabuleiro tabuleiro = new Tabuleiro();
		
		//vamos instanciar os jogadores.
		//vamos tambem instanciar um scanner para receber as entradas.
		Scanner leitura = new Scanner(System.in);
		
		Jogador J1 = new Jogador(leitura.next(), leitura.next(), leitura.next(), leitura.next());
		leitura.close();
		
		tabuleiro.addJogador(J1.getId());
		
		Jogador J2 = new Jogador("Jogador2", "123.456.789-00", "Jogador2@gmail.com", "foto J2");
		tabuleiro.addJogador(J2.getId());
		
		Jogador J3 = new Jogador("Jogador3", "111.222.333-44", "Jogador3@hotmail.com", "foto J3");
		tabuleiro.addJogador(J2.getId());
		
		Jogador J4 = new Jogador("Jogador4", "999.888.777-66", "Jogador4@yahoo.com", "foto J4");
		tabuleiro.addJogador(J4.getId());
		
		System.out.println(J1.toString());
		System.out.println(Validacao.validarCpf(J2.getCpf()));

		
		//agora, vamos instanciar as pecas de cada jogador.
		Peca P1 = new Peca(0, "Azul");
		Peca P2 = new Peca(0, "Vermelho");
		Peca P3 = new Peca(0, "Amarelo");
		
		//agora, vamos instanciar alguns tipos de cartas.
		CartaSorte C1 = new CartaSorte(1, 0, -1, 0, 0, "Prisão", "Fique duas rodadas na prisão!", "Não há restrição");
		CartaSorte C2 = new CartaSorte(2, 0, 0, 0, 0, "Construção", "Construa em sua propriedade.", "A carta deve ser usada imediatamente.");
		CartaSorte C3 = new CartaSorte(3, 0, 1, 0, 100, "Sorte", "Seu vizinho caloteiro finalmente te pagou! Receba 100 reais do jogador à sua esquerda.", "Não há restrição");
		CartaSorte C4 = new CartaSorte(4, 0, -1, 0, -200, "Azar", "Você estava acima do limite de velocidade e foi multado! Pague 200 reais ao banco.", "Não há restrição");
		CartaSorte C5 = new CartaSorte(5, 0, 1, 0, 0, "Liberdade", "Esta carta te liberta da prisão imediatamente!", "Use agora ou guarde-a para depois.");
		
		//agora, vamos instanciar algumas propriedades.
		ServicoPublico SP1 = new ServicoPublico(100, 50, "Tratamento de água", "À venda");
		Terreno T1 = new Terreno(50, 20, "Moema", "À venda", 0, 40, 80, false);
		Estacao E1 = new Estacao(70, 30, "Estação de trem", "À venda");
		
	}
}