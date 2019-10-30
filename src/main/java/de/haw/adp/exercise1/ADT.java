package main.java.de.haw.adp.exercise1;

import java.util.Iterator;

public interface ADT<T> {

    // hinzufügen
    ADT<T> add(T obj);

    // vorne löschen
    T removeFirst();

    // hinten löschen
    T removeLast();

    // an beliebigen Stellen löschen
    T removeAt(int index);

    // an beliebigen Stellen einfügen
    T addAt(int index, T obj);

    // prüfen, ob die Liste leer ist
    boolean isEmpty();

    // Repräsentation des Listeninhalts als Zeichenkette
    @Override
    String toString();

    // einen Iterator für die Elemente liefern
    Iterator<T> iterator();

    // ein Element löschen ???
    T remove(T elem);

    // auf Enthaltensein prüfen ???
    boolean contains(T elem);

    // Objekte an einer Position lesen ???
    T readAt(int index);

    // Größe bestimmen
    int length();

}
