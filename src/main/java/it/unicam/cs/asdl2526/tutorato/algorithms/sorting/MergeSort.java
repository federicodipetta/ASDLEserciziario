package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

import java.util.List;

public class MergeSort implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(List<T> list) {
        //TODO: implementare l'algoritmo di ordinamento MergeSort

        if (list == null || list.size() < 2) {
            return;
        }
        mergeSort(list, 0, list.size() - 1);
    }

    private <T extends Comparable<T>> void mergeSort(List<T> list, int left, int right) {
        //TODO: implementare la ricorsione per il MergeSort
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    private <T extends Comparable<T>> void merge(List<T> list, int left, int mid, int right) {
        // TODO: implementare la fusione di due sotto-array ordinati
        int n1 = mid - left + 1;
        int n2 = right - mid;
        T[] leftArray = (T[]) new Comparable[n1];
        T[] rightArray = (T[]) new Comparable[n2];
        for (int i = 0; i < n1; i++) {
            leftArray[i] = list.get(left + i);
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = list.get(mid + 1 + j);
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                list.set(k, leftArray[i]);
                i++;
            } else {
                list.set(k, rightArray[j]);
                j++;
            }
            k++;
        }
        while (i < n1) {
            list.set(k, leftArray[i]);
            i++;
            k++;
        }
        while (j < n2) {
            list.set(k, rightArray[j]);
            j++;
            k++;
        }
    }

    @Override
    public String toString() {
        return "MergeSort";
    }
}
