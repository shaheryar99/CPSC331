public class IterativeBinarySearch {

    public static int iterativeBinarySearch(int[] arr, int target) {
        /*
         * int[] arr: Sorted array as input
         * target: Value that is being searched for in the array
         *
         * return: int [Either return the index of element that is being searched for or return -1 if not found]
         */
        // PLEASE MODIFY THIS FUNCTION TO CORRECTLY IMPLEMENT ITERATIVE BINARY SEARCH
        System.out.println("Iterative Binary Search");

        int begin = 0;
        int mid = 0;
        int last = arr.length - 1;

        while (begin <= last) {
            mid = (begin + last) / 2;

            if (arr[mid] < target) {
                begin = mid + 1;
            }
            else if (arr[mid] > target) {
                last = mid - 1;
            }
            else {
                return mid;
            }

        }
        return -1;
    }

    /* Method to generate array using any amount of specified elements */ 
    public static int[] generateArray(int elementnumber) {
    	int[] array = new int[elementnumber];
    	
    	for (int i = 0; i < array.length; i++) {
    		array[i] = i;	// Populate array 
    	}
    	
    	return array;
    }

    public static void main(String[] args) {

        int[] arrayX;
    	arrayX = generateArray(1000);
        int target = 488;

        long start = System.nanoTime();
        // How the function is called
        int result = iterativeBinarySearch(arrayX, target);

        if (result == -1) {
            System.out.println("Element not present");
        }
        else {
            System.out.println("Element found at index " + result);
      	}

        long end = System.nanoTime();

        float time = (float)(end-start)/1000000;

        System.out.println("Execution: " + time);
    }
}
