package it.unicam.cs.asdl2526.tutorato.algorithms.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StockSwitchingTest {

    @Test
    void switchesAtEachProfitableOpportunityWithoutFees() {
        int[][] prices = {{10, 10}, {13, 14}, {16, 12}, {19, 16}};

        assertStrategy(11, new int[] {1, 0, 1}, StockSwitching.optimize(prices, 0));
    }

    @Test
    void keepsTheSteadilyGrowingStockWhenSwitchesCostTooMuch() {
        int[][] prices = {{10, 10}, {13, 14}, {16, 12}, {19, 16}};

        assertStrategy(9, new int[] {0, 0, 0}, StockSwitching.optimize(prices, 2));
    }

    @Test
    void switchesWhenAnOpportunityOutweighsTheFee() {
        int[][] prices = {{10, 10}, {14, 10}, {14, 15}};

        assertStrategy(7, new int[] {0, 1}, StockSwitching.optimize(prices, 2));
    }

    @Test
    void stillHoldsAStockWhenEveryPriceFalls() {
        int[][] prices = {{10, 10}, {7, 8}, {6, 3}};

        assertStrategy(-3, new int[] {1, 0}, StockSwitching.optimize(prices, 0));
    }

    @Test
    void holdsTheOnlyAvailableStock() {
        int[][] prices = {{10}, {4}, {14}};

        assertStrategy(4, new int[] {0, 0}, StockSwitching.optimize(prices, 5));
    }

    @Test
    void returnsAnEmptyStrategyWithoutAnInterval() {
        assertStrategy(0, new int[0], StockSwitching.optimize(new int[0][], 2));
        assertStrategy(0, new int[0], StockSwitching.optimize(new int[][] {{10, 20}}, 2));
    }

    private void assertStrategy(long profit, int[] heldAssets, StockSwitching.Result result) {
        assertEquals(profit, result.getProfit());
        assertArrayEquals(heldAssets, result.getHeldAssets());
    }
}
