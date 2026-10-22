package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

import java.util.List;
import java.util.Random;

/**
 * Implementazione dell'algoritmo QuickSort con strategie configurabili di selezione del pivot.
 */
public class QuickSort implements Sorter {

    private final PivotSelectionMode pivotMode;
    private final Random random;

    /**
     * Costruttore che accetta la strategia di selezione del pivot.
     * @param pivotMode La modalità con cui viene scelto il pivot (START, MIDDLE, END, RANDOM).
     */
    public QuickSort(PivotSelectionMode pivotMode) {
        this(pivotMode, new Random());
    }

    public QuickSort() {
        this(PivotSelectionMode.END); // Default pivot selection mode
    }

    public QuickSort(PivotSelectionMode pivotMode, long seed) {
        this(pivotMode, new Random(seed));
    }

    private QuickSort(PivotSelectionMode pivotMode, Random random) {
        if (pivotMode == null) {
            throw new IllegalArgumentException("PivotSelectionMode cannot be null");
        }
        this.pivotMode = pivotMode;
        this.random = random;
    }

    @Override
    public <T extends Comparable<T>> void sort(List<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        quickSortRecursive(list, 0, list.size() - 1);
    }

    private <T extends Comparable<T>> void quickSortRecursive(
        List<T> list, int low, int high) {
    while (low < high) {
        int pivotIndex = selectPivot(list, low, high);
        swap(list, pivotIndex, high);

        int partitionIndex = partition(list, low, high);

        if (partitionIndex - low < high - partitionIndex) {
            quickSortRecursive(list, low, partitionIndex - 1);
            low = partitionIndex + 1;
        } else {
            quickSortRecursive(list, partitionIndex + 1, high);
            high = partitionIndex - 1;
        }
    }
    }

    /**
     * Seleziona l'indice del pivot in base alla modalità configurata.
     */
    private <T extends Comparable<T>> int selectPivot(List<T> list, int low, int high) {
        int pivotIndex = 0;
        int size = high - low + 1;

        switch (pivotMode) {
            case END:
                pivotIndex = high;
                break;
            case START:
                pivotIndex = low;
                break;
            case MIDDLE:
                pivotIndex = low + (size / 2);
                break;
            case RANDOM:
                pivotIndex = low + random.nextInt(size);
                break;
        }
        return pivotIndex;
    }

    /**
     * Partiziona il sotto-array attorno al pivot.
     */
    private <T extends Comparable<T>> int partition(List<T> list, int low, int high) {
        // Il pivot è ora garantito all'indice 'high' grazie a selectPivot
        T pivot = list.get(high);
        int i = (low - 1); // Indice dell'elemento più piccolo

        for (int j = low; j < high; j++) {
            // Se l'elemento corrente è minore o uguale al pivot
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }

        // Sposta il pivot nella sua posizione finale corretta
        swap(list, i + 1, high);
        return i + 1;
    }

    /**
     * Funzione helper per lo scambio di due elementi.
     */
    private <T extends Comparable<T>> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    @Override 
    public String toString() {
        return "QuickSort " + pivotMode;
    }
}