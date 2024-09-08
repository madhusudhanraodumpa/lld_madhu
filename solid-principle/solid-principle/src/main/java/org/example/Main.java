package org.example;

import org.example.model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Flyable> flyableList = new ArrayList<>();
        Crow c= new Crow();
        c.setName("crow");
        flyableList.add(c);
        Parrot p = new Parrot();
        p.setName("parrot");
        flyableList.add(p);
        Pigeon pi = new Pigeon();
        pi.setName("pigeon");
        flyableList.add(pi);

        for (Flyable b : flyableList) {

            b.fly();


        }
    }
}