import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public  class Main {
    public static void main(String[] args) {

        // Formatando datas customizadas
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;


        // Instanciando datas em Java

        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();
        LocalDate d04 = LocalDate.parse("2026-11-01");
        LocalDateTime d05 = LocalDateTime.parse("2026-11-01T12:31:26");
        Instant d06 = Instant.parse("2026-11-01T02:31:26Z");
        Instant d07 = Instant.parse("2026-11-01T12:31:26-03:00");
        LocalDate d08 = LocalDate.parse("01/11/2026", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDateTime d09 = LocalDateTime.parse("01/11/2026 01:30", fmt2);
        LocalDate d10 = LocalDate.of(2026, 11, 01);
        LocalDateTime d11 = LocalDateTime.of(2026, 11, 01, 20, 34);

        System.out.println("Instanciando Datas em Java: \n");
        System.out.println("d01 = " + d01.toString());  // O to.String é o considerado por
                                                        // padrão na chamada do objeto no
                                                        // System.out.println
        System.out.println("d02 = " + d02);
        System.out.println("d03 = " + d03);
        System.out.println("d04 = " + d04);
        System.out.println("d05 = " + d05);
        System.out.println("d06 = " + d06);
        System.out.println("d07 = " + d07);
        System.out.println("d08 = " + d08);
        System.out.println("d09 = " + d09);
        System.out.println("d10 = " + d10);
        System.out.println("d11 = " + d11);

        // Transformando objeto data-hora em texto
        System.out.println("\nTransformando Objeto Data-hora em Texto: \n");
        System.out.println("d01 = " + d01.format(fmt1));
        System.out.println("d01 = " + fmt1.format(d01));
        System.out.println("d01 = " + d01.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("d02 = " + d02.format(fmt1));
        System.out.println("d02 = " + d02.format(fmt2));
        System.out.println("d03 = " + fmt3.format(d03));
        System.out.println("d02 = " + fmt4.format(d02));
        System.out.println("d03 = " + fmt5.format(d03));
        System.out.println("d03 = " + d03.toString());

        // Convertendo uma data-hora global para local
        System.out.println("\nConvertendo uma data-hora global para local:\n");
        // for (String z : ZoneId.getAvailableZoneIds()) {
        //     System.out.println(z);
        // }
        LocalDate r1 = LocalDate.ofInstant(d06,  ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06,  ZoneId.of("Portugal"));
        LocalDateTime r3 = LocalDateTime.ofInstant(d06,  ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(d06,  ZoneId.of("Portugal"));

        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);
        System.out.println("r4 = " + r4);

        System.out.println("d04 = " + d04.getDayOfMonth());
        System.out.println("d04 = " + d04.getMonthValue());
        System.out.println("d04 = " + d04.getYear());
        System.out.println("d05 = " + d05.getHour());
        System.out.println("d05 = " + d05.getMinute());

        // Calculos com Data-hora em Java
        System.out.println("\nCálculos com Data-hora em Java: \n");
        // Objetos do tipo DateTime são imutáveis logo, quando precisar
        // modificá-los, você precisará instanciar um novo objeto com
        // as informações alteradas.

        LocalDate pastWeekLocalDate = d01.minusDays(7);
        LocalDate nextWeekLocalDate = d01.plusDays(7);

        LocalDateTime pastWeekLocalDateTime = d02.minusDays(7);
        LocalDateTime nextWeekLocalDateTime = d02.plusDays(7);

        Instant pastWeekInstant = d03.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d03.plus(7, ChronoUnit.DAYS);

        Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), d01.atStartOfDay());
        Duration t2 = Duration.between(pastWeekLocalDateTime, d02);
        Duration t3 = Duration.between(pastWeekInstant, d03);
        Duration t4 = Duration.between(d03, pastWeekInstant);


        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);
        System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
        System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);
        System.out.println("pastWeekInstant = " + pastWeekInstant);
        System.out.println("nextWeekInstant = " + nextWeekInstant);
        System.out.println("t1 dias = " + t1.toDays());
        System.out.println("t2 dias = " + t2.toDays());
        System.out.println("t3 dias = " + t3.toDays());
        System.out.println("t4 dias = " + t4.toDays());


    }
}