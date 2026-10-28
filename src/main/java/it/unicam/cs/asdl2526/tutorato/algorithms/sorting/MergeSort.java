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
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private <T extends Comparable<T>> void merge(T[] array, int left, int mid, int right) {
        // TODO: implementare la fusione di due sotto-array ordinati
        T[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        T[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);
        int n1 = leftArray.length;
        int n2 = rightArray.length;
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    @Override
    public String toString() {
        return "MergeSort";
    }
}
