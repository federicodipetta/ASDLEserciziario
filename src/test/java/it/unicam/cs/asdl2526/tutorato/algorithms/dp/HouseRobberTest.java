package it.unicam.cs.asdl2526.tutorato.algorithms.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HouseRobberTest {

    @Test
    void combinesNonAdjacentHouses() {
        assertEquals(12, HouseRobber.rob(new int[] {2, 7, 9, 3, 1}));
    }

    @Test
    void comparesSkippingAndTakingTheLastHouse() {
        assertEquals(8, HouseRobber.rob(new int[] {4, 1, 4, 2}));
        assertEquals(10, HouseRobber.rob(new int[] {5, 9, 5}));
    }

    @Test
    void takesAtMostOneOfTwoHouses() {
        assertEquals(9, HouseRobber.rob(new int[] {3, 9}));
        assertEquals(9, HouseRobber.rob(new int[] {9, 3}));
    }

    @Test
    void handlesEmptyAndSingleHouseRows() {
        assertEquals(0, HouseRobber.rob(new int[0]));
        assertEquals(7, HouseRobber.rob(new int[] {7}));
    }
}
