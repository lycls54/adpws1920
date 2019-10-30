package main.java.de.haw.adp.exercise1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ADTListTest {
    private Element e1 = new Element("1");
    private Element e2 = new Element("2");
    private Element e3 = new Element("3");
    private Element e4 = new Element("4");
    private Element e5 = new Element("5");
    private Element e6 = new Element("6");

    @Test
    public void isEmptyTest() {
        ADTList list = new ADTList();
        assertTrue(list.isEmpty());
        list.add(e1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void firstAndLastTest() {
        ADTList list = new ADTList();
        list.add(e1).add(e2).add(e3).add(e4);
        assertEquals(list.readAt(0), e1);
        assertEquals(list.readAt(list.length() - 1), e4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidIndexTest() {
        ADTList list = new ADTList();
        list.add(e1).add(e2).add(e3).add(e4);
        list.removeAt(5);
    }

    @Test
    public void containsTest() {
        ADTList list = new ADTList();
        list.add(e1).add(e2).add(e3).add(e4);
        assertFalse(list.contains(e5));
        assertTrue(list.contains(e3));
    }

    @Test
    public void addAtTest() {
        ADTList list = new ADTList();
        list.add(e1).add(e2).add(e3).add(e4);
        list.addAt(1, e6);
        assertEquals(list.readAt(1), e6);
        list.addAt(1, e5);
        assertEquals(list.readAt(1), e5);
    }

    @Test
    public void indexTest() {
        ADTList list = new ADTList();
        list.add(e1).add(e2).add(e3).add(e4);
        assertEquals(e4.getIndex(), 3);
        assertEquals(e2.getIndex(), 1);
        assertEquals(e3.getIndex(), 2);
        assertEquals(e1.getIndex(), 0);
        list.addAt(1, e5);
        assertEquals(e5.getIndex(), 1);
        assertEquals(e4.getIndex(), 4);
        assertEquals(e2.getIndex(), 2);
        assertEquals(e3.getIndex(), 3);
        assertEquals(e1.getIndex(), 0);
        list.addAt(0, e6);
        assertEquals(e6.getIndex(), 0);
        assertEquals(e5.getIndex(), 2);
        assertEquals(e4.getIndex(), 5);
        assertEquals(e2.getIndex(), 3);
        assertEquals(e3.getIndex(), 4);
        assertEquals(e1.getIndex(), 1);
        list.removeAt(2);
        assertEquals(list.readAt(2), e2);
        assertEquals(e2.getIndex(), 2);
    }


}