package it.unicam.cs.asdl2526.tutorato.algorithms.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditDistanceTest {

    @Test
    void identicalStringsHaveDistanceZero() {
        assertEquals(0, EditDistance.distance("casa", "casa"));
        assertEquals(0, EditDistance.distance("", ""));
    }

    @Test
    void transformsAnEmptyStringUsingOnlyInsertionsOrDeletions() {
        assertEquals(4, EditDistance.distance("", "casa"));
        assertEquals(4, EditDistance.distance("casa", ""));
    }

    @Test
    void aSubstitutionCostsOne() {
        assertEquals(1, EditDistance.distance("gatto", "patto"));
    }

    @Test
    void anInternalInsertionOrDeletionCostsOne() {
        assertEquals(1, EditDistance.distance("casa", "cassa"));
        assertEquals(1, EditDistance.distance("cassa", "casa"));
    }

    @Test
    void combinesEditsAcrossTheTwoStrings() {
        assertEquals(3, EditDistance.distance("ALBERO", "LABBRO"));
        assertEquals(3, EditDistance.distance("kitten", "sitting"));
    }
}
