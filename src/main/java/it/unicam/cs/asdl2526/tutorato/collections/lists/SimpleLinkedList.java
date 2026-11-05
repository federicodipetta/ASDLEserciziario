package it.unicam.cs.asdl2526.tutorato.collections.lists;

/**
 * Una semplice lista linkata, che implementa dei metodi di base per la gestione di una lista di elementi.
 * 
 * Ricordarsi che l'idea di base di una lista linkata è quella di avere nodi che contengono un elemento
 * e fanno riferimento al nodo successivo.
 * 
 * 
 * NOTE:
 * - la lista deve eseguire aggiunta, reverse in O(1)
 * - la lista deve eseguire ricerca, rimozione, get in O(n) 
 * @author Federico Di Petta
 */
public class SimpleLinkedList<T> {


    public SimpleLinkedList() {
        
    }
    /**
     * Aggiunge un elemento alla coda della lista. 
     * N.B. la lista accetta elementi nulli e duplicati
     * @param element l'elemento da aggiungere in coda alla lista.
     * @return true se l'elemento è stato aggiunto, false altrimenti.
     */
    public boolean add(T element) {
        //TODO: implementare
        return false;
    }

    /**
     * Cerca un elemento nella lista.
     * @param element l'elemento da cercare nella lista.
     * @return l'elemento se è presente, null altrimenti.
     */
    public T search(T element) {
        //TODO: implementare
        return null;
    }

    /**
     * Rimuove il primo elemento della lista uguale a quello passato come parametro.
     * @param element l'elemento da rimuovere dalla lista.
     * @return true se l'elemento è stato rimosso, false altrimenti.
     */
    public boolean remove(T element) {
        //TODO: implementare
        return false;
    }

    /**
     * 
     * @return il numero di elementi presenti nella lista. 
     */
    public int size() {
        // TODO: implementare
        return 0;
    }
    
    /**
     * 
     * @param element l'elemento di cui si vuole conoscere l'indice.
     * @return l'indice dell'elemento nella lista, o -1 se l'elemento non è presente.
     */
    public int indexOf(T element) {
        // TODO: implementare
        return 0;
    }

    /**
     * 
     * @param index l'indice dell'elemento da restituire.
     * @return l'elemento presente nella lista all'indice specificato.
     */
    public T get(int index) {
        //TODO: implementare
        return null;
    }


    /**
     * 
     * @return true se la lista è vuota, false altrimenti.
     */
    public boolean isEmpty() {
        //TODO: implementare
        return false;
    }

    /**
     * Rimuove tutti gli elementi dalla lista.
     */
    public void clear() {
        //TODO: implementare
    }

    /**
     * Inverte l'ordine degli elementi nella lista.
     */
    public void reverse() {
        //TODO: implementare
    }
    
}
