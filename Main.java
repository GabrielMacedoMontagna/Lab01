public class Main {

	public static void main(String[] args) {
		//Vamos comecar instanciando os jogadores.
		Jogador J1, J2, J3;
		Peca P1, P2, P3;
		CartaSorte C1, C2, C3, C4, C5;
		
		J1 = new Jogador("Jogador1", "123.456.789-00", "Jogador1@gmail.com", "foto J1");
		J2 = new Jogador("Jogador2", "111.222.333-44", "Jogador2@hotmail.com", "foto J2");
		J3 = new Jogador("Jogador3", "999.888.777-66", "Jogador3@yahoo.com", "foto J3");
		
		//Agora, vamos instanciar as pecas de cada jogador.
		P1 = new Peca(0, "Azul");
		P2 = new Peca(0, "Vermelho");
		P3 = new Peca(0, "Amarelo");
		
		//Agora, vamos instanciar alguns tipos de cartas.
		C1 = new CartaSorte(1, 0, -1, 0, 0, "Prisão", "Fique duas rodadas na prisão!", "Não há restrição");
		C2 = new CartaSorte(2, 0, 0, 0, 0, "Construção", "Construa em sua propriedade.", "A carta deve ser usada imediatamente.");
		C3 = new CartaSorte(3, 0, 1, 0, 100, "Sorte", "Seu vizinho caloteiro finalmente te pagou! Receba 100 reais do jogador à sua esquerda.", "Não há restrição");
		C4 = new CartaSorte(4, 0, -1, 0, -200, "Azar", "Você estava acima do limite de velocidade e foi multado! Pague 200 reais ao banco.", "Não há restrição");
		C5 = new CartaSorte(5, 0, 1, 0, 0, "Liberdade", "Esta carta te liberta da prisão imediatamente!", "Use agora ou guarde-a para depois.");
	}

}
