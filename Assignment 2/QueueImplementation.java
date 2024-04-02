/**
* Assignment 2 Implemention of Queue - Shaheryar Syed 
* CPSC 331 
* UCID: 30052162
* TA: Harnoor Khehra 
*/

public class QueueImplementation {
    int arraySize;
    public int[] intArray;
    int front, rear, totalSize;

    public QueueImplementation(int size) {
        arraySize = size;
        intArray = new int[size];
        front = 0;
        rear = -1;
        totalSize = 0;
    }

    public boolean isEmpty() {
        return (totalSize == 0);
    }

    public boolean isFull() {
        return(totalSize == intArray.length);
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue full");
        }
        else {
            rear = (rear + 1) % intArray.length;
            intArray[rear] = item;
            totalSize++;
        }

    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }
        else {
            int tmp = intArray[front];
            intArray[front] = 0;
            front = (front + 1) % intArray.length;
            totalSize--;
            return tmp;
        }
    }

    public void showFullQueue() {
        for(int i = 0; i < arraySize; i++) {
            if (i==0) {
                System.out.print("[");
            }
            if(i==arraySize-1) {
                System.out.print(intArray[i] + "]");
            }
            else {
                System.out.print(intArray[i]+ " - ");
            }
        }
    }
}
