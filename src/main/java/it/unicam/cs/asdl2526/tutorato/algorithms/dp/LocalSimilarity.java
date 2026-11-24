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
        int[][] dp = new int[first.length() + 1][second.length() + 1];
        int bestRow = 0;
        int bestColumn = 0;

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                int diagonal = dp[i - 1][j - 1] + pairScore(first.charAt(i - 1), second.charAt(j - 1));
                int up = dp[i - 1][j] + GAP_PENALTY;
                int left = dp[i][j - 1] + GAP_PENALTY;
                dp[i][j] = Math.max(0, Math.max(diagonal, Math.max(up, left)));

                if (dp[i][j] > dp[bestRow][bestColumn]) {
                    bestRow = i;
                    bestColumn = j;
                }
            }
        }

        StringBuilder alignedFirst = new StringBuilder();
        StringBuilder alignedSecond = new StringBuilder();
        int i = bestRow;
        int j = bestColumn;
        // Una cella positiva è sempre interna: la prima riga e la prima colonna valgono zero.
        while (dp[i][j] > 0) {
            char firstChar = first.charAt(i - 1);
            char secondChar = second.charAt(j - 1);
            int score = dp[i][j];

            if (score == dp[i - 1][j - 1] + pairScore(firstChar, secondChar)) {
                alignedFirst.append(firstChar);
                alignedSecond.append(secondChar);
                i--;
                j--;
            } else if (score == dp[i - 1][j] + GAP_PENALTY) {
                alignedFirst.append(firstChar);
                alignedSecond.append(GAP);
                i--;
            } else {
                alignedFirst.append(GAP);
                alignedSecond.append(secondChar);
                j--;
            }
        }

        return new Result(dp[bestRow][bestColumn],
                alignedFirst.reverse().toString(), alignedSecond.reverse().toString());
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
