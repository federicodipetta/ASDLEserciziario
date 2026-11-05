package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
public class SorterTest {
    
    // Aggiungi qui i sorter per il quale vuoi eseguire il benchmark.
    private static ArrayList<Sorter> sorters = new ArrayList<>();
    static {
        sorters.add(new BubbleSort());
        sorters.add(new MergeSort());
        sorters.add(new SelectionSort());
        sorters.add(new InsertionSort());
        sorters.add(new QuickSort(PivotSelectionMode.START));
        sorters.add(new QuickSort(PivotSelectionMode.MIDDLE));
        sorters.add(new QuickSort(PivotSelectionMode.END));
        sorters.add(new QuickSort(PivotSelectionMode.RANDOM, 42)); // Seed fisso per test riproducibili
        sorters.add(new CountingSort());
        sorters.add(new RadixSort());
        //sorters.add(new RadixSortBase10());
    }

    @Test 
    public void testAllSorters() {
        for (Sorter sorter : sorters) {
            System.out.println("Testing sorter: " + sorter.toString());
            testSorter(sorter);
        }
    }

    //Benchmarking

    @Test
    public void benchmarkSorters() {
        int[] sizes = { 10, 100, 1000, 10000 };
        final int iterations = 10; // Numero di iterazioni configurabile
        for (int size : sizes) {
            Integer[] array = new Integer[size];
            for (int i = 0; i < size; i++) {
                array[i] = (int) (Math.random() * size);
            }
            System.out.println("Benchmarking sorters with array size: " + size + " over " + iterations + " iterations.");
            for (Sorter sorter : sorters) {
                long totalDuration = 0;
                for (int i = 0; i < iterations; i++) {
                    Integer[] copy = array.clone();
                    long startTime = System.nanoTime();
                    sorter.sort(copy);
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime;
                    totalDuration += duration;
                }
                long averageDuration = totalDuration / iterations;
                System.out.println(sorter.toString() + " average took " + averageDuration / 1_000_000.0 + " ms");
            }
        }
    }

    @Test
    public void testIntegerOnlySorters() {
        Integer[] countingValues = { 7, -1, 0, 3, -1, 7 };
        new CountingSort().sort(countingValues);
        assertArrayEquals(new Integer[] { -1, -1, 0, 3, 7, 7 }, countingValues);

        Integer[] radixValues = { Integer.MAX_VALUE, -1, 0, Integer.MIN_VALUE, 42, -1 };
        new RadixSort().sort(radixValues);
        assertArrayEquals(
                new Integer[] { Integer.MIN_VALUE, -1, -1, 0, 42, Integer.MAX_VALUE },
                radixValues);

        Integer[] radixBase10Values = { 170, -45, 75, 90, 802, 24, 2, 66 };
        new RadixSortBase10().sort(radixBase10Values);
        assertArrayEquals(
                new Integer[] { -45, 2, 24, 66, 75, 90, 170, 802 },
                radixBase10Values);

        for (Sorter sorter : new Sorter[] {
                new CountingSort(), new RadixSort(), new RadixSortBase10() }) {
            assertThrows(ClassCastException.class, () -> sorter.sort(new String[] { "b", "a" }));
        }
    }


    
    /**
     * Test a sorter with 2 types of data: Integer and String
     * and the following configurations:
     * - empty list
     * - list with one element
     * - ordered list (100 elements)
     * - list with 100 elements in reverse order
     * - list with 100 elements in random order
     */
    private void testSorter(Sorter sorter) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
        Integer[] emptyArray = new Integer[0];
        Integer[] oneElementArray = new Integer[] { 42 };
        Integer[] orderedArray = set.toArray(new Integer[0]);
        Integer[] reverseOrderedArray = new Integer[100];
        for (int i = 0; i < 100; i++) {
            reverseOrderedArray[i] = 99 - i;
        }
        Integer[] randomArray = new Integer[100];
        for (int i = 0; i < 100; i++) {
            randomArray[i] = (int) (Math.random() * 100);
        }
        
        sorter.sort(emptyArray);
        assertTrue(isSorted(emptyArray));
        
        sorter.sort(oneElementArray);
        assertTrue(isSorted(oneElementArray));
        
        sorter.sort(orderedArray);
        assertTrue(isSorted(orderedArray));
        
        sorter.sort(reverseOrderedArray);
        assertTrue(isSorted(reverseOrderedArray));
        
        sorter.sort(randomArray);
        assertTrue(isSorted(randomArray));
    }

    private <T extends Comparable<T>> boolean isSorted(T[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1].compareTo(array[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
