package main;


public class Validacao {

	private static boolean verificaDigitosIguais(String cpf) {
		char char_atual;
		char prox_char;
		int i = 0;
		
		char_atual = cpf.charAt(0);
		prox_char = cpf.charAt(1);
		
		while (char_atual == prox_char) {
			i++;
			
			//Aqui, quer dizer que chegou no final do cpf, entao retorna false.
			if(i == 10) {
				return false;
			}
			char_atual = cpf.charAt(i);
			prox_char = cpf.charAt(i + 1);
		}
		
		return true;
	}
	
	private static int calculaPrimeiroVerificador(int cpf_inteiros[]) {
		int i, j = 10, somatoria = 0, resultado;
		
		//Para um cpf qualquer, vamos multiplicar seus digitos pelos numeros de 1 a 10, em ordem decrescente.
		for (i = 0; i < (cpf_inteiros.length - 2); i++) {
			somatoria += cpf_inteiros[i] * j;
			j--;
		}
		resultado = (somatoria * 10) % 11;
		
		if (resultado == 10) {
			resultado = 0;
		}
		
		return resultado;
	}
	
	private static int calculaSegundoVerificador(int cpf_inteiros[]) {
		int i, j = 11, somatoria = 0, resultado;
		
		//Para um cpf qualquer, vamos multiplicar seus digitos pelos numeros de 1 a 11,
		//incluindo o primeiro verificador, em ordem decrescente.
		for (i = 0; i < (cpf_inteiros.length - 1); i++) {
			somatoria += cpf_inteiros[i] * j;
			j--;
		}
		resultado = (somatoria * 10) % 11;
		
		if (resultado == 10) {
			resultado = 0;
		}
		
		return resultado;
	}
	
	public static boolean validarCpf(String cpf) {
		
		int cpf_inteiros[];
		int digito_verificador1, digito_verificador2;
		char suporte;
		int i = 0;
		
		
		//Vamos inicializar o vetor cpf_inteiros;
		cpf_inteiros = new int[11];
		
		//Primeiro, vamos eliminar tudo que nao eh numero.
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		
		//Agora, vamos contar se o cpf tem 11 digitos de fato.
		if (cpf.length() != 11) {
			return false;
		}
		
		//Agora, vamos verificar se os digitos do cpf nao sao todos iguais.
		if (!(verificaDigitosIguais(cpf))) {
			return false;
		}
		
		//Agora, vamos transformar a string cpf em um vetor de inteiros.
		for (i = 0; i < cpf.length(); i++) {
			suporte = cpf.charAt(i);
			cpf_inteiros[i] = Character.getNumericValue(suporte);
		}
		
		//Agora, vamos verificar se o cpf eh valido usando os digitos verificadores.
		digito_verificador1 = calculaPrimeiroVerificador(cpf_inteiros);
		
		if (digito_verificador1 != cpf_inteiros[9]) {
			return false;
		}
		
		digito_verificador2 = calculaSegundoVerificador(cpf_inteiros);
		
		if (digito_verificador2 != cpf_inteiros[10]) {
			return false;
		}
		
		return true;
	}
	
	public static boolean validarEmail(String email) {
		
		int posicao_arroba;
		char suporte;
		boolean achou_ponto = false;
		
		//Vamos verificar se o email em questao tem @.
		posicao_arroba = email.indexOf('@');
		
		if (posicao_arroba == -1) {
			return false;
		}
		
		//Vamos verificar se o primeiro ou o ultimo caractere eh um ponto.
		if (email.charAt(0) == '.' || email.charAt(email.length() - 1) == '.') {
			return false;
		}
		
		//Agora, vamos verificar se existe mais de um @.
		//Alem disso, vamos usar o mesmo loop para buscar por dois pontos (..) em seguida no email.
		//Tambem vamos verificar se existe um ponto depois do @ para que o dominio seja valido.
		for (int i = 0; i < email.length(); i++) {
			
			//Verifica se eh uma posicao diferente da posicao ja conhecida do @.
			if (i != posicao_arroba) {
				suporte = email.charAt(i);
				
				//Se for outro @ na posicao, o email é invalido.
				if (suporte == '@') {
					return false;
				}
				
				//Se for um ponto nessa posicao e o caractere seguinte for outro ponto, o email é invalido.
				if (suporte == '.') {
					if ((i < 10) && email.charAt(i + 1) == '.') {
						return false;
					}
					//Se o indice atual for maior do que a posicao do @,
					//o requisito do dominio do email foi atendido.
					if (i > posicao_arroba) {
						achou_ponto = true;
					}
				}
			}
		}
		
		//Se não achou ponto depois do @, o dominio é invalido.
		if (!achou_ponto) {
			return false;
		}
		
		//Agora, vamos verificar se o @ é o primeiro ou o ultimo caractere do email.
		if (posicao_arroba == 0 || posicao_arroba == (email.length() - 1)) {
			return false;
		}
		
		//Agora, vamos verificar se existe um ponto (.) imediatamente antes ou depois do @.
		if (email.charAt(posicao_arroba + 1) == '.' || email.charAt(posicao_arroba - 1) == '.') {
			return false;
		}
		
		//Ainda falta verificar se tem caractere proibido.
		
		return true;
	}
}
