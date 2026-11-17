package it.unicam.cs.asdl2526.tutorato.collections.lists;

/**
 * Una semplice lista linkata, che implementa dei metodi di base per la gestione
 * di una lista di elementi.
 * 
 * Ricordarsi che l'idea di base di una lista linkata è quella di avere nodi che
 * contengono un elemento
 * e fanno riferimento al nodo successivo.
 * 
 * 
 * NOTE:
 * - la lista deve eseguire aggiunta, reverse in O(1)
 * - la lista deve eseguire ricerca, rimozione, get in O(n)
 * 
 * @author Federico Di Petta
 */
public class SimpleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;
    private boolean headToTail = true;

    public SimpleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Aggiunge un elemento alla coda della lista.
     * N.B. la lista accetta elementi nulli e duplicati
     * 
     * @param element l'elemento da aggiungere in coda alla lista.
     * @return true se l'elemento è stato aggiunto, false altrimenti.
     */
    public boolean add(T element) {
        if (this.head == null) {
            Node<T> node = new Node<T>(element, null, null);
            this.head = node;
            this.tail = node;
        } else if (this.head == this.tail && this.headToTail) {
            Node<T> node = new Node<T>(element, this.head, null);
            this.head.next = node;
            this.tail = node;
        } else if (this.head == this.tail && !this.headToTail) {
            Node<T> node = new Node<T>(element, null, this.tail);
            this.tail.prev = node;
            this.head = node;
        } else if (this.headToTail) {
            Node<T> newTail = new Node<T>(element, this.tail, null);
            this.tail.next = newTail;
            this.tail = newTail;
        } else if (!this.headToTail) {
            Node<T> newHead = new Node<T>(element, null, this.head);
            this.head.prev = newHead;
            this.head = newHead;
        } else
            throw new UnsupportedOperationException("Stato non raggiungibile");

        this.size++;
        return true;
    }

    /**
     * Cerca un elemento nella lista.
     * 
     * @param element l'elemento da cercare nella lista.
     * @return l'elemento se è presente, null altrimenti.
     */
    public T search(T element) {
        for (Node<T> n = start(); n != null; n = getNext(n)) {
            if (checkElem(element, n)) {
                return n.element;
            }
        }
        return null;
    }

    /**
     * Rimuove il primo elemento della lista uguale a quello passato come parametro.
     * 
     * @param element l'elemento da rimuovere dalla lista.
     * @return true se l'elemento è stato rimosso, false altrimenti.
     */
    public boolean remove(T element) {
        Node<T> n;
        for (n = start(); n != null; n = getNext(n)) {
            if (checkElem(element, n)) {
                if (this.head == n && this.tail == this.head) {
                    this.head = null;
                    this.tail = null;
                } else if (this.head == n && this.tail != this.head) {
                    this.head = n.next;
                    this.head.prev = null;
                } else if (this.tail == n && this.tail != this.head) {
                    this.tail = n.prev;
                    this.tail.next = null;
                } else if (this.tail != n && this.head != n) {
                    n.prev.next = n.next;
                    n.next.prev = n.prev;
                } else
                    throw new UnsupportedOperationException("Caso non gestito");
                this.size--;
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @return il numero di elementi presenti nella lista.
     */
    public int size() {
        return this.size;
    }

    /**
     * 
     * @param element l'elemento di cui si vuole conoscere l'indice.
     * @return l'indice dell'elemento nella lista, o -1 se l'elemento non è
     *         presente.
     */
    public int indexOf(T element) {
        int i = 0;
        for (Node<T> n = start(); n != null; n = getNext(n))
            if (checkElem(element, n))
                return i;
            else
                i++;
        return -1;
    }

    /**
     * 
     * @param index l'indice dell'elemento da restituire.
     * @return l'elemento presente nella lista all'indice specificato.
     */
    public T get(int index) {
        if (index >= this.size() || index < 0)
            throw new IndexOutOfBoundsException(
                    "Indice richiesto " + index + " oltre la grandezza della lista " + this.size());
        int i = 0;
        for (Node<T> n = start(); n != null; n = getNext(n), i++)
            if (i == index)
                return n.element;
        return null;
    }

    /**
     * 
     * @return true se la lista è vuota, false altrimenti.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Rimuove tutti gli elementi dalla lista.
     */
    public void clear() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * Inverte l'ordine degli elementi nella lista.
     */
    public void reverse() {
        this.headToTail = !this.headToTail;
    }

    private Node<T> start() {
        return this.headToTail ? this.head : this.tail;
    }


    private boolean checkElem(T elem, Node<T> node) {
        return elem != null && elem.equals(node.element) || elem == node.element;
    }

    private Node<T> getNext(Node<T> n) {
        return this.headToTail
                ? n.next
                : n.prev;
    }

    private class Node<T> {
        T element;
        Node<T> prev;
        Node<T> next;

        Node(T element, Node<T> prev, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

}
