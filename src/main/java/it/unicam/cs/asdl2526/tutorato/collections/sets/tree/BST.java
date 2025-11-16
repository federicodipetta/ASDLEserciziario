package it.unicam.cs.asdl2526.tutorato.collections.sets.tree;

import java.util.*;

/**
 * Implementazione di un insieme (set) basato su un albero binario di ricerca.
 * @param <E> il tipo degli elementi contenuti nell'insieme
 */
public class BST<E extends Comparable<E>> implements Set<E>, SortedSet<E> {
    public BST() {
        //TODO: implementare il costruttore
    }

    @Override
    public int size() {
        //TODO: implementare il metodo
        return 0;
    }

    @Override
    public boolean isEmpty() {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public boolean contains(Object o) {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public boolean add(E e) {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public boolean remove(Object o) {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public void clear() {
        //TODO: implementare il metodo
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public E first() {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public E last() {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public Comparator<? super E> comparator() {
        return E::compareTo;
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

}
