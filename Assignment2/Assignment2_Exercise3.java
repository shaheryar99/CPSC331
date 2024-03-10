
/**
* Assignment 2 Exercise 3 - Shaheryar Syed 
* CPSC 331 
* UCID: 30052162
* TA: Harnoor Khehra 
*/

public class Assignment2_Exercise3 {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
       
        /* Generate Stack */
        StackImplemention stacker = new StackImplemention(12);
        stacker.push(3);
        stacker.push(5);
        stacker.push(4);
        stacker.push(8);
        stacker.push(7);
        stacker.push(0);
        stacker.push(9);
        stacker.push(8);
        stacker.push(1);
        stacker.push(3);
        stacker.push(9);
        stacker.push(2);

        System.out.print("Initial Stack: ");
        stacker.showFullStack();

        /* Initalize Queue */
        QueueImplementation queue = new QueueImplementation(12);

        /* While stack isn't empty, push it into queue */
        while(!stacker.isEmpty()) {
            int value = stacker.pop();
            queue.enqueue(value);
        }
        
        /* Reverse by pushing values from queue into stack until queue is empty */
        while(!queue.isEmpty()) {
            int value = queue.dequeue();
            stacker.push(value);
        }
        System.out.println();

        System.out.print("Reversed Stack: ");
        stacker.showFullStack();

        /* Generate Unique Queue */

        int[] uniqueSet = new int[12];
        int uniqueCount = 0;
        QueueImplementation uniqueQueue = new QueueImplementation(9);
        for(int i = 0; i < stacker.arraySize; i++) {
            int value = stacker.returnSingle(i);
            boolean isUnique = true;

            /* Check to see if the value is unique */
            for (int j = 0; j < uniqueCount; j++) {
                if(uniqueSet[j] == value) {
                    isUnique = false;
                    break;
                }
            }

            /* If isUnique is true, add that value to the queue and uniqueSet */
            if(isUnique) {
                if(uniqueCount < uniqueSet.length) {
                    uniqueSet[uniqueCount++] = value;
                    uniqueQueue.enqueue(value);
                }
            }
            
        }

        System.out.println();
        System.out.print("Queue with Unique values: ");
        uniqueQueue.showFullQueue();

    }
}
