package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

import java.util.List;

public class BubbleSort implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(List<T> list) {
        // TODO implementare
        
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    // scambio gli elementi
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    @Override
    
    public String toString() {
        return "BubbleSort";
    }
}