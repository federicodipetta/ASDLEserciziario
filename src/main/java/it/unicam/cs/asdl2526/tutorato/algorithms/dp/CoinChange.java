package it.unicam.cs.asdl2526.tutorato.algorithms.dp;

import java.util.Arrays;

/**
 * Calcola il numero minimo di monete necessarie per raggiungere un importo esatto.
 */
public final class CoinChange {

    private CoinChange() {
    }

    /**
     * Ogni denominazione è positiva e può essere usata un numero illimitato di volte.
     * L'importo è non negativo. L'array delle denominazioni può essere vuoto.
     *
     * @param coins denominazioni disponibili
     * @param amount importo da ottenere
     * @return il numero minimo di monete oppure -1 se l'importo è irraggiungibile
     */
    public static int minCoins(int[] coins, int amount) {
        int unreachable = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, unreachable);
        dp[0] = 0;

        for (int current = 1; current <= amount; current++) {
            for (int coin : coins) {
                if (coin <= current && dp[current - coin] != unreachable) {
                    dp[current] = Math.min(dp[current], dp[current - coin] + 1);
                }
            }
        }

        return dp[amount] == unreachable ? -1 : dp[amount];
    }
}
