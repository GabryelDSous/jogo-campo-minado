package Classes;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Campo_Minado {

	public static void main(String[] args) {
		/*
		 * 0 = não escolhido
		 * 1 = onde tem bomba
		 * 2 = ja escolhido
		 * 3 = bomba esplode 
		 */
		// INTANCIANDO CLASSE RANDOM
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
		
		// JOGANDO
		int doInicio = 0, tentativas = 0, pontos = 0;
		do {
			// ESCREVENDO NA TELA ? ? ? ?
			for(int l = 0; l < casas.length; l++) {
				for(int c = 0; c < casas.length; c++) {
					System.out.print("?\t");
				}
				System.out.println("\n");
			}
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
			
			
			// FIM DO JOGO
			tentativas++;
		}while(tentativas < 5);
	}

}
