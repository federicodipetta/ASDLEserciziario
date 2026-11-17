package it.unicam.cs.asdl2526.tutorato.collections.lists;

import java.util.*;

/**
 * Implementazione di una lista collegata circolare. In questa struttura,
 * l'ultimo elemento della lista punta al primo, formando un ciclo.
 * Le operazioni sugli indici non sono supportate per semplicità.
 * La lista deve quindi semplicemente garantire un iteratore circolare,
 * Attenzione che quindi
 * fare un foreach su questa lista manda in loop infinito.
 * 
 * @param <E> il tipo degli elementi contenuti nella lista
 */
public class CircularLinkedList<E> implements List<E> {

    protected Node<E> current;
    private int size;
    private int modCount;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> n = head();
        for (int i = 0; i < this.size; i++, n = n.next)
            if (Objects.equals(o, n.key))
                return true;
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new CircularIterator<>(this);
    }

    @Override
    public boolean add(E e) {
        Node<E> node = new Node<>(e);
        if (this.current == null) {
            node.next = node;
        } else {
            node.next = this.current.next;
            this.current.next = node;
        }
        this.current = node;
        this.size++;
        this.modCount++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (this.current == null)
            return false;
        Node<E> prev = this.current;
        Node<E> n = this.current.next;
        for (int i = 0; i < this.size; i++, prev = n, n = n.next) {
            if (Objects.equals(o, n.key)) {
                if (this.size == 1) {
                    this.current = null;
                } else {
                    prev.next = n.next;
                    if (n == this.current)
                        this.current = prev;
                }
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        this.current = null;
        this.size = 0;
        this.modCount++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException(
                    "Indice richiesto " + index + ", grandezza della lista " + this.size);
        Node<E> n = head();
        for (int i = 0; i < index; i++)
            n = n.next;
        return n.key;
    }

    private Node<E> head() {
        return this.current == null ? null : this.current.next;
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
     * 
     * @param <E>
     */
    private static class CircularIterator<E> implements Iterator<E> {

        private final CircularLinkedList<E> list;
        private Node<E> cursor;
        private final int expectedModCount;

        private CircularIterator(CircularLinkedList<E> list) {
            this.list = list;
            this.cursor = list.head();
            this.expectedModCount = list.modCount;
        }

        @Override
        public boolean hasNext() {
            return this.cursor != null;
        }

        @Override
        public E next() {
            if (this.list.modCount != this.expectedModCount)
                throw new ConcurrentModificationException();
            if (this.cursor == null)
                throw new NoSuchElementException("La lista è vuota");
            E key = this.cursor.key;
            this.cursor = this.cursor.next;
            return key;
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