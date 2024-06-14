package juwoncode.structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    @Test
    void add() {
        ArrayList<Integer> list = new ArrayList<>();

        list.addFirst(10);
        list.addLast(30);
        list.add(1, 20);

        int expected = 10;
        for (int i = 1; i <= 3; i++) {
            assertEquals(list.get(i - 1), expected * i);
        }
    }

    @Test
    void addFirst() {
        ArrayList<Integer> list = new ArrayList<>();

        list.addFirst(10);

        assertEquals(list.get(0), 10);
    }

    @Test
    void addLast() {
        ArrayList<Integer> list = new ArrayList<>();

        list.addFirst(10);
        list.addLast(20);

        assertEquals(list.get(1), 20);
    }

    @Test
    void get() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(0, 10);

        assertEquals(list.get(0), 10);
    }

    @Test
    void indexOf() {
        ArrayList<Integer> list = new ArrayList<>();

        list.addFirst(10);
        list.addLast(30);
        list.add(1, 20);

        int expected = 10;
        for (int i = 1; i <= 3; i++) {
            assertEquals(list.indexOf(expected * i), i - 1);
        }
    }

    @Test
    void size() {
        ArrayList<Integer> list = new ArrayList<>();

        list.addFirst(10);
        list.addLast(30);
        list.add(1, 20);

        assertEquals(list.size(), 3);
    }

    @Test
    void remove() {
        ArrayList<Integer> list = new ArrayList<>();

        list.addFirst(10);
        list.addLast(30);
        list.remove(1);

        assertNull(list.get(1));
        assertEquals(list.size(), 1);
    }

    @Test
    void removeFirst() {
        ArrayList<Integer> list = new ArrayList<>();

        list.addFirst(10);
        list.addLast(30);
        list.removeFirst();

        assertEquals(list.size(), 1);
        assertEquals(list.get(0), 30);
    }

    @Test
    void removeLast() {
        ArrayList<Integer> list = new ArrayList<>();

        list.addFirst(10);
        list.addLast(30);
        list.removeLast();

        assertEquals(list.size(), 1);
        assertNull(list.get(1));
    }

    @Test
    void listIterator() {
        ArrayList<Integer> list = new ArrayList<>();

        list.addFirst(10);
        list.add(1, 20);
        list.addLast(30);

        ArrayList.ListIterator iterator = list.listIterator();

        int expected = 10;
        while (iterator.hasNext()) {
            assertEquals(iterator.next(), expected);
            expected += 10;
        }
    }
}