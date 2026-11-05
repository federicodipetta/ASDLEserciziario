package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

public class RadixSort implements Sorter {

    private static final int BASE = 256;
    private static final int PASSES = Integer.BYTES;

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        Integer[] integers = (Integer[]) array;
        //TODO: implementare
    }

    @Override
    public String toString() {
        return "RadixSort";
    }
}
