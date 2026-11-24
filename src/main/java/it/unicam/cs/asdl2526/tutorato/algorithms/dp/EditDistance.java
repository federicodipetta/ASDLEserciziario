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
        int m = first.length();
        int n = second.length();
        int[][] dp = new int[m + 1][n + 1];

        // Un prefisso vuoto richiede solo eliminazioni o solo inserimenti.
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int deletion = dp[i - 1][j] + 1;
                int insertion = dp[i][j - 1] + 1;
                int substitutionCost = first.charAt(i - 1) == second.charAt(j - 1) ? 0 : 1;
                int diagonal = dp[i - 1][j - 1] + substitutionCost;
                dp[i][j] = Math.min(diagonal, Math.min(deletion, insertion));
            }
        }
        return dp[m][n];
    }
}
