/**
* Assignment 2 Exercise 2 - Shaheryar Syed 
* CPSC 331 
* UCID: 30052162
* TA: Harnoor Khehra 
*/

public class Assignment2 {

    /* Exercise 2 - Step 1 */
    public static int[] exercise2_1(int[] arr) {

        int[] tmparr = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            tmparr[i] = arr[arr.length-1-i];
        }
        return tmparr;
    }

    /* Exercise 2 - Step 2 */

    public static int[] exercise2_2(int[] arr) {
        
        int[] tmparr = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            if (i == arr.length-1) {
                tmparr[i] = arr[i];
            }
            else if(arr[i] == 0 || arr[i+1] == 0) {
                tmparr[i] = 0;
            }
            else if(arr[i] < arr[i+1]) {
                tmparr[i] = arr[i+1] / arr[i];
            }
            else {
                tmparr[i] = arr[i] / arr[i+1];
            }
        }

        return tmparr;
    }

    /* Exercise 3 - Step 3 */

    public static int[] exercise2_3(int[] arr) {

        int[] tmparr = new int[arr.length];
        int sortedIndex = 1;

       // Sort the Array in descending order 
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

       // Remove duplicates
        tmparr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                tmparr[sortedIndex++] = arr[i];
            }
        }

        arr = new int[sortedIndex];

        for (int i = 0; i < sortedIndex; i++) {
            arr[i] = tmparr[i];
        }

        return arr;
    }
    public static void main(String[] args) {

        // Initial Array
        int[] ex2_array = {3,15,0,18,4,10,2,5,25};

        // Method for Exercise 2 Step 1
        ex2_array = exercise2_1(ex2_array);

        // Method for Exercise 2 Step 2
        ex2_array = exercise2_2(ex2_array);

        // Method for Exercise 2 Step 3
        ex2_array = exercise2_3(ex2_array);

        // Print the final array
        for (int i = 0; i < ex2_array.length; i++) {
            if(i==0) {
                System.out.print("[" + ex2_array[i]);
            }
            else if(i==ex2_array.length - 1) {
                System.out.print("," + ex2_array[i]+"]");
            }
            else {
                System.out.print("," + ex2_array[i]);
            }
        }

    }
}
