package juwoncode.structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void addHead() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addHead(10);

        assertEquals(list.getSize(), 1);
    }

    @Test
    void addTail() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addTail(10);

        assertEquals(list.getSize(), 1);
    }

    @Test
    void add() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addHead(5);
        list.addTail(15);
        list.add(1, 10);

        assertEquals(list.getSize(), 3);

        for (int i = 1; i <= 3; i++) {
            assertEquals(list.getValue(i - 1), i * 5);
        }
    }

    @Test
    void getSize() {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(0, 10);
        list.add(0, 10);
        list.add(0, 10);

        assertEquals(list.getSize(), 3);
    }

    @Test
    void getValue() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addHead(5);
        list.addTail(15);
        list.add(1, 10);

        assertEquals(list.getValue(0), 5);
        assertEquals(list.getValue(1), 10);
        assertEquals(list.getValue(2), 15);
    }

    @Test
    void indexOf() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addHead(5);
        list.addTail(15);
        list.add(1, 10);

        assertEquals(list.indexOf(5), 0);
        assertEquals(list.indexOf(10), 1);
        assertEquals(list.indexOf(15), 2);
    }

    @Test
    void removeHead() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addHead(5);
        list.addTail(15);
        list.removeHead();

        assertEquals(list.getSize(), 1);
        assertEquals(list.getValue(0), 15);
    }

    @Test
    void removeTail() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addHead(5);
        list.addTail(15);
        list.removeTail();

        assertEquals(list.getSize(), 1);
        assertEquals(list.getValue(0), 5);
    }

    @Test
    void remove() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addHead(5);
        list.addTail(15);
        list.remove(1);
        list.remove(0);

        assertEquals(list.getSize(), 0);
    }

    @Test
    void listIterator() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addHead(5);
        list.addTail(15);
        list.add(1, 10);

        LinkedList.ListIterator iterator = list.listIterator();

        int expect = 5;
        while (iterator.hasNext()) {
            assertEquals(iterator.next(), expect);
            expect += 5;
        }
    }
}