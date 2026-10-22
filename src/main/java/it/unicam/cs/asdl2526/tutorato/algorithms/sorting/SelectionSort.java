package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

import java.util.List;

public class SelectionSort implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(List<T> list) {
        // TODO implementare
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Scambio dell'elemento minimo trovato con l'elemento corrente (i)
            T temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    @Override
    public String toString() {
        return "SelectionSort";
    }

}