package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

public class RadixSort implements Sorter {

    private static final int BASE = 256;
    private static final int PASSES = Integer.BYTES;

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        Integer[] integers = (Integer[]) array;
        if (integers == null || integers.length < 2) {
            return;
        }

        Integer[] output = new Integer[integers.length];
        for (int pass = 0; pass < PASSES; pass++) {
            int shift = pass * Byte.SIZE;
            int[] counts = new int[BASE];

            for (int value : integers) {
                int bucket = ((value ^ Integer.MIN_VALUE) >>> shift) & (BASE - 1);
                counts[bucket]++;
            }

            for (int bucket = 1; bucket < BASE; bucket++) {
                counts[bucket] += counts[bucket - 1];
            }

            for (int i = integers.length - 1; i >= 0; i--) {
                int value = integers[i];
                int bucket = ((value ^ Integer.MIN_VALUE) >>> shift) & (BASE - 1);
                output[--counts[bucket]] = value;
            }

            System.arraycopy(output, 0, integers, 0, integers.length);
        }
    }

    @Override
    public String toString() {
        return "RadixSort";
    }
}
