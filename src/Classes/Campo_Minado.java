package Classes;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Campo_Minado {

	public static void main(String[] args) {
		/*
		 * 0 = não escolhido ?
		 * 1 = onde tem bomba ?
		 * 2 = ja escolhido V
		 * 3 = bomba esplode *
		 */
		// INTANCIANDO CLASSE RANDOM E SCANNER
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("----------------------------------");
		System.out.println("\t  CAMPO MINADO");
		System.out.println("----------------------------------");

		// PREENCHENDO VALOR COM 0
		int[][] casas = new int[5][5];
		for(int l = 0; l < casas.length; l++) {
			for(int c = 0; c < casas.length; c++) {
				casas[l][c] = 0;
			}
		}
		
		// COLOCANDO BOMBAS ALEATORIAMENTE
		int col = 0, li = 0, cont = 0;
		while(cont < 5) {
			col = random.nextInt(casas.length - 1);
			li = random.nextInt(casas.length - 1);
			if(casas[li][col] == 1) {}
			else {
				casas[li][col] = 1;
				cont++;
			}
		}
		
		// ESCREVENDO NA TELA ? ? ? ?
		for(int l = 0; l < casas.length; l++) {
			for(int c = 0; c < casas.length; c++) {
				System.out.print("?\t");
			}
			System.out.println("\n");
		}
		
		// JOGANDO
		int doInicio = 0, tentativas = 0, pontos = 0;
		boolean ganhou = true;
		do {
			
			System.out.println("----------------------------------");
			// PEGANDO LINHA E COLUNA
			int linha, coluna;
			// Linha
			do {
				System.out.print("Informe a linha: ");
				try {
					linha = scanner.nextInt() - 1;
					if(linha >= casas.length) {
						System.out.println("A linha informada não existe!");
					} else break;
				}catch(InputMismatchException e) {
					scanner.nextLine();
					System.out.println("Informe uma linha Valida!");
				}
			}while(true);
			
			// Coluna
			do {
				System.out.print("Informe a coluna: ");
				try {
					coluna = scanner.nextInt() - 1;
					if(coluna >= casas.length) {
						System.out.println("A linha informada não existe!");
					} else break;
				}catch(InputMismatchException e) {
					scanner.nextLine();
					System.out.println("Informe uma linha Valida!");
				}
			}while(true);
			System.out.println("----------------------------------");
			
			// VERIFICANDO ESCOLHAS IGUAIS
			
			if(casas[linha][coluna] == 2) {
				System.out.println("Você ja escolheu essa posição!");
				continue;
			}
			tentativas++;
			// MODIFICANDO A LINHA E COLUNA INDICADA
			for(int l = 0; l < casas.length; l++) {
				for(int c = 0; c < casas.length; c++) {
					if(casas[linha][coluna] == 0) casas[linha][coluna] = 2;
					else if(casas[linha][coluna] == 1) casas[linha][coluna] = 3;
				}
				
			}
			
			// MOSTRANDO A LINHA MODIFICADA
			for(int l = 0; l < casas.length; l++) {
				for(int c = 0; c < casas.length; c++) {
					if(casas[l][c] == 0 || casas[l][c] == 1) System.out.print("?\t");
					else if(casas[l][c] == 2) System.out.print("V\t");
					else if(casas[l][c] == 3) {
						System.out.print("*\t");
						ganhou = false;
					}
				}
				System.out.println("\n");
			}
			// FIM DO JOGO
			pontos+=2;		
		}while(tentativas < 5 && ganhou);
		
		System.out.println("----------------------------------");
		System.out.println("FIM DE JOGO");
		System.out.printf("TOTAL DE PONTOS: %d\n", pontos);
		System.out.printf("TOTAL DE TENTATIVAS: %d\n", tentativas);
		System.out.println("----------------------------------");
	}
}