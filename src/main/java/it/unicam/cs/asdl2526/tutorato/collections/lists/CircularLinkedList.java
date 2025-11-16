package it.unicam.cs.asdl2526.tutorato.collections.lists;

import java.util.*;

/**
 * Implementazione di una lista collegata circolare. In questa struttura,
 * l'ultimo elemento della lista punta al primo, formando un ciclo.
 * Le operazioni sugli indici non sono supportate per semplicità.
 * La lista deve quindi semplicemente garantire un iteratore circolare, Attenzione che quindi
 * fare un foreach su questa lista manda in loop infinito.
 * @param <E> il tipo degli elementi contenuti nella lista
 */
public class CircularLinkedList<E> implements List<E> {


    protected Node<E> current;

    @Override
    public int size() {
        // TODO: Implementare il metodo
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO: Implementare il metodo
        return false;
    }

    @Override
    public boolean contains(Object o) {
        // TODO: Implementare il metodo
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO: Implementare il metodo
        return new CircularIterator<>();
    }

    @Override
    public boolean add(E e) {
        // TODO: Implementare il metodo
        return false;
    }

    @Override
    public boolean remove(Object o) {
        // TODO: Implementare il metodo
        return false;
    }

    @Override
    public void clear() {
        // TODO: Implementare il metodo
    }

    @Override
    public E get(int index) {
        // TODO: Implementare il metodo
        return null;
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Operazione non supportata per una lista circolare.");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Operazione non supportata per una lista circolare.");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Operazione non supportata per una lista circolare.");
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Operazione non supportata per una lista circolare.");
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Operazione non supportata per una lista circolare.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Operazione non supportata per una lista circolare.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Operazione non supportata per una lista circolare.");
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Operazione non supportata per una lista circolare.");
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Operazione non supportata per una lista circolare.");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Operazione non supportata per una lista circolare.");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Operazione non supportata per una lista circolare.");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Operazione non supportata per una lista circolare.");
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Operazione non supportata per una lista circolare.");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Operazione non supportata per una lista circolare.");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Operazione non supportata per una lista circolare.");
    }

    /**
     * L'iteratore della lista circolare ha sempre un next element
     * @param <E>
     */
    private static class CircularIterator<E> implements Iterator<E> {


        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }


    protected static class Node<E> {
        protected E key;
        protected Node<E> next;
        private Node(E key, Node<E> next) {
            this.key = key;
            this.next = next;
        }

        private Node(E key) {
            this(key, null);
        }
    }
}