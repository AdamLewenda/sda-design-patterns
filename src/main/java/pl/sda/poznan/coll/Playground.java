package pl.sda.poznan.coll;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Playground {
    public static void main(String[] args) {
/*        String imie = "Piotr";
        String imieZenskie = "Ala";

        System.out.println(imie.compareTo(imieZenskie)); // wartosc >0
        System.out.println(imieZenskie.compareTo(imie)); // wartosc <0
        System.out.println(imieZenskie.compareTo("Ala"));// wartosc =0*/

        Person student = new Person("Jan", "Kowalski", 20);
        Person kierownik = new Person("Adam", "Nowak", 25);
        Person dyrektor = new Person("Alina", "Adamska", 30);

        List<Person> people = Arrays.asList(student, kierownik, dyrektor);

        //sortowanie z uzyciem Collections.sort
        Collections.sort(people);

        //sortowanie z uzyciem Comparator
        people.sort((person1, person2) -> person1.getName().compareTo(person2.getName()));

        people.stream()
                .filter(p -> p.getAge() > 22)
                .filter(p -> p.getName().startsWith("A"))
                .collect(Collectors.toList());

        //method reference
        people.stream()
                .map(Person::getSurname);

    }
}
