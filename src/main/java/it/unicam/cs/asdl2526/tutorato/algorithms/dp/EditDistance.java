package it.unicam.cs.asdl2526.tutorato.algorithms.dp;

/**
 * Calcola la distanza di Levenshtein tra due stringhe.
 */
public final class EditDistance {

    private EditDistance() {
    }

    /**
     * Inserire, eliminare o sostituire un carattere costa 1.
     * Mantenere un carattere uguale costa 0.
     *
     * @param first stringa di partenza
     * @param second stringa da ottenere
     * @return il numero minimo di operazioni per trasformare first in second
     */
    public static int distance(String first, String second) {
        // TODO: definire uno stato per ogni coppia di prefissi e inizializzare i bordi.
        // TODO: calcolare il costo minimo per ogni cella e leggere il risultato finale.
        throw new UnsupportedOperationException("Implementare distance");
    }
}
