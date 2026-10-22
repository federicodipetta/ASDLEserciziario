package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

import java.util.List;

public interface Sorter {

    /**
     * Ordina l'array di elementi specificato in ordine crescente.
     * @param array l'array da ordinare
     */
    default <T extends Comparable<T>> void sort(T[] array) {
        List<T> list = new java.util.ArrayList<>();
        for (T t : array) {
            list.add(t);
        }
        sort(list);
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
    }

    /**
     * Ordina la lista di elementi specificata in ordine crescente.
     * @param list la lista da ordinare
     */
    <T extends Comparable<T>> void sort(List<T> list);
    
}
