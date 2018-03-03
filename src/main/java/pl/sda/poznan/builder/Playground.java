package pl.sda.poznan.builder;

import java.time.LocalDate;

public class Playground {
    public static void main(String[] args) {
//        Reservation reservation = new Reservation();
//        reservation.setCity("Poznań");
//        reservation.setHeadcount(199);

        Reservation.ReservationBuilder rb = Reservation.builder()
                .city("Poznan")
                .headcount(100)
                .price(99d);

        //odczyt z pliku
        rb.date(LocalDate.parse("2018-03-03"));

        //zakoncz proces budowania - zwroc gotowy obiekt
        Reservation build = rb.build();
        System.out.println(build);

        //inny scenariusz - znam wszystkie wartosci od razu
        Reservation wroclaw = Reservation.builder()
                .date(LocalDate.parse("2018-09-09"))
                .headcount(100)
                .price(20)
                .city("Wroclaw")
                .build();
    }
}
