/**
* Assignment 2 Implemention of Stack - Shaheryar Syed 
* CPSC 331 
* UCID: 30052162
* TA: Harnoor Khehra 
*/

public class StackImplemention {
    int arraySize;
    private int[] intArray;
    private int arrayTop;

    public StackImplemention(int size) {
        arraySize = (int) size;
        intArray = new int[(int) size];
        arrayTop = -1;
    }

    public boolean isEmpty() {
        return(arrayTop == -1);
    }

    public boolean isFull() {
        return (arrayTop == arraySize - 1);
    }

    public void push(int value) {

        if (isFull()) {
            System.out.println("Yo big dawg, on moms, stack full fam.");
            return;
        }
        else {
            arrayTop++;
            intArray[arrayTop] = (int) value;
        }

    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("My g... Stack's empty fr fr.");
            return -1;
        }
        else {
            int poppedelement;
            poppedelement = intArray[arrayTop];
            intArray[arrayTop] = 0;
            arrayTop--;
            return poppedelement;
        }
    }

    public void peek() {
        if(isEmpty()) {
            System.out.println("Tried to peek at the stack, but it ducked and ran, said, Catch me if you can, I'm on a zero-data plan.");
        }
        else {
            System.out.println(intArray[arrayTop]);
        }
    }

    public void showFullStack() {
        for(int i = 0; i < arraySize; i++) {
            if (i==0) {
                System.out.print("[");
            }
            if(i==arraySize-1) {
                System.out.print(intArray[arraySize-i-1] + "]");
            }
            else {
                System.out.print(intArray[arraySize-i-1]+ " - ");
            }
        }
    }

    public int returnSingle(int i) {
        return intArray[arrayTop - i];
    }

    public int[] seeElements() {

        int nonzero = 0;
        int[] zeroarray = new int[0];

        if (isEmpty()) {
            return zeroarray;
        }

        else {

            for (int i = 0; i < arraySize; i++) {
                if(intArray[i] != 0) {
                    nonzero++;
                }
            }
    
            int[] nonzeroarray = new int[nonzero];
    
            for (int j = 0; j < arraySize; j++) {
                if (intArray[j] != 0) {
                    nonzeroarray[j] = intArray[j];
                }
            }
            return nonzeroarray;
        }

    }
}
