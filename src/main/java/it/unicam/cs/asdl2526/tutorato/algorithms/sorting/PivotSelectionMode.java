package it.unicam.cs.asdl2526.tutorato.algorithms.sorting;

/**
 * Definisce le strategie per la selezione del pivot nell'algoritmo QuickSort.
 */
public enum PivotSelectionMode {
    /** Il pivot è sempre l'ultimo elemento dell'array/sotto-array. */
    END,

    /** Il pivot è l'elemento centrale dell'array/sotto-array. */
    MIDDLE,

    /** Il pivot è sempre il primo elemento dell'array/sotto-array. */
    START,

    /** Il pivot è scelto in modo casuale per mitigare il worst-case scenario. */
    RANDOM
}