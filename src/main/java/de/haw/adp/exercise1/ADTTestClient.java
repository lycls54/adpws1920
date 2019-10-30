package main.java.de.haw.adp.exercise1;

public class ADTTestClient {

    public static void main(String[] args) {
        ADTList adt = new ADTList();
        System.out.println("excepted true = " + adt.isEmpty());
        Element first = new Element("serro");
        adt.add(first);
        adt.add(new Element("verro"));
        adt.add(new Element("test"));
        Element last = new Element("test2");
        adt.add(last);

        System.out.println(adt.toString());

        System.out.println("excepted false = " + adt.isEmpty());
        try {
            System.out.println(adt.readAt(4));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ungültige index");
        }

        Element elem = new Element("göt");
        System.out.println("excepted false = " + adt.contains(elem));

        System.out.println("first excepted serro = " + adt.readAt(0).equals(first));
        System.out.println("last excepted test2 = " + adt.readAt(adt.length() - 1).equals(last));
    }
}
