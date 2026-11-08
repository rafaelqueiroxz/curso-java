package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Número do quarto: ");
            int numeroQuarto = sc.nextInt();
            System.out.print("Data de check-in (dd/mm/yyyy): ");
            sc.nextLine();
            LocalDate checkIn = LocalDate.parse(sc.nextLine(), dtf);
            System.out.print("Data de check-out (dd/mm/yyyy): ");
            LocalDate checkOut = LocalDate.parse(sc.nextLine(), dtf);

            Reservation reservation = new Reservation(numeroQuarto, checkIn, checkOut);
            System.out.println("Reserva: " + reservation);

            System.out.println("\nEntre com a data para atualização da reserva: ");
            System.out.print("Nova data de check-in (dd/mm/yyyy): ");
            checkIn = LocalDate.parse(sc.nextLine(), dtf);
            System.out.print("Nova data de check-out (dd/mm/yyyy): ");
            checkOut = LocalDate.parse(sc.nextLine(), dtf);

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reserva: " + reservation);

        } catch (DomainException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro Inesperado");
        }


        sc.close();

    }
}