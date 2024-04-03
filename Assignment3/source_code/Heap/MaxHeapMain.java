public class MaxHeapMain {

    public int[] heapArray;
    public int arraySize;
    public int swapCounter;

    public MaxHeapMain(int size) {
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

        while (currentElement > 1 && heapArray[currentElement] > heapArray[parentNode(currentElement)]) {
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
        if (position <= arraySize / 2) {
            int largest = position;
            int left = leftChildNode(position);
            int right = rightChildNode(position);
    
            if (left <= arraySize && heapArray[left] > heapArray[largest]) {
                largest = left;
            }
            if (right <= arraySize && heapArray[right] > heapArray[largest]) {
                largest = right;
            }
            if (largest != position) {
                swap(position, largest);
                maxHeaper(largest); 
            }
        }
    }

    public void heapBuilder (int[] array) {
        this.arraySize = array.length;
        
        System.arraycopy(array, 0, this.heapArray, 1, array.length);

        for (int pos = arraySize / 2; pos >= 1; pos--) {
            maxHeaper(pos);
        }
    }

    public void heapSort() {
        int tmpsize = arraySize;
        for (int i = tmpsize; i >= 2; i--) {
            swap(1, i);
            tmpsize--;
            maxHeaper(1);
        }
        arraySize = tmpsize;
    }
}
