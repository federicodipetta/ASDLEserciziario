package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

public class SelectionSort implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        // TODO implementare
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // Scambio dell'elemento minimo trovato con l'elemento corrente (i)
            T temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    @Override
    public String toString() {
        return "SelectionSort";
    }

}