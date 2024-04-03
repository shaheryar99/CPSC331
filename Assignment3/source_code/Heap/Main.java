import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        int[] randomArray = random.ints(1000, 0, 1000).toArray();
        int[] sortedArray = new int[1000];

        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = i;
        }


    }
}
