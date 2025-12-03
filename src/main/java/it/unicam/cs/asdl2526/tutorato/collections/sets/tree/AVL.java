package it.unicam.cs.asdl2526.tutorato.collections.sets.tree;

import java.util.List;

/**
 * Questa classe rappresenta un albero AVL
 */
public class AVL {
    /**
     * Il nodo di un albero AVL
     */
    protected class AVLNode {
        public AVLNode left, right;
        public int value;
        public int height;
        AVLNode(int value) {
            this.value = value;
            this.height = 1;
        }
    }

    /**
     * Restituisce l'altezza del nodo
     * @param node il nodo di cui calcolare l'altezza
     * @return l'altezza del nodo
     */
    protected static int getHeight(AVLNode node) {
        if (node == null) return 0;
        return node.height;
    }

    /**
     * Restituisce il fattore di bilanciamento del nodo
     * @param node il nodo di cui calcolare il fattore di bilanciamento
     * @return il fattore di bilanciamento del nodo
     */
    protected static int getBalance (AVLNode node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * La radice dell'albero AVL
     * è protetta per permettere l'accesso ai test
     */
    protected AVLNode root;

    /**
     * Aggiunge un valore all'albero AVL.
     * Come tutte le aggiunte in un AVL, deve mantenere l'albero bilanciato. Questo
     * Significa che ogni nodo deve avere fattore di bilanciamento -1, 0 o +1.
     * In caso di sbilanciamento, deve eseguire le rotazioni necessarie.
     * Se il bilanciamento è maggiore di 1 e il valore da aggiungere è minore del
     * valore del figlio sinistro, si esegue una rotazione destra.
     * Se il bilanciamento è minore di -1 e il valore da aggiungere è maggiore del
     * valore del figlio destro, si esegue una rotazione sinistra.
     * Se il bilanciamento è maggiore di 1 e il valore da aggiungere è maggiore del
     * valore del figlio sinistro, si esegue una rotazione sinistra sul figlio sinistro
     * seguita da una rotazione destra sul nodo.
     * Se il bilanciamento è minore di -1 e il valore da aggiungere è minore del
     * valore del figlio destro, si esegue una rotazione destra sul figlio destro
     * seguita da una rotazione sinistra sul nodo.
     * @param value il valore da aggiungere
     * @return true se il valore è stato aggiunto, false se era già presente
     */
    public boolean add(int value) {
        // TODO: Implementare l'aggiunta
        return false;
    }

    /**
     * Verifica se un valore è presente nell'albero AVL
     * @param value il valore da cercare
     * @return true se il valore è presente, false altrimenti
     */
    public boolean contains(int value) {
        //TODO: Implementare la ricerca
        return false;
    }

    /**
     * Restituisce la lista dei valori dell'albero AVL in ordine crescente
     * La visita deve essere fatta visitando prima il sottoalbero sinistro,
     * poi la radice, poi il sottoalbero destro (visita in-order)
     */
    public List<Integer> InOrderVisit() {
        //TODO: Implementare la visita DFS
        return null;
    }

    /**
     * Restituisce la lista dei valori dell'albero AVL in visita pre-order.
     * QQuesto significa che per ogni nodo si visita prima la radice,
     * poi il sottoalbero sinistro, poi il sottoalbero destro.
      * @return la lista dei valori in visita pre-order
     */
    public List<Integer> postOrder() {
        //TODO: Implementare la visita post-order
        return null;
    }

}
