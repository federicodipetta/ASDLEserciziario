package it.unicam.cs.asdl2526.tutorato.collections.lists;

import java.util.*;

/**
 * Implementazione di una doppia coda (deque) utilizzando una lista doppiamente collegata.
 *
 * @param <E> il tipo degli elementi contenuti nella doppia coda
 */
public class Dequeue<E> implements Deque<E> {

    // TODO: Aggiungere i campi necessari per implementare la doppia coda

    @Override
    public void addFirst(E e) {
        //TODO: implementare il metodo
    }

    @Override
    public void addLast(E e) {
        //TODO: implementare il metodo
    }

    @Override
    public boolean offerFirst(E e) {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public E removeFirst() {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public E removeLast() {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public E pollFirst() {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public E pollLast() {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public E getFirst() {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public E getLast() {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public E peekFirst() {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public E peekLast() {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public boolean add(E e) {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public boolean offer(E e) {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public E remove() {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public E poll() {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public E element() {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public E peek() {
        //TODO: implementare il metodo
        return null;
    }

    @Override
    public void push(E e) {
        //TODO: implementare il metodo

    }

    /**
     * Rimuove e restituisce l'elemento in cima alla pila.
     * @return l'elemento in cima alla pila
     * @throws NoSuchElementException se la pila è vuota
     */
    @Override
    public E pop() {
        //TODO: implementare il metodo
        return null;
    }

    /**
     * Rimuove la prima occorrenza dell'elemento specificato da questa deque, se presente.
     * @param o element to be removed from this deque, if present
     * @return true se l'elemento è stato rimosso, false altrimenti
     */
    @Override
    public boolean remove(Object o) {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
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
    public boolean removeAll(Collection<?> c) {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        //TODO: implementare il metodo
        return false;
    }

    @Override
    public void clear() {
        //TODO: implementare il metodo
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    /**
     * Iteratore che lancia IllegalStateException se si tenta di usarlo dopo aver applicato modifiche alla collezione.
     * @param <E> il tipo degli elementi iterati
     */
    private static class FailFastIterator<E> implements Iterator<E> {
        /**
         * Ritorna true se è possibile invocare {@link  #next()}. False altriemnti.
         * @return {@code true} se è possibile invocare @link  #next()}. {@code false} altriemnti.
         */
        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException();
        }

        /**
         * Restituisce il prossimo elemento dell'iteratore.
         * Prima di invocare questo metodo è necessario invocare {@link #hasNext()} e
         * @return il prossimo elemento dell'iteratore
         * @throws IllegalStateException se sono avvenute modidiche alla collezione dopo la creazione dell'iteratore.
         * @throws NoSuchElementException se non ci sono più elementi da iterare.
         */
        @Override
        public E next() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Il nodo di una lista doppiamente collegata.
     * @param <E> il tipo della chiave memorizzata nel nodo
     */
    private static class Node<E> {
        E key;
        Node<E> next;
        Node<E> prev;
        //TODO: Aggiungere construttori e metodi se necessario.
        Node(E key) {
            this.key = key;
        }
    }

}
