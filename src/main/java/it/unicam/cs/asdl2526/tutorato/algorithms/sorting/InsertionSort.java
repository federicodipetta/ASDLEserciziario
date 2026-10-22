package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

import java.util.List;

public class InsertionSort implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(List<T> list) {
        // TODO implementare
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;

            // Sposta gli elementi di list[0..i-1] che sono maggiori di key di una posizione avanti
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
    }

    @Override
    public String toString() {
        return "InsertionSort";
    }
}