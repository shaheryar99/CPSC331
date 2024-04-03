public class Maxheap {
    public int[] heapArray;
    public int arraySize;
    public int swapCounter;

    public Maxheap(int size) {
        this.heapArray = new int[size + 1];
        this.arraySize = 0;
        this.swapCounter = 0;
    }

    public int getNumberSwaps() {
        return swapCounter;
    }

    public void resetSwapCounter() {
        swapCounter = 0;
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
        swapCounter++;
    }

    public void maxHeaper (int position) {
        if (position > (arraySize / 2)) {
            return;
        }

        int largestElement = position;
        int leftSide = leftChildNode(position);
        int rightSide = rightChildNode(position);

        if (largestElement != position) {
            swap(position, largestElement);
            maxHeaper(largestElement);
        }

        if (heapArray[leftSide] > heapArray[largestElement] && leftSide <= arraySize) {
            largestElement = leftSide;
        }

        if (heapArray[rightSide] > heapArray[largestElement] && rightSide <= arraySize) {
            largestElement = rightSide;
        }
    }

    public void heapBuilder (int[] array) {
        this.arraySize = array.length;

        System.arraycopy(array, 0, this.heapArray, 1, array.length);

        for (int position = arraySize; position >= 1; position--) {
            maxHeaper(position);
        }
    }

}
