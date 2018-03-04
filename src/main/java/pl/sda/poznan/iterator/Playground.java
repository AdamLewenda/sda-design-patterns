package pl.sda.poznan.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Playground {

    //var - args
    //linia ponizej to nic innego jak tablica
    public static void foo(String... mojeNapisy) {

    }

    public static void main(String[] args) {

        foo("piotr");

        List<String> names = Arrays.asList("Piotr", "Jan", "Ala");


        for (int i = 0; i < names.size(); i++) {
            String s = names.get(i);
            System.out.println();
        }

        System.out.println("petla for each ....");
        for (String s : names) {
            System.out.println(s);
        }


        System.out.println("Z uzyciem iteratora: .....");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println("Pobrana wartosc to: " + next);
        }
    }
}
