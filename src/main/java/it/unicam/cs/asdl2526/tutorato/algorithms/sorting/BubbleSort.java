package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

public class BubbleSort implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        // TODO implementare
        
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // scambio gli elementi
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    
    public String toString() {
        return "BubbleSort";
    }
}