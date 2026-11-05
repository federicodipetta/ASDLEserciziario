package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

public class CountingSort implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        Integer[] integers = (Integer[]) array;
        if (integers == null || integers.length < 2) {
            return;
        }

        int minimum = integers[0];
        int maximum = integers[0];
        for (int value : integers) {
            if (value < minimum) {
                minimum = value;
            }
            if (value > maximum) {
                maximum = value;
            }
        }

        long range = (long) maximum - minimum + 1;
        if (range > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Counting sort range is too large");
        }

        int[] counts = new int[(int) range];
        for (int value : integers) {
            counts[value - minimum]++;
        }

        int index = 0;
        for (int offset = 0; offset < counts.length; offset++) {
            while (counts[offset] > 0) {
                integers[index++] = offset + minimum;
                counts[offset]--;
            }
        }
    }

    @Override
    public String toString() {
        return "CountingSort";
    }
}
