package it.unicam.cs.asdl2526.tutorato.collections.lists;

import it.unicam.cs.asdl2526.tutorato.collections.CollectionTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

public class DequeueTest extends CollectionTest {

    @Override
    public <E> Deque<E> createCollection() {
        return new Dequeue<>();
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
    public void testPop() {
        Deque<Integer> dequeue = createCollection();
        dequeue.addLast(1);
        dequeue.addLast(2);
        dequeue.push(3);
        dequeue.push(4);
        assertEquals((Integer) 4, dequeue.pop());
        assertEquals((Integer) 3, dequeue.pop());
        assertEquals((Integer) 1, dequeue.pop());
        assertEquals((Integer) 2, dequeue.pop());
        assertTrue(dequeue.isEmpty());
    }

    @Test
    public void testPopEmpty() {
        Deque<Integer> dequeue = createCollection();
        assertThrows(java.util.NoSuchElementException.class, dequeue::pop);
    }

    @Test
    public void testPopEmpty2() {
        Deque<Integer> dequeue = createCollection();
        dequeue.push(1);
        dequeue.pop();
        assertThrows(java.util.NoSuchElementException.class, dequeue::pop);
    }

    @Test
    public void testPeek() {
        Deque<Integer> dequeue = createCollection();
        dequeue.addLast(1);
        dequeue.addLast(2);
        dequeue.push(3);
        dequeue.push(4);
        assertEquals((Integer) 4, dequeue.peek());
        assertEquals((Integer) 4, dequeue.peek());
        dequeue.pop();
        assertEquals((Integer) 3, dequeue.peek());
        dequeue.pop();
        assertEquals((Integer) 1, dequeue.peek());
    }

    @Test
    public void testPeekEmpty() {
        Deque<Integer> dequeue = createCollection();
        assertNull(dequeue.peek());
    }

    @Test
    public void testPeekEmpty2() {
        Deque<Integer> dequeue = createCollection();
        dequeue.push(1);
        dequeue.pop();
        assertNull(dequeue.peek());
    }

    @Test
    public void testElement() {
        Deque<Integer> dequeue = createCollection();
        dequeue.addLast(1);
        dequeue.addLast(2);
        dequeue.push(3);
        dequeue.push(4);
        assertEquals((Integer) 4, dequeue.element());
        assertEquals((Integer) 4, dequeue.element());
        dequeue.pop();
        assertEquals((Integer) 3, dequeue.element());
        dequeue.pop();
        assertEquals((Integer) 1, dequeue.element());
    }

    @Test
    public void testElementEmpty() {
        Deque<Integer> dequeue = createCollection();
        assertThrows(java.util.NoSuchElementException.class, dequeue::element);
    }

    @Test
    public void testElementEmpty2() {
        Deque<Integer> dequeue = createCollection();
        dequeue.push(1);
        dequeue.pop();
        assertThrows(java.util.NoSuchElementException.class, dequeue::element);
    }

    @Test
    public void testPushNull() {
        Deque<Integer> dequeue = createCollection();
        if (acceptNullElements()) {
            dequeue.push(null);
            assertNull(dequeue.peek());
            assertNull(dequeue.pop());
        } else {
            assertThrows(NullPointerException.class, () -> dequeue.push(null));
        }
    }

    @Test
    public void testAddFirstAndAddLast() {
        Deque<Integer> dequeue = createCollection();
        dequeue.addFirst(1);
        dequeue.addLast(2);
        dequeue.addFirst(0);
        assertEquals((Integer) 0, dequeue.peekFirst());
        assertEquals((Integer) 2, dequeue.peekLast());
    }

    @Test
    public void testRemoveFirstAndRemoveLast() {
        Deque<Integer> dequeue = createCollection();
        dequeue.addLast(1);
        dequeue.addLast(2);
        dequeue.addLast(3);
        assertEquals((Integer) 1, dequeue.removeFirst());
        assertEquals((Integer) 3, dequeue.removeLast());
        assertEquals((Integer) 2, dequeue.removeFirst());
        assertTrue(dequeue.isEmpty());
    }

    @Test
    public void testOfferFirstAndOfferLast() {
        Deque<Integer> dequeue = createCollection();
        assertTrue(dequeue.offerFirst(1));
        assertTrue(dequeue.offerLast(2));
        assertEquals((Integer) 1, dequeue.peekFirst());
        assertEquals((Integer) 2, dequeue.peekLast());
    }

    @Test
    public void testPollFirstAndPollLast() {
        Deque<Integer> dequeue = createCollection();
        dequeue.addLast(1);
        dequeue.addLast(2);
        dequeue.addLast(3);
        assertEquals((Integer) 1, dequeue.pollFirst());
        assertEquals((Integer) 3, dequeue.pollLast());
        assertEquals((Integer) 2, dequeue.pollFirst());
        assertNull(dequeue.pollFirst());
    }

    @Test
    public void testSizeAndIsEmpty() {
        Deque<Integer> dequeue = createCollection();
        assertTrue(dequeue.isEmpty());
        assertEquals(0, dequeue.size());
        dequeue.add(1);
        assertFalse(dequeue.isEmpty());
        assertEquals(1, dequeue.size());
        dequeue.add(2);
        assertEquals(2, dequeue.size());
        dequeue.clear();
        assertTrue(dequeue.isEmpty());
        assertEquals(0, dequeue.size());
    }

    @Test
    public void testClear() {
        Deque<Integer> dequeue = createCollection();
        dequeue.add(1);
        dequeue.add(2);
        dequeue.add(3);
        assertFalse(dequeue.isEmpty());
        dequeue.clear();
        assertTrue(dequeue.isEmpty());
        assertEquals(0, dequeue.size());
        assertNull(dequeue.poll());
    }

    @Test
    public void testNullPointerException() {
        Deque<Integer> dequeue = createCollection();
        if (!acceptNullElements()) {
            assertThrows(NullPointerException.class, () -> dequeue.add(null));
            assertThrows(NullPointerException.class, () -> dequeue.offer(null));
        }
    }

}
