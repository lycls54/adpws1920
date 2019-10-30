package main.java.de.haw.adp.exercise1;

import main.java.de.haw.adp.Stopwatch;

import java.util.ArrayList;
import java.util.List;

public class PerformanceTest {

    public static void main(String[] args) {

        // an beliebigen Stellen einfügen
        // an beliebigen Stellen löschen
        // auf Enthaltensein prüfen
        // Objekt löschen
        ADTList adtList = new ADTList();
        for (int i = 0; i < 400000; i++) {
            adtList.add(new Element("" + i));
        }
        List<Element> elements = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            elements.add(new Element("1" + i));
        }


        System.out.println("add element at");
        Stopwatch stopwatch;
        for (int j = 0; j < 10; j++) {
             stopwatch = new Stopwatch();
            for (int i = 0; i < 500; i++) {
                adtList.addAt(80500, elements.get(i));
            }
            System.out.println(stopwatch.elapsedTime() + " " + stopwatch.elapsedTime() / 500);
        }
        System.out.println("remove element at");

        for (int j = 0; j < 10; j++) {
            stopwatch = new Stopwatch();
            for (int i = 0; i < 500; i++) {
                adtList.removeAt(80000);
            }

        System.out.println(stopwatch.elapsedTime() + " " + stopwatch.elapsedTime() / 500);
    }
        System.out.println("contains element");

        for (int j = 0; j < 10; j++) {
            stopwatch = new Stopwatch();
            for (int i = 0; i < 500; i++) {
                adtList.contains(elements.get(i));
            }

        System.out.println(stopwatch.elapsedTime() + " " + stopwatch.elapsedTime() / 500);
        }
        System.out.println("remove element");

        for (int j = 0; j < 10; j++) {
            stopwatch = new Stopwatch();
            for (int i = 0; i < 500; i++) {
                adtList.remove(elements.get(i));
            }
        System.out.println(stopwatch.elapsedTime() + " " + stopwatch.elapsedTime() / 500);
        }

    }
}
