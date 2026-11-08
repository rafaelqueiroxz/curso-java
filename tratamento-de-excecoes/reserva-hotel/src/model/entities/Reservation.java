package model.entities;

import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private Integer numeroQuarto;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(Integer numeroQuarto, LocalDate checkIn, LocalDate checkOut) {

        if (checkOut.isBefore(checkIn)) {
            throw new DomainException("Erro na reserva: A data de check-out deve ser depois da data de check-in.");
        }

        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public long duration() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) {

        if (checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())) {
            throw new DomainException("Erro na reserva: As datas para atualização da reserva devem ser datas futuras.");
        }
        if (checkOut.isBefore(checkIn)) {
            throw new DomainException("Erro na reserva: A data de check-out deve ser depois da data de check-in.");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Quarto n° " + numeroQuarto
                + ", check-in: " + checkIn.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", check-out: " + checkOut.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", " + duration() + " noites";
    }


}
