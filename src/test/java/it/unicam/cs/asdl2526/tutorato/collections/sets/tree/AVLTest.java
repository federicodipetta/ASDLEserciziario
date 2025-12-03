package it.unicam.cs.asdl2526.tutorato.collections.sets.tree;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AVLTest {

    @Test
    void addIncreasesTreeSize() {
        AVL tree = new AVL();
        assertTrue(tree.add(10));
        assertTrue(tree.add(20));
        assertFalse(tree.add(10));
    }

    @Test
    void containsFindsExistingValues() {
        AVL tree = new AVL();
        tree.add(15);
        tree.add(10);
        tree.add(20);
        assertTrue(tree.contains(15));
        assertTrue(tree.contains(10));
        assertTrue(tree.contains(20));
        assertFalse(tree.contains(25));
    }

    @Test
    void inOrderVisitReturnsCorrectOrder() {
        AVL tree = new AVL();
        tree.add(15);
        tree.add(10);
        tree.add(20);
        tree.add(5);
        tree.add(12);
        assertEquals(Arrays.asList(5, 10, 12, 15, 20), tree.InOrderVisit());
    }

    @Test
    void postOrderVisitReturnsCorrectOrder() {
        AVL tree = new AVL();
        tree.add(15);
        tree.add(10);
        tree.add(20);
        tree.add(5);
        tree.add(12);
        assertEquals(Arrays.asList(5, 12, 10, 20, 15), tree.postOrder());
    }

    @Test
    void leftRotationUpdatesRootCorrectly() {
        AVL tree = new AVL();
        tree.add(10);
        tree.add(20);
        tree.add(30);
        assertEquals(20, tree.root.value);
        assertEquals(10, tree.root.left.value);
        assertEquals(30, tree.root.right.value);
    }

    @Test
    void rightRotationUpdatesRootCorrectly() {
        AVL tree = new AVL();
        tree.add(30);
        tree.add(20);
        tree.add(10); // Causes right rotation
        assertEquals(20, tree.root.value);
        assertEquals(10, tree.root.left.value);
        assertEquals(30, tree.root.right.value);
    }

    @Test
    void leftRightRotationUpdatesRootCorrectly() {
        AVL tree = new AVL();
        tree.add(30);
        tree.add(10);
        tree.add(20);
        assertEquals(20, tree.root.value);
        assertEquals(10, tree.root.left.value);
        assertEquals(30, tree.root.right.value);
    }

    @Test
    void rightLeftRotationUpdatesRootCorrectly() {
        AVL tree = new AVL();
        tree.add(10);
        tree.add(30);
        tree.add(20);
        assertEquals(20, tree.root.value);
        assertEquals(10, tree.root.left.value);
        assertEquals(30, tree.root.right.value);
    }
}
