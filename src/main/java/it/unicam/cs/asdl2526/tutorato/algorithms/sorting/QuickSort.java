package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

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
    public <T extends Comparable<T>> void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSortRecursive(array, 0, array.length - 1);
    }

    private <T extends Comparable<T>> void quickSortRecursive(
        T[] array, int low, int high) {

        if (low >= high) {
            return;
        }

        int pivotIndex = selectPivot(array, low, high);
        swap(array, pivotIndex, high);

        int partitionIndex = partition(array, low, high);

        quickSortRecursive(array, low, partitionIndex - 1);
        quickSortRecursive(array, partitionIndex + 1, high);

    }

    /**
     * Seleziona l'indice del pivot in base alla modalità configurata.
     */
    private <T extends Comparable<T>> int selectPivot(T[] array, int low, int high) {
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
    private <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        // Il pivot è ora garantito all'indice 'high' grazie a selectPivot
        T pivot = array[high];
        int i = low; // Indice dell'elemento più piccolo

        for (int j = low; j < high; j++) {
            // Se l'elemento corrente è minore o uguale al pivot
            if (array[j].compareTo(pivot) <= 0) {
                swap(array, i++, j);
            }
        }

        // Sposta il pivot nella sua posizione finale corretta
        swap(array, i, high);
        return i;
    }

    /**
     * Funzione helper per lo scambio di due elementi.
     */
    private <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override 
    public String toString() {
        return "QuickSort " + pivotMode;
    }
}