package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

/**
 * Implementazione di Radix Sort LSD in base 10.
 * Notare che questa versione nella sua soluzione non deve considerare per semplicità i numeri negativi.
 */
public class RadixSortBase10 implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        Integer[] integers = (Integer[]) array;
        //TODO: implementare
    }

    @Override
    public String toString() {
        return "RadixSortBase10";
    }
}
