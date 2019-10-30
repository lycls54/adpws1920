package main.java.de.haw.adp.exercise1;

import java.util.Iterator;

public class ADTList implements ADT<Element> {

    private Element first;
    private Element last;


    public ADTList() {
        first = new Element();
        first.setIndex(-1);
        last = new Element();
        first.setSucc(last);
        last.setPred(first);
    }

    @Override
    public ADT<Element> add(Element obj) {
        obj.setPred(last.getPred());
        obj.setIndex(last.getPred().getIndex() + 1);
        last.getPred().setSucc(obj);
        obj.setSucc(last);
        last.setPred(obj);
        return this;
    }

    @Override
    public Element removeFirst() {
        if (isEmpty()) {
            // ?    throw new IndexOutOfBoundsException();
        }
        Element elem = first.getSucc();

        elem.getSucc().setPred(first);
        first.setSucc(elem.getSucc());

        elem.setSucc(null);
        elem.setPred(null);
        //refresh index
        Element e = first;
        do {
            e.getSucc().setIndex(e.getIndex() + 1);
        } while (e != last);
        return elem;
    }

    @Override
    public Element removeLast() {
        if (isEmpty()) {
            // ?    throw new IndexOutOfBoundsException();
        }
        Element elem = last.getPred();
        elem.getSucc().setPred(elem.getPred());
        elem.getPred().setSucc(elem.getSucc());
        elem.setPred(null);
        elem.setSucc(null);
        return elem;
    }

    @Override
    public Element removeAt(int index) {
        if (index > last.getPred().getIndex()) {
            throw new IndexOutOfBoundsException();
        }

        // findat
        Element elementAt = readAt(index);
        // removeat

        elementAt.getSucc().setPred(elementAt.getPred());
        elementAt.getPred().setSucc(elementAt.getSucc());

        Element elementAtSuc = elementAt.getSucc();
        elementAt.setSucc(null);
        elementAt.setPred(null);
        // refresh index
        while (elementAtSuc != last) {

            elementAtSuc.setIndex(elementAtSuc.getPred().getIndex() + 1);
            elementAtSuc = elementAtSuc.getSucc();
        }
        return elementAt;
    }

    @Override
    public Element addAt(int index, Element obj) {
        if (index > last.getPred().getIndex()) {
            throw new IndexOutOfBoundsException();
        }

        // findat
        Element elementAt = readAt(index);
        // addat
        elementAt.getPred().setSucc(obj);
        obj.setPred(elementAt.getPred());
        elementAt.setPred(obj);
        obj.setSucc(elementAt);
        // refresh index
        elementAt = obj;
        while (elementAt != last) {

            elementAt.setIndex(elementAt.getPred().getIndex() + 1);
            elementAt = elementAt.getSucc();
        }
        System.out.println(readAt(index).getIndex());
        return elementAt;
    }

    @Override
    public boolean isEmpty() {
        return (first.getSucc().equals(last));
    }

    @Override
    public Iterator<Element> iterator() {

        return new Iterator<Element>() {
            private int position = 0;

            @Override
            public boolean hasNext() {

                return position < length();
            }

            @Override
            public Element next() {
                if (hasNext()) {
                    Element e = readAt(position);
                    position++;
                    return e;
                } else {
                    return null;
                }
            }
        };
    }

    @Override
    public Element remove(Element elem) {
        if (contains(elem)) {
            elem.getSucc().setPred(elem.getPred());
            elem.getPred().setSucc(elem.getSucc());

            elem.setPred(null);
            elem.setSucc(null);
            return elem;
        } else {
            // ? throw new IndexOutOfBoundsException();
        }
        return null;
    }

    @Override
    public boolean contains(Element elem) {
        Element element = first;
        while (element != last) {
            if (element == elem) {
                return true;
            }
            element = element.getSucc();
        }
        return false;
    }

    @Override
    public Element readAt(int index) {

        //TODO binary search
        Element elementAt = first;
        for (int i = 0; i <= index; i++) {
            elementAt = elementAt.getSucc();
            if (elementAt == last) {
                throw new IndexOutOfBoundsException();
            }
        }
        return elementAt;
    }

    @Override
    public int length() {
        int acc = 0;
        if (isEmpty()) {
            return 0;
        }
        Element pointer = first.getSucc();
        while (true) {
            acc++;
            if (pointer.getSucc() == last) {
                break;
            }

            pointer = pointer.getSucc();
        }
        return acc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Element> it = iterator();
        while (it.hasNext()) {

            Element e = it.next();
            sb.append(e.getContent());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
