package it.unicam.cs.asdl2526.tutorato.algorithms.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinChangeTest {

    @Test
    void findsTheMinimumWhenGreedyFails() {
        assertEquals(2, CoinChange.minCoins(new int[] {1, 3, 4}, 6));
    }

    @Test
    void canUseTheSameCoinMoreThanOnce() {
        assertEquals(3, CoinChange.minCoins(new int[] {4}, 12));
    }

    @Test
    void reportsAnUnreachableAmount() {
        assertEquals(-1, CoinChange.minCoins(new int[] {3, 4}, 5));
        assertEquals(-1, CoinChange.minCoins(new int[0], 2));
    }

    @Test
    void usesNoCoinsForZero() {
        assertEquals(0, CoinChange.minCoins(new int[0], 0));
    }
}
