public class RecursiveBinarySearch {

    public static int recursiveBinarySearch(int[] arr, int low, int high, int target) {
        /*
         * int[] arr: Sorted array as input
         * int low: lower bound array index
         * int high: upper bound array index
         * target: Value that is being searched for in the array
         *
         * return: int [Either return the index of element that is being searched for or return -1 if not found]
         */
        // PLEASE MODIFY THIS FUNCTION TO CORRECTLY IMPLEMENT RECURSIVE BINARY SEARCH
        System.out.println("Recursive Binary Search");

        int mid = (low+high) / 2;

        if (low > high) {
            return -1;
        }
        else if(target == arr[mid]) {
            return mid;
        }
        else if (target < arr[mid]) {
            return recursiveBinarySearch(arr, low, mid-1, target);
        }
        else {
            return recursiveBinarySearch(arr, mid+1, high, target);

        }
    }

    public static int[] generateArray(int elementnumber) {
    	int[] array = new int[elementnumber];
    	
    	for (int i = 0; i < array.length; i++) {
    		array[i] = i;	
    	}
    	
    	return array;
    }

    public static void main(String[] args) {

        int[] arrayX;
    	arrayX = generateArray(1000);
        int target = 754;

        long start = System.nanoTime();
        // How the function is called
        int result = recursiveBinarySearch(arrayX, 0, arrayX.length - 1, target);

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