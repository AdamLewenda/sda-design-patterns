package pl.sda.poznan.coll;

import java.util.Arrays;
import java.util.List;

public class LambdaPlayground {

    public static void foo(Calc calc, int a, int b) {
        System.out.println(calc.calculate(a, b));
    }

    public static void main(String[] args) {

        foo((a, b) -> a - b, 10, 3);

        Calc add = (a, b) -> a + b;

        System.out.println(add.calculate(5, 10));
        System.out.println(add.calculate(25, 17));

        Calc multiply = (a, b) -> a * b;

        System.out.println(multiply.calculate(5, 5));
///////////////
        List<Integer> lst = Arrays.asList(1, 5, 2, 3, 4, 8, 10);
        lst.stream().filter(x -> x > 5);

        lst.forEach(x -> System.out.println(x));

    }
}
