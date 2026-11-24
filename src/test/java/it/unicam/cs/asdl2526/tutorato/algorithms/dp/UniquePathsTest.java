package it.unicam.cs.asdl2526.tutorato.algorithms.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniquePathsTest {

    @Test
    void countsPathsInARectangularGrid() {
        assertEquals(28, UniquePaths.uniquePaths(3, 7));
        assertEquals(28, UniquePaths.uniquePaths(7, 3));
    }

    @Test
    void countsBothRoutesInATwoByTwoGrid() {
        assertEquals(2, UniquePaths.uniquePaths(2, 2));
    }

    @Test
    void countsOnePathAlongARowOrColumn() {
        assertEquals(1, UniquePaths.uniquePaths(1, 5));
        assertEquals(1, UniquePaths.uniquePaths(5, 1));
        assertEquals(1, UniquePaths.uniquePaths(1, 1));
    }

    @Test
    void countsNoPathsWithoutAGrid() {
        assertEquals(0, UniquePaths.uniquePaths(0, 5));
        assertEquals(0, UniquePaths.uniquePaths(4, 0));
        assertEquals(0, UniquePaths.uniquePaths(-1, 5));
    }
}
