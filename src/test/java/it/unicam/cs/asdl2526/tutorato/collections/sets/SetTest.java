package it.unicam.cs.asdl2526.tutorato.collections.sets;

import it.unicam.cs.asdl2526.tutorato.collections.CollectionTest;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class SetTest extends CollectionTest {

    @Override
    public <E> Collection<E> createCollection() {
        return (Collection<E>) createSet();
    }
    @Override
    public boolean acceptDuplicateElements() {
        return false;
    }

    @Override
    public boolean acceptNullElements() {
        return false;
    }

    abstract public <E extends Comparable<E>> Set<E> createSet();

    @Test
    public void testClear() {
        Set<Integer> set = createSet();
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(3, set.size());
        set.clear();
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }

    @Test
    public void testAddAll() {
        Set<Integer> set = createSet();
        Collection<Integer> toAdd = createCollection();
        toAdd.add(1);
        toAdd.add(2);
        toAdd.add(3);
        set.addAll(toAdd);
        assertEquals(3, set.size());
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        assertTrue(set.contains(3));
    }

    @Test
    public void testRemoveAll() {
        Set<Integer> set = createSet();
        set.add(1);
        set.add(2);
        set.add(3);
        Collection<Integer> toRemove = createCollection();
        toRemove.add(2);
        toRemove.add(3);
        set.removeAll(toRemove);
        assertEquals(1, set.size());
        assertTrue(set.contains(1));
    }

    @Test
    public void testIterator() {
        Set<Integer> set = createSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3); // Duplicato, non deve essere aggiunto
        int sum = 0;
        for (Integer i : set) {
            sum += i;
        }
        assertEquals(6, sum);
    }

    @Test
    public void testEquals() {
        Set<Integer> set1 = createSet();
        Set<Integer> set2 = createSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(3);
        set2.add(2);
        set2.add(1);
        assertEquals(set1, set2);
    }

}
