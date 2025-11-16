package it.unicam.cs.asdl2526.tutorato.collections.sets.tree;

import it.unicam.cs.asdl2526.tutorato.collections.CollectionTest;
import it.unicam.cs.asdl2526.tutorato.collections.sets.SetTest;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BSTTest extends SetTest {

    @Override
    public <E extends Comparable<E>> Set<E> createSet() {
        return new HashSet<>();
    }

}
