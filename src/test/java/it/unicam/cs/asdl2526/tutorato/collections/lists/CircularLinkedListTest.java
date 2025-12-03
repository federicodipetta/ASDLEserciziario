package it.unicam.cs.asdl2526.tutorato.collections.lists;

import it.unicam.cs.asdl2526.tutorato.collections.CollectionTest;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
public class CircularLinkedListTest extends CollectionTest {

    @Override
    public <E> Collection<E> createCollection() {
        return new CircularLinkedList<>();
    }

    @Override
    public boolean acceptDuplicateElements() {
        return true;
    }

    @Override
    public boolean acceptNullElements() {
        return true;
    }

    @Test
    public void circularIterator() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> it = list.iterator();
        assertTrue(it.hasNext());
        for (int i : IntStream.range(0, 10).toArray()) {
            assertTrue(it.hasNext());
        }
    }

    @Test
    public void circularIteratorEmpty() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        Iterator<Integer> it = list.iterator();
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

}
