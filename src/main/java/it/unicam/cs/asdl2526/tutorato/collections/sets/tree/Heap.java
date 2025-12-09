package it.unicam.cs.asdl2526.tutorato.collections.sets.tree;
/**
 * Implementazione di un heap minimo utilizzando un array.
 * Un heap minimo è una struttura dati ad albero binario completa
 * in cui il valore di ogni nodo è minore o uguale ai valori dei suoi figli.
 * In questa implementazione, l'heap è rappresentato come un array,
 * dove per ogni nodo in posizione i, il figlio sinistro si trova in posizione
 * 2*i + 1 e il figlio destro in posizione 2*i + 2.
 * @author Template: Federico Di Petta
 */
public class Heap {

    private static final int INITIAL_CAPACITY = 16;

    private static final int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private static final int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private static final int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    /**
     * L'array che rappresenta l'heap.
     */
    private int[] tree;

    //TODO: aggiungere altri campi dati se necessari

    /**
     * Costruisce un heap vuoto con capacità iniziale di 16 elementi.
     */
    public Heap() {
        this(INITIAL_CAPACITY);
    }

    /**
     * Costruisce un heap vuoto con la capacità specificata.
     * @param size
     */
    public Heap(int size) {
        this.tree = new int[size];
    }


    public boolean isEmpty() {
        //TODO: implementare
        return false;
    }

    /**
     * Aggiunge un valore all'heap.
     * Per aggiungere un valore all'heap, lo si inserisce nella prima posizione
     * libera dell'array che rappresenta l'heap, e poi si applica l'operazione di
     * "heapify up" per ripristinare la proprietà di heap.
     * @param value il valore da aggiungere
     * @return true se l'elemento è stato aggiunto, false altrimenti, ad esempio se l'elemento è già presente
     */
    public boolean add(int value) {
        //TODO: implementare
        return false;
    }

    /**
     * Restituisce il valore minimo dell'heap senza rimuoverlo.
     * @return il valore minimo dell'heap
     */
    public int getMin() {
        //TODO: implementare
        return -1;
    }

    /**
     * Rimuove e restituisce il valore minimo dell'heap.
     * @return il valore minimo dell'heap
     */
    public int removeMin() {
        //TODO: implementare
        return -1;
    }

    /**
     * Rimuove un valore specifico dall'heap.
     * Per rimuovere un valore specifico dall'heap, si cerca il valore nell'array,
     * lo si sostituisce con l'ultimo elemento dell'heap, e poi si applicano le operazioni di
     * "heapify up" per ripristinare la proprietà di heap.
     * @param value il valore da rimuovere
     * @return true se l'elemento è stato rimosso, false altrimenti
     */
    public boolean remove(int value) {
        //TODO: implementare
        return false;
    }

    /**
     * Ripristina la proprietà di heap risalendo l'albero a partire dall'indice specificato.
     * @param index l'indice da cui iniziare l'heapify
     */ 
    private void heapify(int index) {
        //TODO: implementare
    }

    /**
     * Ritorna l'array che rappresenta l'heap.
     * Da usare solo per scopi di test.
     * @return l'array che rappresenta l'heap
     */
    protected int[] getTree() {
        int[] copy = new int[tree.length];
        System.arraycopy(tree, 0, copy, 0, tree.length);
        return copy;
    }

}
