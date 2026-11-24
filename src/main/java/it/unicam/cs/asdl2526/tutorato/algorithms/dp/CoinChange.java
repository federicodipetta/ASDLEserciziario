package it.unicam.cs.asdl2526.tutorato.algorithms.dp;

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
        // TODO: definire dp[x] e distinguere il caso base dagli importi irraggiungibili.
        // TODO: per ogni importo, provare le monete che si possono scegliere per ultime.
        throw new UnsupportedOperationException("Implementare minCoins");
    }
}
