import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matriz = new int[m][n];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        int alvo = sc.nextInt();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == alvo) {
                    System.out.printf("\nPosição %d, %d:\n", i, j);
                    if (j-1 >= 0) {
                        System.out.println("Esquerda: " + matriz[i][j-1]);
                    }
                    if (j+1 < matriz[i].length) {
                        System.out.println("Direita: " + matriz[i][j+1]);
                    }
                    if (i-1 >= 0 ) {
                        System.out.println("Acima: " + matriz[i-1][j]);
                    }
                    if (i+1 < matriz[i].length) {
                        System.out.println("Abaixo: " + matriz[i+1][j]);
                    }
                }
            }
        }

        sc.close();

    }
}