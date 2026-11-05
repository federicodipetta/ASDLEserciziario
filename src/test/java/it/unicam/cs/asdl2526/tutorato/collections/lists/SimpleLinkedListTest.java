package it.unicam.cs.asdl2526.tutorato.collections.lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleLinkedListTest {

    @Test
    public void newListIsEmpty() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertEquals(-1, list.indexOf(10));
        assertNull(list.search(10));
    }

    @Test
    public void addSingleElement() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        assertTrue(list.add(42));

        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(42), list.get(0));
        assertEquals(0, list.indexOf(42));
        assertEquals(Integer.valueOf(42), list.search(42));
    }

    @Test
    public void addMultipleElementsPreservesInsertionOrder() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();

        assertTrue(list.add("first"));
        assertTrue(list.add("second"));
        assertTrue(list.add("third"));

        assertContents(list, "first", "second", "third");
    }

    @Test
    public void addAcceptsNullElements() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        assertTrue(list.add(null));
        assertTrue(list.add(1));
        assertTrue(list.add(null));

        assertEquals(3, list.size());
        assertFalse(list.isEmpty());
        assertNull(list.get(0));
        assertEquals(Integer.valueOf(1), list.get(1));
        assertNull(list.get(2));
        assertEquals(0, list.indexOf(null));
    }

    @Test
    public void addAcceptsDuplicateElements() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        assertTrue(list.add(7));
        assertTrue(list.add(7));
        assertTrue(list.add(7));

        assertEquals(3, list.size());
        assertContents(list, 7, 7, 7);
        assertEquals(0, list.indexOf(7));
    }

    @Test
    public void searchReturnsElementWhenPresent() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("alpha");
        list.add("beta");
        list.add("gamma");

        assertEquals("alpha", list.search("alpha"));
        assertEquals("beta", list.search("beta"));
        assertEquals("gamma", list.search("gamma"));
    }

    @Test
    public void searchReturnsNullWhenElementIsNotPresent() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertNull(list.search(99));
        assertEquals(3, list.size());
        assertContents(list, 1, 2, 3);
    }

    @Test
    public void searchUsesEqualityInsteadOfReferenceIdentity() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add(new String("value"));

        String equivalentValue = new String("value");

        assertNotSame(list.get(0), equivalentValue);
        assertEquals("value", list.search(equivalentValue));
        assertEquals(0, list.indexOf(equivalentValue));
    }

    @Test
    public void searchAndIndexOfHandleNull() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("before");
        list.add(null);
        list.add("after");

        assertNull(list.search(null));
        assertEquals(1, list.indexOf(null));
    }

    @Test
    public void indexOfReturnsFirstOccurrence() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(10);
        list.add(30);
        list.add(10);

        assertEquals(0, list.indexOf(10));
        assertEquals(1, list.indexOf(20));
        assertEquals(3, list.indexOf(30));
        assertEquals(-1, list.indexOf(40));
    }

    @Test
    public void removeElementFromHead() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.remove(1));

        assertContents(list, 2, 3);
        assertEquals(2, list.size());
    }

    @Test
    public void removeElementFromMiddle() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.remove(2));

        assertContents(list, 1, 3);
        assertEquals(2, list.size());
    }

    @Test
    public void removeElementFromTail() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.remove(3));

        assertContents(list, 1, 2);
        assertEquals(2, list.size());
    }

    @Test
    public void removeOnlyElementLeavesListEmpty() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("only");

        assertTrue(list.remove("only"));

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertEquals(-1, list.indexOf("only"));
        assertNull(list.search("only"));
    }

    @Test
    public void removeReturnsFalseWhenElementIsNotPresent() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);

        assertFalse(list.remove(99));

        assertContents(list, 1, 2);
        assertEquals(2, list.size());
    }

    @Test
    public void removeRemovesOnlyFirstDuplicate() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(1);

        assertTrue(list.remove(1));

        assertContents(list, 2, 1, 3, 1);
        assertEquals(4, list.size());
        assertEquals(1, list.indexOf(1));
    }

    @Test
    public void removeNullRemovesOnlyFirstNull() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(null);
        list.add(1);
        list.add(null);

        assertTrue(list.remove(null));

        assertContents(list, 1, null);
        assertEquals(2, list.size());
        assertEquals(1, list.indexOf(null));
    }

    @Test
    public void removeFromEmptyListReturnsFalse() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        assertFalse(list.remove(10));
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void getReturnsElementsAtEveryValidIndex() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");

        assertEquals("zero", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two", list.get(2));
        assertEquals("three", list.get(3));
    }

    @Test
    public void getRejectsNegativeIndex() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    public void getRejectsIndexEqualToSize() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }

    @Test
    public void getRejectsIndexGreaterThanSize() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
    }

    @Test
    public void getRejectsAnyIndexOnEmptyList() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    public void clearRemovesAllElements() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertEquals(-1, list.indexOf(1));
        assertNull(list.search(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void clearOnEmptyListDoesNothing() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        assertDoesNotThrow(list::clear);

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void listCanBeReusedAfterClear() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);

        list.clear();

        assertTrue(list.add(3));
        assertTrue(list.add(4));

        assertContents(list, 3, 4);
        assertEquals(2, list.size());
    }

    @Test
    public void reverseEmptyListDoesNothing() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        assertDoesNotThrow(list::reverse);

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void reverseSingleElementDoesNothing() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("only");

        list.reverse();

        assertContents(list, "only");
        assertEquals(1, list.size());
    }

    @Test
    public void reverseTwoElements() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);

        list.reverse();

        assertContents(list, 2, 1);
    }

    @Test
    public void reverseMultipleElements() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.reverse();

        assertContents(list, 5, 4, 3, 2, 1);
    }

    @Test
    public void reverseCanBeAppliedTwice() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        list.reverse();
        list.reverse();

        assertContents(list, "a", "b", "c");
    }

    @Test
    public void reversePreservesSizeAndDuplicates() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(null);
        list.add(1);
        list.add(2);
        list.add(null);

        list.reverse();

        assertContents(list, null, 2, 1, null, 1);
        assertEquals(5, list.size());
        assertEquals(0, list.indexOf(null));
        assertEquals(2, list.indexOf(1));
    }

    @Test
    public void operationsRemainConsistentAfterSeveralMutations() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(20);
        list.add(40);
        list.reverse();
        list.remove(10);

        assertContents(list, 40, 30);
        assertEquals(2, list.size());
        assertFalse(list.isEmpty());
        assertEquals(0, list.indexOf(40));
        assertEquals(1, list.indexOf(30));
        assertEquals(-1, list.indexOf(10));
    }

    private static <T> void assertContents(
            SimpleLinkedList<T> list,
            @SuppressWarnings("unchecked") T... expected) {

        assertEquals(expected.length, list.size());
        assertEquals(expected.length == 0, list.isEmpty());

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i),
                    "Elemento inatteso all'indice " + i);
        }
    }
}