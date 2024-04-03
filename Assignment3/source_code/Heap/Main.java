import java.util.Random;

public class Main {
    public static void main(String[] args) {
Random random = new Random();

        int[] randomArray = random.ints(1000, 0, 1000).toArray();
        int[] sortedArray = new int[1000];

        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = i;
        }

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

        heaper = new MaxHeapMain(1000);

        for (int i = 0; i < randomArray.length; i++) {
            heaper.add(randomArray[i]);
        }

        int oneRandom = heaper.getNumberSwaps();
        heaper.heapSort();
        int totalOneRandom = oneRandom + heaper.getNumberSwaps();

        heaper = new MaxHeapMain(1000);

        for (int i = 0; i < randomArray.length; i++) {
            heaper.add(sortedArray[i]);
        }

        int oneSorted = heaper.getNumberSwaps();
        heaper.heapSort();
        int totalOneSorted = oneSorted + heaper.getNumberSwaps();

        System.out.println(heapRandom);
        System.out.println(totalHeapRandom);
        System.out.println(heapSorted);
        System.out.println(totalHeapSorted);

        System.out.println(oneRandom);
        System.out.println(totalOneRandom);
        System.out.println(oneSorted);
        System.out.println(totalOneSorted);

    }
}
