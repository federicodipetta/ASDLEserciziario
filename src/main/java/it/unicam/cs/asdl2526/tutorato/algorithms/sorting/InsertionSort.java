package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

public class InsertionSort implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        // TODO implementare
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;

            // Sposta gli elementi di array[0..i-1] che sono maggiori di key di una posizione avanti
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    @Override
    public String toString() {
        return "InsertionSort";
    }
}