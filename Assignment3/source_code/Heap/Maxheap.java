public class Maxheap {
    public int[] heapArray;
    public int arraySize;
    public int swapCounter;

    public Maxheap(int size) {
        this.heapArray = new int[size + 1];
        this.arraySize = 0;
        this.swapCounter = 0;
    }

    public int parentNode (int position) {
        return position / 2;
    }

    public int leftChildNode (int position) {
        return 2 * position;
    }

    public int rightChildNode (int position) {
        return (2 * position) + 1;
    }

    public void add (int element) {
        heapArray[++arraySize] = element;
        int currentElement = arraySize;

        while (heapArray[currentElement] > heapArray[parentNode(currentElement)]) {
            swap(currentElement, parentNode(currentElement));
            currentElement = parentNode(currentElement);
        }
    }

    public void swap (int firstElement, int secondElement) {
        int temp;
        int[] array = this.heapArray;
        temp = array[firstElement];
        array[firstElement] = array[secondElement];
        array[secondElement] = temp;
        swapCounter += 1;
    }
}
