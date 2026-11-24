package it.unicam.cs.asdl2526.tutorato.algorithms.dp;

/**
 * Conta i percorsi in una griglia senza ostacoli, muovendosi solo a destra o in basso.
 */
public final class UniquePaths {

    private UniquePaths() {
    }

    /**
     * Conta i percorsi dall'angolo in alto a sinistra all'angolo in basso a destra.
     * Il risultato è rappresentabile come int.
     *
     * @param m numero di righe
     * @param n numero di colonne
     * @return il numero di percorsi oppure 0 se una dimensione non è positiva
     */
    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
