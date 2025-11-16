package it.unicam.cs.asdl2526.tutorato.collections.sets.hash;

import it.unicam.cs.asdl2526.tutorato.collections.sets.SetTest;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class HashSetLinearProbingTest extends SetTest {

    @Override
    public <E extends Comparable<E>> Set<E> createSet() {
        return new HashSetLinearProbing<>();
    }

    /**
     * Classe con una funzione di hash pessima che causa molte collisioni
     */
    static class BadHash {
        final int value;

        BadHash(int v) { value = v; }

        @Override
        public int hashCode() { return 1; }
        @Override
        public boolean equals(Object o) {
            return o instanceof BadHash && ((BadHash)o).value == value;
        }
    }

    /**
     * Classe con una funzione di hash terribile che causa molte collisioni
     * e richiede un buon funzionamento del probing lineare
     */
    static class TerribleHash {
        final int value;

        TerribleHash(int v) { value = v; }

        @Override
        public int hashCode() { return value % 3; }

        @Override
        public boolean equals(Object o) {
            return o instanceof TerribleHash && ((TerribleHash)o).value == value;
        }
    }

    @Test
    public void testAddAndContainsBasic() {
        Set<Integer> set = new HashSetLinearProbing<>(8);

        assertTrue(set.add(10));
        assertTrue(set.add(20));
        assertTrue(set.add(30));

        assertTrue(set.contains(10));
        assertTrue(set.contains(20));
        assertFalse(set.contains(99));
    }

    @Test
    public void testNoDuplicates() {
        Set<Integer> set = new HashSetLinearProbing<>(8);

        assertTrue(set.add(5));
        assertFalse(set.add(5));
        assertEquals(1, set.size());
    }

    @Test
    public void testCollisionWithBadHash() {
        Set<BadHash> set = new HashSetLinearProbing<>(4);

        assertTrue(set.add(new BadHash(1)));
        assertTrue(set.add(new BadHash(2)));
        assertTrue(set.add(new BadHash(3)));

        assertTrue(set.contains(new BadHash(1)));
        assertTrue(set.contains(new BadHash(2)));
        assertTrue(set.contains(new BadHash(3)));
    }

    @Test
    public void testRemoveAndContainsAfter() {
        Set<Integer> set = new HashSetLinearProbing<>(8);

        set.add(1);
        set.add(2);
        set.add(3);

        assertTrue(set.remove(2));
        assertFalse(set.contains(2));
        assertEquals(2, set.size());
    }

    @Test
    public void testReuseDeletedSlot() {
        Set<BadHash> set = new HashSetLinearProbing<>(5);

        BadHash a = new BadHash(1);
        BadHash b = new BadHash(2);
        BadHash c = new BadHash(3);

        set.add(a);
        set.add(b);
        set.add(c);

        assertTrue(set.remove(b));

        assertTrue(set.add(new BadHash(99)));
    }

    @Test
    public void testLinearProbingMovement() {
        Set<TerribleHash> set = new HashSetLinearProbing<>(5);

        assertTrue(set.add(new TerribleHash(0)));
        assertTrue(set.add(new TerribleHash(3)));
        assertTrue(set.add(new TerribleHash(6)));
        assertEquals(3, set.size());

        assertTrue(set.contains(new TerribleHash(6)));
    }

    @Test
    public void testResize() {
        HashSetLinearProbing<Integer> set = new HashSetLinearProbing<>(4);

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        assertEquals(4, set.size());
        assertTrue(set.contains(1));
        assertTrue(set.contains(4));
        assertTrue(set.contains(3));
    }

    @Test
    public void testContainsAfterResize() {
        HashSetLinearProbing<Integer> set = new HashSetLinearProbing<>(2);

        for (int i = 0; i < 20; i++) {
            set.add(i);
        }

        assertEquals(20, set.size());

        for (int i = 0; i < 20; i++) {
            assertTrue(set.contains(i));
        }
    }

    @Test
    public void testRemoveThenReAddAfterResize() {
        HashSetLinearProbing<Integer> set = new HashSetLinearProbing<>(3);

        set.add(1);
        set.add(2);
        set.add(3);
        set.remove(2);

        assertTrue(set.add(99));

        set.add(100);
        set.add(101);

        assertTrue(set.contains(1));
        assertTrue(set.contains(99));
        assertTrue(set.contains(101));
    }

    @Test
    public void testSize() {
        Set<TerribleHash> set = new HashSetLinearProbing<>();
        assertEquals(0, set.size());

        set.add(new TerribleHash(1));
        assertEquals(1, set.size());
        set.add(new TerribleHash(2));
        assertEquals(2, set.size());
        set.remove(new TerribleHash(1));
        assertEquals(1, set.size());
        set.remove(new TerribleHash(2));
        assertEquals(0, set.size());
    }

    @Test
    public void tesIterator() {
        Set<Integer> set = new HashSetLinearProbing<>();
        assertSame(HashSetLinearProbing.HashSetIterator.class, set.iterator().getClass());

        set.add(1);
        set.add(2);

        Iterator<Integer> iterator = set.iterator();
        assertTrue(iterator.hasNext());
        Integer first = iterator.next();
        assertTrue(first == 1 || first == 2);
        set.add(3);
        assertFalse(iterator.hasNext());
        assertThrows(IllegalStateException.class, iterator::next);
    }
}
