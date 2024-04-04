/* Shaheryar Syed
 * TA: Harnoor K.
 * UCID: 30052162
 * Question 1 - BST 
 * REF - TA Tutorial Code: https://d2l.ucalgary.ca/d2l/le/content/569171/Home?itemIdentifier=D2L.LE.Content.ContentObject.ModuleCO-6296990
 */

public interface BinarySearchTreeInterface<T extends Comparable<T>> {
    boolean isEmpty();
    boolean isFull();
    int size();
    void clear();
    void add(T element);
    boolean contains(T element);
    void remove(T element);
    void reset(int order);
    T getNext(int order);
    void inorderTraversal();
    void postorderTraversal();
    void preorderTraversal();
}