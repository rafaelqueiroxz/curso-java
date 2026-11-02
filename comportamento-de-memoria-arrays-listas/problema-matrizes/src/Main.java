import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.print("\nDiagonal principal: ");
        for (int i = 0; i < n; i++) {
            System.out.print(mat[i][i] + " ");
        }
        System.out.println("\n");

        int qtdNegativos = 0;
        for (int i = 0; i < mat.length; i++) { // Propriedade length para as linhas da matriz
            for (int j = 0; j < mat[i].length; j++) { // Propriedade length para as colunas da matriz
                if (mat[i][j] < 0) {
                    qtdNegativos++;
                }
            }
        }

        System.out.println("Números negativos: " + qtdNegativos);

        sc.close();

    }
}