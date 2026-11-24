package it.unicam.cs.asdl2526.tutorato.algorithms.dp;

/**
 * Cerca un allineamento locale ottimo tra due stringhe.
 */
public final class LocalSimilarity {

    private static final int MATCH = 2;
    private static final int MISMATCH = -2;
    private static final int GAP_PENALTY = -2;
    private static final char GAP = '-';

    private LocalSimilarity() {
    }

    /**
     * Usa +2 per un match e -2 per un mismatch o un gap.
     * Il carattere '-' è riservato ai gap e non compare nelle stringhe di partenza.
     *
     * @param first prima stringa
     * @param second seconda stringa
     * @return un allineamento ottimo, vuoto se il punteggio massimo è zero
     */
    public static Result align(String first, String second) {
        // TODO: riempire la matrice confrontando le tre mosse e la possibilità di ripartire da zero.
        // TODO: memorizzare le coordinate di una cella di punteggio massimo.
        // TODO: ricostruire l'allineamento dal massimo fino alla prima cella con valore zero.
        throw new UnsupportedOperationException("Implementare align");
    }

    private static int pairScore(char first, char second) {
        return first == second ? MATCH : MISMATCH;
    }

    /**
     * Punteggio e righe dell'allineamento, con '-' nelle posizioni dei gap.
     */
    public static final class Result {

        private final int score;
        private final String alignedFirst;
        private final String alignedSecond;

        private Result(int score, String alignedFirst, String alignedSecond) {
            this.score = score;
            this.alignedFirst = alignedFirst;
            this.alignedSecond = alignedSecond;
        }

        public int getScore() {
            return score;
        }

        public String getAlignedFirst() {
            return alignedFirst;
        }

        public String getAlignedSecond() {
            return alignedSecond;
        }
    }
}
