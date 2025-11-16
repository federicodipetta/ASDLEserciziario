package it.unicam.cs.asdl2526.tutorato.collections.sets.hash;

import java.util.*;

/**
 * Una classe che implementa un insieme (set) utilizzando una tabella di hash con probing lineare
 * per la risoluzione delle collisioni.
 * @param <E> il tipo degli elementi contenuti nell'insieme
 */
public class HashSetLinearProbing<E> implements Set<E> {

    private Node<E>[] table;
    private int size;

    private static final double LOAD_FACTOR_THREASHOLD = 0.5;
    private static final int INITIAL_CAPACITY = 16;

    public HashSetLinearProbing() {
        this(INITIAL_CAPACITY);
    }

    public HashSetLinearProbing(int capacity) {
        // TODO: inizializzare la tabella con capacity
        table = newArray(capacity);
        size = 0;
    }

    /**
     * La funzione di hash per l'elemento elem.
     * N.B. Assicurarsi che l'indice calcolato sia sempre non negativo e
     * all'interno dei limiti della tabella di hash.
     * @param elem l'elemento di cui calcolare l'hash
     * @return l'indice della tabella di hash corrispondente all'elemento
     */
    private int hash(E elem) {
        // TODO: implementare hash
        return 0;
    }

    /**
     * Raddoppia la capacità dell'insieme
     */
    private void resize() {
        // TODO: implementare resize
    }

    /**
     * Aggiunge un elemento all'insieme se non è già presente.
     * Durante l'aggiunta si utilizza il metodo di risoluzione delle collisioni.
     * L'insieme quindi effettua inserimenti in O(1) ammortizzato.
     * @param e un elemento da aggiungere all'insieme, che non è null o già presente.
     * @return {@code true} se l'elemento è stato aggiunto, {@code false} se era già presente.
     */
    @Override
    public boolean add(E e) {
        // TODO: implementare linear probing
        return false;
    }

    @Override
    public boolean contains(Object o) {
        // TODO: implementare probing
        return false;
    }

    @Override
    public boolean remove(Object o) {
        // TODO: marcare DELETED
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        // TODO: ripristinare tabella e size
    }

    @Override
    public Iterator<E> iterator() {
        return Collections.emptyIterator();
    }

    /**
     * Crea un nuovo array di elementi di tipo E, siccome java non permette di creare array generici
     * metto questa Utility method che usa un cast.
     * @param capacity la capacità del nuovo array
     * @return nuovo array di elementi di tipo E
     */
    @SuppressWarnings("unchecked")
    private Node<E>[] newArray(int capacity) {
        return (Node<E>[]) new Node[capacity];
    }
    // Metodi non richiesti dagli esercizi → unsupported (compila)
    @Override public boolean addAll(Collection<? extends E> c) { throw new UnsupportedOperationException(); }
    @Override public boolean containsAll(Collection<?> c) { throw new UnsupportedOperationException(); }
    @Override public boolean removeAll(Collection<?> c) { throw new UnsupportedOperationException(); }
    @Override public boolean retainAll(Collection<?> c) { throw new UnsupportedOperationException(); }
    @Override public Object[] toArray() { throw new UnsupportedOperationException(); }
    @Override public <T> T[] toArray(T[] a) { throw new UnsupportedOperationException(); }

    /**
     * Nodo della tabella di hash con linear probing. Il nodo consente di marcare un elemento come
     * DELETED senza rimuoverlo fisicamente dalla tabella.
     * @param <E> il tipo dell'elemento memorizzato nel nodo
     */
    private static class Node<E> {
        E value;
        boolean isDeleted;

        Node(E value) {
            this.value = value;
            this.isDeleted = false;
        }

        public E getValue() {
            return value;
        }

        public void markDeleted() {
            this.isDeleted = true;
        }
    }
}
