package application;

import domain.Pessoa;

public class Main {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa(1, "Luiz Felipe", "luiz@gmail.com");
        Pessoa p2 = new Pessoa(2, "Matheus Olegario", "matheus@gmail.com");
        Pessoa p3 = new Pessoa(3, "Beatriz Oliveira", "bia@gmail.com");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

    }
}