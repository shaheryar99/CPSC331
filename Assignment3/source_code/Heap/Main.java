import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        int[] randomArray = random.ints(1000, 0, 1000).toArray();
        int[] sortedArray = new int[1000];

        for (int i = 0; i < 1000; i++) {
            sortedArray[i] = i;
        }

        /* Heapify Method */

        MaxHeapMain heaper = new MaxHeapMain(1000);
        heaper.heapBuilder(randomArray);
        int heapRandom = heaper.getNumberSwaps();
        heaper.heapSort();
        int totalHeapRandom = heaper.getNumberSwaps();

        heaper = new MaxHeapMain(1000);
        heaper.heapBuilder(sortedArray);
        int heapSorted = heaper.getNumberSwaps();
        heaper.heapSort();
        int totalHeapSorted = heaper.getNumberSwaps();

        /* One by One Method */

        heaper = new MaxHeapMain(1000);

        for (int element : randomArray) {
            heaper.add(element);
        }

        int oneRandom = heaper.getNumberSwaps();
        heaper.resetSwapCounter();
        heaper.heapSort();
        int totalOneRandom = oneRandom + heaper.getNumberSwaps();

        heaper = new MaxHeapMain(1000);

        for (int element : sortedArray) {
            heaper.add(element);
        }

        int oneSorted = heaper.getNumberSwaps();
        heaper.resetSwapCounter();
        heaper.heapSort();
        int totalOneSorted = oneSorted + heaper.getNumberSwaps();

        System.out.println("Heapify Creation [RANDOM] - " + heapRandom);
        System.out.println("Heapify Creation [SORTED] - " + heapSorted);
        System.out.println("Total Heapify Creation [RANDOM] - " + totalHeapRandom);
        System.out.println("Total Heapify Creation [SORTED] - " + totalHeapSorted);

        System.out.println("--");

        System.out.println("One by One Creation [RANDOM] - " + oneRandom);
        System.out.println("One by One Creation [SORTED] - " + oneSorted);
        System.out.println("Total One by One Creation [RANDOM] - " + totalOneRandom);
        System.out.println("TOTAL One by One Creation [SORTED] - " + totalOneSorted);

    }
}
