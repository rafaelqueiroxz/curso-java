public class Main {
    public static void main(String[] args) {

        int x = 20; // Variável tipo valor

        Integer obj = x; // Variável tipo referência

        System.out.println(obj);

        int y = 2 * obj; // Tipo valor recebendo uma variável tipo referência

        System.out.println(y);

    }
}