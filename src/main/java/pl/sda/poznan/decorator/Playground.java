package pl.sda.poznan.decorator;

import pl.sda.poznan.decorator.shapedecorator.Circle;
import pl.sda.poznan.decorator.shapedecorator.ColoredCircle;
import pl.sda.poznan.decorator.shapedecorator.Shape;
import pl.sda.poznan.decorator.shapedecorator.TransparentCircle;

import java.io.BufferedReader;
import java.io.FileReader;

public class Playground {
    public static void main(String[] args) throws Exception {
//        FileReader fileReader = new FileReader("plik.txt");
//
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        bufferedReader.readLine();

        Circle circle = new Circle(4);
        System.out.println(circle.info()); //expected: "A circle of radius 4"


        ColoredCircle coloredCircle = new ColoredCircle(circle, "red");
        System.out.println(coloredCircle.info()); // expected: "A circle of radius 4 has a color red"

        //obiekt kola ktory ma kolor
        ColoredCircle cc = new ColoredCircle(new Circle(10), "green");
//        BufferedReader br = new BufferedReader(new FileReader("file.txt"));

        //Kolo ktore ma przejrzystosc
        TransparentCircle transparentCircle = new TransparentCircle(new Circle(14), 60);

        //Kolo ktore ma kolor i przezroczystosc
        Shape mostDecoratedShape = new TransparentCircle(new ColoredCircle(new Circle(20), "red"), 80);
        System.out.println(mostDecoratedShape.info());
    }
}
