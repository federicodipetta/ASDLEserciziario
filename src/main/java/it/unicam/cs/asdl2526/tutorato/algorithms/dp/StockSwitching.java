package it.unicam.cs.asdl2526.tutorato.algorithms.dp;

/**
 * Trova la strategia migliore per tenere una sola azione tra chiusure consecutive.
 */
public final class StockSwitching {

    private StockSwitching() {
    }

    /**
     * Alla prima chiusura si sceglie gratis un'azione da tenere. A ogni chiusura
     * successiva si può mantenere la stessa azione o passare a un'altra pagando
     * il costo di cambio. L'azione tenuta nell'intervallo produce un guadagno
     * pari alla differenza tra i suoi due prezzi di chiusura.
     *
     * Si deve tenere un'azione in ogni intervallo, anche se il guadagno è negativo.
     * Con meno di due giornate il risultato ha guadagno zero e strategia vuota.
     *
     * @param prices prezzi in una matrice rettangolare, con una riga per giorno
     *        e una colonna per azione. Con almeno due giorni serve almeno un'azione.
     * @param switchCost costo non negativo per passare a un'altra azione
     * @return guadagno massimo e indice dell'azione tenuta in ogni intervallo
     */
    public static Result optimize(int[][] prices, int switchCost) {
        int days = prices.length;
        if (days < 2) {
            return new Result(0, new int[0]);
        }

        int assets = prices[0].length;
        long[][] dp = new long[days][assets];
        int[][] previousAsset = new int[days][assets];

        for (int day = 1; day < days; day++) {
            // Prima del cambio, ogni strategia guadagna la variazione del titolo tenuto.
            long[] beforeSwitch = new long[assets];
            int bestBeforeSwitch = 0;
            for (int asset = 0; asset < assets; asset++) {
                beforeSwitch[asset] = dp[day - 1][asset] + prices[day][asset] - prices[day - 1][asset];
                if (beforeSwitch[asset] > beforeSwitch[bestBeforeSwitch]) {
                    bestBeforeSwitch = asset;
                }
            }

            for (int asset = 0; asset < assets; asset++) {
                // Se il massimo appartiene già a questo titolo, tenerlo costa meno o uguale.
                long keep = beforeSwitch[asset];
                long change = beforeSwitch[bestBeforeSwitch] - switchCost;
                if (change > keep) {
                    dp[day][asset] = change;
                    previousAsset[day][asset] = bestBeforeSwitch;
                } else {
                    dp[day][asset] = keep;
                    previousAsset[day][asset] = asset;
                }
            }
        }

        int lastDay = days - 1;
        int asset = 0;
        for (int candidate = 1; candidate < assets; candidate++) {
            if (dp[lastDay][candidate] > dp[lastDay][asset]) {
                asset = candidate;
            }
        }

        long profit = dp[lastDay][asset];
        int[] heldAssets = new int[lastDay];
        for (int day = lastDay; day > 0; day--) {
            asset = previousAsset[day][asset];
            heldAssets[day - 1] = asset;
        }
        return new Result(profit, heldAssets);
    }

    /**
     * Il guadagno totale e l'azione posseduta tra ciascuna coppia di chiusure.
     */
    public static final class Result {

        private final long profit;
        private final int[] heldAssets;

        private Result(long profit, int[] heldAssets) {
            this.profit = profit;
            this.heldAssets = heldAssets;
        }

        public long getProfit() {
            return profit;
        }

        /**
         * L'elemento d vale l'indice dell'azione tenuta dalla chiusura di d a quella di d + 1.
         */
        public int[] getHeldAssets() {
            return heldAssets.clone();
        }
    }
}
