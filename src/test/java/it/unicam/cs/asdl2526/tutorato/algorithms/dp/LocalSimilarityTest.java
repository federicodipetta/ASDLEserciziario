package it.unicam.cs.asdl2526.tutorato.algorithms.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalSimilarityTest {

    @Test
    void startsTracebackAtAnInteriorMaximumAndStopsAtZero() {
        assertAlignment(4, "AB", "AB", LocalSimilarity.align("XABY", "ZABW"));
    }

    @Test
    void reconstructsAGapInEitherRow() {
        assertAlignment(8, "ABXCDE", "AB-CDE", LocalSimilarity.align("ABXCDE", "ABCDE"));
        assertAlignment(8, "AB-CDE", "ABXCDE", LocalSimilarity.align("ABCDE", "ABXCDE"));
    }

    @Test
    void canKeepAnInternalMismatch() {
        assertAlignment(6, "ABXCD", "ABYCD", LocalSimilarity.align("ABXCD", "ABYCD"));
    }

    @Test
    void returnsAnEmptyAlignmentWithoutAPositiveScore() {
        assertAlignment(0, "", "", LocalSimilarity.align("ABC", "XYZ"));
        assertAlignment(0, "", "", LocalSimilarity.align("", "ABC"));
    }

    private void assertAlignment(int score, String first, String second, LocalSimilarity.Result result) {
        assertEquals(score, result.getScore());
        assertEquals(first, result.getAlignedFirst());
        assertEquals(second, result.getAlignedSecond());
    }
}
