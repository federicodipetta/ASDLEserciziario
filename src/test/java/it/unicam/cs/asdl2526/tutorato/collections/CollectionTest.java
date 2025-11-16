package it.unicam.cs.asdl2526.tutorato.collections;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public abstract class CollectionTest {

    abstract public <E> Collection<E> createCollection();

    abstract public boolean acceptDuplicateElements();

    abstract public boolean acceptNullElements();

    @Test
    public void testAddAndContains() {
        Collection<Integer> collection = createCollection();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        assertEquals(3, collection.size());
    }

    @Test
    public void testRemove() {
        Collection<Integer> collection = createCollection();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.remove(2);
        assertEquals(2, collection.size());
    }

    @Test
    public void testRemove2() {
        Collection<Integer> collection = createCollection();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        assertTrue(collection.contains(4));
        collection.remove(4);
        assertFalse(collection.contains(4));
    }

    @Test
    public void testAddDuplicateElements() {
        Collection<Integer> collection = createCollection();
        collection.add(1);
        collection.add(2);
        collection.add(2);
        if (acceptDuplicateElements()) {
            assertEquals(3, collection.size());
        } else {
            assertEquals(2, collection.size());
        }
    }

    @Test
    public void testContains() {
        Collection<Integer> collection = createCollection();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        assertTrue(collection.contains(2));
        assertFalse(collection.contains(4));
    }

    @Test
    public void testRemoveNotFound() {
        Collection<Integer> collection = createCollection();
        collection.add(1);
        assertFalse(collection.remove(2));
        assertEquals(1, collection.size());
    }

    @Test
    public void addNullElement() {
        Collection<Integer> collection = createCollection();
        if (acceptNullElements())    {
            assertTrue(collection.add(null));
            assertTrue(collection.contains(null));
        } else {
            assertThrows(NullPointerException.class, () -> collection.add(null));
        }
    }

    @Test
    public void iterator() {
        Collection<Integer> collection = createCollection();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        Iterator<Integer> it = collection.iterator();
        int i = 1;
        while (it.hasNext()) {
            assertEquals((Integer) i, it.next());
            i++;
        }
    }


}
