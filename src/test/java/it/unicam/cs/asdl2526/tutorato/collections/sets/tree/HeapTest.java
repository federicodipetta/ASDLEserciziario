package it.unicam.cs.asdl2526.tutorato.collections.sets.tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {

    @Test
    void newHeapIsEmpty() {
        Heap heap = new Heap();
        assertTrue(heap.isEmpty());
    }

    @Test
    void heapWithCustomSizeIsEmpty() {
        Heap heap = new Heap(32);
        assertTrue(heap.isEmpty());
    }

    @Test
    void addSingleElementMakesHeapNotEmpty() {
        Heap heap = new Heap();
        assertTrue(heap.add(10));
        assertFalse(heap.isEmpty());
    }

    @Test
    void addMultipleElementsInOrder() {
        Heap heap = new Heap();
        assertTrue(heap.add(5));
        assertTrue(heap.add(10));
        assertTrue(heap.add(15));
        assertFalse(heap.isEmpty());
    }

    @Test
    void addMultipleElementsReverseOrder() {
        Heap heap = new Heap();
        assertTrue(heap.add(15));
        assertTrue(heap.add(10));
        assertTrue(heap.add(5));
        assertEquals(5, heap.getMin());
    }

    @Test
    void addDuplicateElementReturnsFalse() {
        Heap heap = new Heap();
        assertTrue(heap.add(10));
        assertFalse(heap.add(10));
    }

    @Test
    void addManyElementsExceedsInitialCapacity() {
        Heap heap = new Heap();
        for (int i = 0; i < 20; i++) {
            assertTrue(heap.add(i));
        }
        assertEquals(0, heap.getMin());
    }

    @Test
    void getMinReturnsSmallestElement() {
        Heap heap = new Heap();
        heap.add(20);
        heap.add(10);
        heap.add(30);
        assertEquals(10, heap.getMin());
    }

    @Test
    void getMinDoesNotRemoveElement() {
        Heap heap = new Heap();
        heap.add(5);
        assertEquals(5, heap.getMin());
        assertEquals(5, heap.getMin());
        assertFalse(heap.isEmpty());
    }

    @Test
    void getMinOnEmptyHeapThrowsException() {
        Heap heap = new Heap();
        assertThrows(Exception.class, () -> heap.getMin());
    }

    @Test
    void removeMinReturnsAndRemovesSmallestElement() {
        Heap heap = new Heap();
        heap.add(10);
        heap.add(5);
        heap.add(15);
        assertEquals(5, heap.removeMin());
        assertEquals(10, heap.getMin());
    }

    @Test
    void removeMinUntilEmpty() {
        Heap heap = new Heap();
        heap.add(30);
        heap.add(10);
        heap.add(20);
        assertEquals(10, heap.removeMin());
        assertEquals(20, heap.removeMin());
        assertEquals(30, heap.removeMin());
        assertTrue(heap.isEmpty());
    }

    @Test
    void removeMinOnEmptyHeapThrowsException() {
        Heap heap = new Heap();
        assertThrows(Exception.class, () -> heap.removeMin());
    }

    @Test
    void removeMinMaintainsHeapProperty() {
        Heap heap = new Heap();
        heap.add(5);
        heap.add(10);
        heap.add(3);
        heap.add(20);
        heap.add(15);
        
        assertEquals(3, heap.removeMin());
        assertEquals(5, heap.getMin());
    }

    // Test di remove
    @Test
    void removeExistingElementReturnsTrue() {
        Heap heap = new Heap();
        heap.add(10);
        heap.add(20);
        heap.add(30);
        assertTrue(heap.remove(20));
    }

    @Test
    void removeNonExistingElementReturnsFalse() {
        Heap heap = new Heap();
        heap.add(10);
        heap.add(20);
        assertFalse(heap.remove(30));
    }

    @Test
    void removeFromEmptyHeapReturnsFalse() {
        Heap heap = new Heap();
        assertFalse(heap.remove(10));
    }

    @Test
    void removeRootElement() {
        Heap heap = new Heap();
        heap.add(5);
        heap.add(10);
        heap.add(15);
        assertTrue(heap.remove(5));
        assertEquals(10, heap.getMin());
    }

    @Test
    void removeLeafElement() {
        Heap heap = new Heap();
        heap.add(5);
        heap.add(10);
        heap.add(15);
        heap.add(20);
        assertTrue(heap.remove(20));
        assertEquals(5, heap.getMin());
    }

    @Test
    void removeMiddleElement() {
        Heap heap = new Heap();
        heap.add(5);
        heap.add(10);
        heap.add(15);
        heap.add(20);
        assertTrue(heap.remove(10));
        assertEquals(5, heap.getMin());
    }

    @Test
    void removeLastRemainingElement() {
        Heap heap = new Heap();
        heap.add(42);
        assertTrue(heap.remove(42));
        assertTrue(heap.isEmpty());
    }

    @Test
    void heapifyUpMaintainsMinHeapProperty() {
        Heap heap = new Heap();
        heap.add(50);
        heap.add(30);
        heap.add(20);
        heap.add(10);
        assertEquals(10, heap.getMin());
    }

    @Test
    void mixedOperationsMaintainHeapProperty() {
        Heap heap = new Heap();
        heap.add(15);
        heap.add(10);
        heap.add(20);
        heap.removeMin();
        heap.add(5);
        heap.remove(20);
        heap.add(25);
        assertEquals(5, heap.getMin());
    }

    @Test
    void addAndRemoveInSequence() {
        Heap heap = new Heap();
        for (int i = 10; i >= 1; i--) {
            heap.add(i);
        }
        for (int i = 1; i <= 10; i++) {
            assertEquals(i, heap.removeMin());
        }
        assertTrue(heap.isEmpty());
    }

    @Test
    void stressTestWithManyElements() {
        Heap heap = new Heap();
        for (int i = 100; i > 0; i--) {
            assertTrue(heap.add(i));
        }
        assertEquals(1, heap.getMin());
        
        for (int i = 1; i <= 100; i++) {
            assertEquals(i, heap.removeMin());
        }
        assertTrue(heap.isEmpty());
    }
}