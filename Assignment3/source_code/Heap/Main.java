/* Shaheryar Syed
 * TA: Harnoor K.
 * UCID: 30052162
 * Question 3 - Heap 
 * REF - TA Tutorial Code: https://d2l.ucalgary.ca/d2l/le/content/569171/Home?itemIdentifier=D2L.LE.Content.ContentObject.ModuleCO-6296990
 */

import java.util.Random;

public class Main {
    private int[] Heap; // Array to store heap elements
    private int size;
    private int maxsize;
    private int createCounter;
    private int sortCounter;

    public Main(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        this.createCounter = 0;
        this.sortCounter = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE; // Sentinel value at the 0th index to make indexing easier
    }

    private int getCreateCounter() {
        return createCounter;
    }

    private int getSortCounter() {
        return sortCounter;
    }

    // Returns the index of the parent for the node at index pos
    private int parent(int pos) {return pos / 2; }

    // Returns the index of the left child for the node at index pos
    private int leftChild(int pos) { return (2 * pos); }

    // Returns the index of the right child for the node at index pos
    private int rightChild(int pos) { return (2 * pos) + 1; }

    // Checks if the node at index pos is a leaf node
    private boolean isLeaf(int pos) { return pos > (size / 2) && pos <= size; }

    // Swaps two nodes of the heap at indexes fpos and spos
    private void swap(int fpos, int spos) {
        int tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Heapifies the node at index pos
    private void maxHeapify(int pos, boolean newCreation) {
        if (!isLeaf(pos)) {
            int leftNode = leftChild(pos);
            int rightNode = rightChild(pos);

            if (leftNode <= size && Heap[pos] < Heap[leftChild(pos)] || rightNode <= size && Heap[pos] < Heap[rightChild(pos)]) {
                if (rightNode > size || Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    if (newCreation) {
                        createCounter++; 
                    }
                    else  {
                        sortCounter++;
                    }
                    maxHeapify(leftChild(pos), newCreation);
                } else {
                    swap(pos, rightChild(pos));
                    if (newCreation) {
                        createCounter++; 
                    }  
                    else {
                        sortCounter++;
                    } 
                    maxHeapify(rightChild(pos), newCreation);
                }
            }
        }
    }

    // Inserts a new element into the heap
    public void insert(int element) {
        if (size >= maxsize) {
            return; // Heap is full
        }
        Heap[++size] = element;
        int current = size;

        // Move the new element up to maintain the heap property
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            createCounter++;
            current = parent(current);
        }
    }

    public void heapBuilder (int[] array) {
        this.size = array.length;
        
        System.arraycopy(array, 0, this.Heap, 1, array.length);

        for (int pos = size / 2; pos >= 1; pos--) {
            maxHeapify(pos, true);
        }
    }

    public boolean isFull() { return size == maxsize; }

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }

    public int getMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return Heap[1];
    }

    public void heapSort() {
        int tmpsize = size;
        sortCounter = 0;

        for (int i = size; i > 1; i--) {
            swap(1,i);
            sortCounter++;
            size--;
            maxHeapify(1, false);
        }
        size = tmpsize;
    }

    public static void main(String[] args) {

        Random random = new Random();

        int[] randomArray = random.ints(1000, 0, 1000).toArray();
        int[] sortedArray = new int[1000];

        for (int i = 0; i < 1000; i++) {
            sortedArray[i] = i;
        }

        /* Heap methods */
        Main heap = new Main(1000);
        heap.heapBuilder(randomArray);
        int createHeapRandom = heap.getCreateCounter();
        heap.heapSort();
        int totalHeapRandom = heap.getSortCounter();

        heap = new Main((1000));
        heap.heapBuilder(sortedArray);
        int createHeapSorted = heap.getCreateCounter();
        heap.heapSort();
        int totalHeapSorted = heap.getSortCounter();

        /* One by One Methods */
        heap = new Main(1000);
        for (int element : randomArray) {
            heap.insert(element);
        }
        int oneRandom = heap.getCreateCounter();
        heap.heapSort();
        int totalOneRandom = heap.getSortCounter();

        heap = new Main(1000);
        for(int element1 : sortedArray) {
            heap.insert(element1);
        }
        int oneSorted = heap.getCreateCounter();
        heap.heapSort();
        int totalOneSorted = heap.getSortCounter();

        System.out.println("Heapify Creation [RANDOM] - " + createHeapRandom);
        System.out.println("Heapify Creation [SORTED] - " + createHeapSorted);
        System.out.println("One by One Creation [RANDOM] - " + oneRandom);
        System.out.println("One by One Creation [SORTED] - " + oneSorted);

        System.out.println("--");

        System.out.println("Total Heapify [RANDOM] - " + (totalHeapRandom));
        System.out.println("Total Heapify [SORTED] - " + (totalHeapSorted));
        System.out.println("Total One by One [RANDOM] - " + (totalOneRandom));
        // Total one creation for the sorted array does not count the initial "oneSorted" 
        // amount so we must add that, it also counts the array size in the calculation so we must remove that (-1000)
        System.out.println("Total One by One [SORTED] - " + (totalOneSorted + oneSorted - 1000));
    }
}