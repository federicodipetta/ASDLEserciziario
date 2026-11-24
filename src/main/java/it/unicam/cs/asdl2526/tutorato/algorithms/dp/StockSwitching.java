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
        // TODO: definire lo stato dopo la scelta dell'azione alla chiusura.
        // TODO: confrontare mantenimento e cambio, salvando il predecessore migliore.
        // TODO: ricostruire l'azione tenuta in ciascun intervallo dal massimo finale.
        throw new UnsupportedOperationException("Implementare optimize");
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
