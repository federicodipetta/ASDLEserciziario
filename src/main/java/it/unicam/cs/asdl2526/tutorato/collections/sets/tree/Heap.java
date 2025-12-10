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

    private static int getParentIndex(int index) {
        return (index) / 2;
    }

    private static int getLeftChildIndex(int index) {
        return 2 * index;
    }

    private static int getRightChildIndex(int index) {
        return 2 * index + 1;
    }

    private static final int MAX_DEFAULT_CAPACITY = 200;
    /**
     * L'array che rappresenta l'heap.
     */
    private int[] tree;
    private int maxCapacity;
    //TODO: aggiungere altri campi dati se necessari

    /**
     * Costruisce un heap vuoto con capacità massima di 200 elementi.
     */
    public Heap() {
        this(MAX_DEFAULT_CAPACITY);
    }

    /**
     * Costruisce un heap vuoto con la capacità massima specificata.
     * @param maxCapacity
     */
    public Heap(int maxCapacity) {
        this.tree = new int[maxCapacity];
        this.maxCapacity = maxCapacity;
    }


    public boolean isEmpty() {
        //TODO: implementare
        return false;
    }

    /**
     * Aggiunge un valore all'heap.
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

    private void swap(int i, int j) {
        int temp = tree[i];
        tree[i] = tree[j];
        tree[j] = temp;
    }

}
