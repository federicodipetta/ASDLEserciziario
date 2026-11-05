package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

/**
 * Implementazione di Radix Sort LSD in base 10.
 * Notare che questa versione nella sua soluzione non deve considerare per semplicità i numeri negativi.
 */
public class RadixSortBase10 implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        Integer[] integers = (Integer[]) array;
        if (integers == null || integers.length < 2) {
            return;
        }

        int maximum = integers[0];
        for (int value : integers) {
            if (value > maximum) {
                maximum = value;
            }
        }

        for (int place = 1; maximum / place > 0; place *= 10) {
            Integer[] output = new Integer[integers.length];
            int[] counts = new int[10];

            for (int value : integers) {
                counts[(value / place) % 10]++;
            }
            for (int digit = 1; digit < counts.length; digit++) {
                counts[digit] += counts[digit - 1];
            }
            for (int i = integers.length - 1; i >= 0; i--) {
                int value = integers[i];
                output[--counts[(value / place) % 10]] = value;
            }

            System.arraycopy(output, 0, integers, 0, integers.length);
            if (place > maximum / 10) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "RadixSortBase10";
    }
}