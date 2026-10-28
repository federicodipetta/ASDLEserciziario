package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

import java.util.List;

public interface Sorter {

    /**
     * Ordina l'array di elementi specificato in ordine crescente.
     * @param array l'array da ordinare
     */
    <T extends Comparable<T>> void sort(T[] array);

    /**
     * Ordina la lista di elementi specificata in ordine crescente.
     * @param list la lista da ordinare
     */
    @SuppressWarnings("unchecked")
    default <T extends Comparable<T>> void sort(List<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }

        T[] array = (T[]) list.toArray(new Comparable[list.size()]);
        sort(array);
        for (int i = 0; i < array.length; i++) {
            list.set(i, array[i]);
        }
    }

}
