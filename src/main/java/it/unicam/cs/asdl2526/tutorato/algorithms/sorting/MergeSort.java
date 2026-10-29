package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

import java.util.Arrays;

public class MergeSort implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        //TODO: implementare l'algoritmo di ordinamento MergeSort

        if (array == null || array.length < 2) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    private <T extends Comparable<T>> void mergeSort(T[] array, int left, int right) {
        //TODO: implementare la ricorsione per il MergeSort
    }

    private <T extends Comparable<T>> void merge(T[] array, int left, int mid, int right) {
        // TODO: implementare la fusione di due sotto-array ordinati
    }

    @Override
    public String toString() {
        return "MergeSort";
    }
}
