import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements BinarySearchTreeInterface<T> {
    private class Node {
        T data;
        Node left, right;

        Node(T data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;
    private ArrayList<T> traversalList;
    private int current;

    public BinarySearchTree() {
        root = null;
        traversalList = new ArrayList<>();
        current = -1;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public void add(T element) {
        root = addRecursive(root, element);
    }

    private Node addRecursive(Node current, T element) {
        if (current == null) {
            return new Node(element);
        }

        if (element.compareTo(current.data) < 0) {
            current.left = addRecursive(current.left, element);
        } else if (element.compareTo(current.data) > 0) {
            current.right = addRecursive(current.right, element);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    @Override
    public boolean contains(T element) {
        return containsRecursive(root, element);
    }

    private boolean containsRecursive(Node current, T element) {
        if (current == null) {
            return false;
        }

        if (element.compareTo(current.data) == 0) {
            return true;
        }

        return element.compareTo(current.data) < 0
            ? containsRecursive(current.left, element)
            : containsRecursive(current.right, element);
    }

    @Override
    public void remove(T element) {
        root = removeRecursive(root, element);
    }

    private Node removeRecursive(Node current, T element) {
        if (current == null) {
            return null;
        }

        if (element.compareTo(current.data) == 0) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            T smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = removeRecursive(current.right, smallestValue);
            return current;
        }

        if (element.compareTo(current.data) < 0) {
            current.left = removeRecursive(current.left, element);
        } else {
            current.right = removeRecursive(current.right, element);
        }
        return current;
    }

    private T findSmallestValue(Node root) {
        return root.left == null ? root.data : findSmallestValue(root.left);
    }

    @Override
    public void reset(int order) {
        traversalList.clear();
        current = 0;
        switch (order) {
            case 0: // Inorder
                inorderRecursive(root);
                break;
            case 1: // Preorder
                preorderRecursive(root);
                break;
            case 2: // Postorder
                postorderRecursive(root);
                break;
            default:
                throw new IllegalArgumentException("Invalid order: " + order);
        }
    }

    @Override
    public T getNext(int order) {
        if (current >= 0 && current < traversalList.size()) {
            return traversalList.get(current++);
        }
        return null;
    }

    @Override
    public void inorderTraversal() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.print(node.data + " ");
            inorderRecursive(node.right);
        }
    }

    @Override
    public void postorderTraversal() {
        postorderRecursive(root);
        System.out.println();
    }

    private void postorderRecursive(Node node) {
        if (node != null) {
            postorderRecursive(node.left);
            postorderRecursive(node.right);
            System.out.print(node.data + " ");
        }
    }

    @Override
    public void preorderTraversal() {
        preorderRecursive(root);
        System.out.println();
    }

    private void preorderRecursive(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderRecursive(node.left);
            preorderRecursive(node.right);
        }
    }

    public T findMax() {
        if (isEmpty()) {
            return null; // or throw an exception, depending on your preference
        }
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    public T findMin() {
        if (isEmpty()) {
            return null; // or throw an exception, depending on your preference
        }
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    public List<T> oddValues() {
        List<T> odd = new ArrayList<>();
        oddValuesRecursive(root, odd);
        return odd;
    }

    public void oddValuesRecursive(Node node, List<T> odd) {
        if (node == null) {
            return;
        }

        oddValuesRecursive(node.left, odd);

        if (node.data instanceof Integer) {
            Integer number = (Integer) node.data;
            if ((number & 1) != 0) {
                odd.add(node.data);
            }
        }

        oddValuesRecursive(node.right, odd);

    }

    @SuppressWarnings("unchecked")
    public int getHeight(BinarySearchTree<Integer> tree) {
        return recursiveGetHeight((BinarySearchTree<T>.Node) tree.root);
    }

    public int recursiveGetHeight(Node node) {
        if (node == null) {
            return -1;
        }
        else {
            return 1 + Math.max(recursiveGetHeight(node.left), recursiveGetHeight(node.right));
        }
    }
}