package it.unicam.cs.asdl2526.tutorato.collections.sets.tree;

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
     * Aggiunge un valore all'albero AVL
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
     * Restituisce i nodi dell'albero usando la visita DFSs
     * @return l'array dei valori dei nodi visitati in DFS
     */
    public int[] DFS() {
        //TODO: Implementare la visita DFS
        return null;
    }

    /**
     * Restituisce i nodi dell'albero usando la vista BFS
     * @return l'array dei valori dei nodi visitati in BFS
     */
    public int[] BFS() {
        //TODO: Implementare la visita BFS
        return null;
    }
}
