package it.unicam.cs.asdl2526.tutorato.collections.lists;

import it.unicam.cs.asdl2526.tutorato.collections.CollectionTest;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
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

    /**
     * Sostituisce CollectionTest.iterator(): su un iteratore circolare
     * hasNext() è sempre true, quindi non si può ciclare fino a esaurimento.
     */
    @Override
    @Test
    public void iterator() {
        Collection<Integer> collection = createCollection();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        Iterator<Integer> it = collection.iterator();
        for (int expected : new int[] { 1, 2, 3, 1, 2, 3 }) {
            assertTrue(it.hasNext());
            assertEquals((Integer) expected, it.next());
        }
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

    // ---------- iteratore ----------

    @Test
    public void iteratorWrapsAroundInInsertionOrder() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> it = list.iterator();
        Integer[] expected = { 1, 2, 3, 1, 2, 3, 1 };
        for (Integer e : expected) {
            assertTrue(it.hasNext());
            assertEquals(e, it.next());
        }
    }

    @Test
    public void iteratorOnSingleElementRepeatsIt() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.add("only");

        Iterator<String> it = list.iterator();
        for (int i = 0; i < 5; i++) {
            assertTrue(it.hasNext());
            assertEquals("only", it.next());
        }
    }

    @Test
    public void iteratorsAreIndependent() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> it1 = list.iterator();
        Iterator<Integer> it2 = list.iterator();

        assertEquals(Integer.valueOf(1), it1.next());
        assertEquals(Integer.valueOf(2), it1.next());
        assertEquals(Integer.valueOf(1), it2.next());
        assertEquals(Integer.valueOf(3), it1.next());
        assertEquals(Integer.valueOf(2), it2.next());
    }

    @Test
    public void iteratorReturnsNullElements() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(null);
        list.add(1);

        Iterator<Integer> it = list.iterator();
        assertNull(it.next());
        assertEquals(Integer.valueOf(1), it.next());
        assertNull(it.next());
    }

    @Test
    public void iteratorFailsFastWhenListIsModified() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> it = list.iterator();

        list.add(3);

        assertThrows(ConcurrentModificationException.class, it::next);
    }

    // ---------- add ----------

    @Test
    public void addKeepsInsertionOrderAndRingIsClosed() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        for (int i = 1; i <= 5; i++)
            assertTrue(list.add(i));

        assertRing(list, 1, 2, 3, 4, 5);
    }

    @Test
    public void addAcceptsNullAndDuplicates() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(null);
        list.add(7);
        list.add(7);
        list.add(null);

        assertRing(list, null, 7, 7, null);
    }

    @Test
    public void addIsConstantTime() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
            for (int i = 0; i < 200_000; i++)
                list.add(i);
        });
        assertEquals(200_000, list.size());
    }

    // ---------- remove ----------

    @Test
    public void removeHead() {
        CircularLinkedList<Integer> list = listOf(1, 2, 3);

        assertTrue(list.remove(Integer.valueOf(1)));

        assertRing(list, 2, 3);
    }

    @Test
    public void removeMiddle() {
        CircularLinkedList<Integer> list = listOf(1, 2, 3);

        assertTrue(list.remove(Integer.valueOf(2)));

        assertRing(list, 1, 3);
    }

    @Test
    public void removeTailThenAddKeepsOrder() {
        CircularLinkedList<Integer> list = listOf(1, 2, 3);

        assertTrue(list.remove(Integer.valueOf(3)));
        assertRing(list, 1, 2);

        list.add(4); // controlla che current sia stato aggiornato
        assertRing(list, 1, 2, 4);
    }

    @Test
    public void removeHeadThenAddKeepsOrder() {
        CircularLinkedList<Integer> list = listOf(1, 2, 3);

        assertTrue(list.remove(Integer.valueOf(1)));
        list.add(4);

        assertRing(list, 2, 3, 4);
    }

    @Test
    public void removeOnlyElementLeavesListEmptyAndReusable() {
        CircularLinkedList<Integer> list = listOf(1);

        assertTrue(list.remove(Integer.valueOf(1)));

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertFalse(list.iterator().hasNext());
        assertFalse(list.contains(1));

        list.add(2);
        assertRing(list, 2);
    }

    @Test
    public void removeAllElementsOneByOne() {
        CircularLinkedList<Integer> list = listOf(1, 2, 3, 4);

        assertTrue(list.remove(Integer.valueOf(2)));
        assertTrue(list.remove(Integer.valueOf(4)));
        assertTrue(list.remove(Integer.valueOf(1)));
        assertRing(list, 3);
        assertTrue(list.remove(Integer.valueOf(3)));

        assertTrue(list.isEmpty());
    }

    @Test
    public void removeRemovesOnlyFirstDuplicate() {
        CircularLinkedList<Integer> list = listOf(1, 2, 1, 3, 1);

        assertTrue(list.remove(Integer.valueOf(1)));

        assertRing(list, 2, 1, 3, 1);
    }

    @Test
    public void removeNullRemovesOnlyFirstNull() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(null);
        list.add(1);
        list.add(null);

        assertTrue(list.remove(null));

        assertRing(list, 1, null);
    }

    @Test
    public void removeReturnsFalseWhenNotPresentOrEmpty() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        assertFalse(list.remove(Integer.valueOf(1)));

        list.add(1);
        list.add(2);
        assertFalse(list.remove(Integer.valueOf(99)));
        assertRing(list, 1, 2);
    }

    @Test
    public void removeUsesEqualsInsteadOfIdentity() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.add(new String("a"));
        list.add(new String("b"));

        assertTrue(list.remove(new String("a")));

        assertRing(list, "b");
    }

    /**
     * Trabocchetto di List: su un riferimento List/CircularLinkedList di Integer,
     * remove(int) viene scelto al posto di remove(Object). Sulla lista circolare
     * le operazioni per indice non sono supportate, quindi lancia eccezione.
     */
    @Test
    public void removeWithIntLiteralSelectsIndexOverload() {
        CircularLinkedList<Integer> list = listOf(1, 2, 3);

        assertThrows(UnsupportedOperationException.class, () -> list.remove(2));
        assertTrue(list.remove(Integer.valueOf(2)));
    }

    // ---------- contains ----------

    @Test
    public void containsOnEmptyList() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        assertFalse(list.contains(1));
        assertFalse(list.contains(null));
    }

    @Test
    public void containsFindsHeadMiddleAndTail() {
        CircularLinkedList<Integer> list = listOf(1, 2, 3);

        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
        assertFalse(list.contains(4));
    }

    @Test
    public void containsHandlesNullAndEquality() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.add(new String("x"));
        assertFalse(list.contains(null));

        list.add(null);
        assertTrue(list.contains(null));
        assertTrue(list.contains(new String("x")));
    }

    @Test
    public void containsTerminatesWhenElementIsMissing() {
        CircularLinkedList<Integer> list = listOf(1, 2, 3);

        // se la ricerca non si ferma dopo un giro, il timeout scatta
        assertTimeoutPreemptively(Duration.ofSeconds(2),
                () -> assertFalse(list.contains(99)));
    }

    // ---------- size / isEmpty / clear ----------

    @Test
    public void sizeAndIsEmptyTrackOperations() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.add(1);
        list.add(2);
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());

        list.remove(Integer.valueOf(1));
        assertEquals(1, list.size());

        list.remove(Integer.valueOf(99)); // fallita: la size non cambia
        assertEquals(1, list.size());
    }

    @Test
    public void clearEmptiesListAndAllowsReuse() {
        CircularLinkedList<Integer> list = listOf(1, 2, 3);

        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertFalse(list.contains(1));
        assertFalse(list.iterator().hasNext());

        list.add(4);
        list.add(5);
        assertRing(list, 4, 5);
    }

    @Test
    public void clearOnEmptyListDoesNothing() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        assertDoesNotThrow(list::clear);

        assertTrue(list.isEmpty());
    }

    // ---------- get ----------

    @Test
    public void getReturnsElementsInListOrder() {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.add("zero");
        list.add("one");
        list.add("two");

        assertEquals("zero", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two", list.get(2));
    }

    @Test
    public void getAfterRemovingHeadStartsFromNewHead() {
        CircularLinkedList<Integer> list = listOf(1, 2, 3);
        list.remove(Integer.valueOf(1));

        assertEquals(Integer.valueOf(2), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
    }

    @Test
    public void getRejectsInvalidIndexes() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));

        list.add(1);
        list.add(2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
    }

    // ---------- operazioni non supportate ----------

    @Test
    public void unsupportedOperationsThrow() {
        CircularLinkedList<Integer> list = listOf(1, 2, 3);

        assertThrows(UnsupportedOperationException.class, list::toArray);
        assertThrows(UnsupportedOperationException.class, () -> list.indexOf(1));
        assertThrows(UnsupportedOperationException.class, () -> list.set(0, 5));
        assertThrows(UnsupportedOperationException.class, () -> list.add(0, 5));
        assertThrows(UnsupportedOperationException.class, list::listIterator);
        assertThrows(UnsupportedOperationException.class, () -> list.subList(0, 1));
    }

    // ---------- helper ----------

    @SafeVarargs
    private static <T> CircularLinkedList<T> listOf(T... elements) {
        CircularLinkedList<T> list = new CircularLinkedList<>();
        for (T e : elements)
            list.add(e);
        return list;
    }

    /**
     * Verifica size e contenuto, e percorre il cerchio per DUE giri: il secondo
     * giro controlla che l'ultimo nodo punti davvero al primo.
     */
    @SafeVarargs
    private static <T> void assertRing(CircularLinkedList<T> list, T... expected) {
        assertEquals(expected.length, list.size());
        assertEquals(expected.length == 0, list.isEmpty());

        Iterator<T> it = list.iterator();
        if (expected.length == 0) {
            assertFalse(it.hasNext());
            return;
        }
        for (int round = 0; round < 2; round++) {
            for (int i = 0; i < expected.length; i++) {
                assertTrue(it.hasNext());
                assertEquals(expected[i], it.next(),
                        "Elemento inatteso alla posizione " + i + " del giro " + round);
            }
        }
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i), "get(" + i + ")");
        }
    }

}