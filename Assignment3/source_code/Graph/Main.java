/* Shaheryar Syed
 * TA: Harnoor K.
 * UCID: 30052162
 * Question 4 - Graphs
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of warehouses:");
        while (!input.hasNextInt()) {
            System.out.println("Just enter a number will you?");
            input.nextLine();
        }
        int warehouses = input.nextInt();
        if (warehouses != 1) {
            System.out.println("Okay Jeff Bezos, I'll do the work for you. Warehouses is 1. Try not to screw the next one up okay?");
            warehouses = 1;
        }
        if (warehouses <= 0) {
            System.out.println("No warehouses? LMAO loser. I'll fix that for you.");
            warehouses = 1;
        }

        System.out.println("Number of delivery locations: ");

        while (!input.hasNextInt()) {
            System.out.println(" TRY AGAIN.");
            input.nextLine();
        }

       int deliveryNumber = input.nextInt();

       if (deliveryNumber <= 0) {
        System.out.println("Here google this: Dear Google, can you generate me a positive non-zero integer?");
        System.exit(0);
       }

        int vertex = deliveryNumber + warehouses;

        GraphDriver main = new GraphDriver(vertex);

        System.out.println("Number of roads connecting locations: ");
        while (!input.hasNextInt()) {
            System.out.println("Are we taking an airplane? Cause even they have routes. Try again.");
            input.nextLine();
        }

        int roads = input.nextInt();

        if (roads <= 0) {
            System.out.println("Can't believe you managed to give a computer a headache. Try it with a positive non zero integer. Bye Felicia.");
            System.exit(0);
        }

        boolean failed = false;
        System.out.println("Enter route information in the following manner: <Starting Location> <Destination Location> <Distance> (Without the <>)");
        for(int i = 0; i < roads; i++) {

            try {
                int start = input.nextInt();
                int end = input.nextInt();
                int totalDistance = input.nextInt();
    
                if (start < 0 || end < 0 || totalDistance < 0 || start > deliveryNumber || end > deliveryNumber ) {
                    failed = true;
                }
    
                if (!failed) {
                    main.addEdge(start, end, totalDistance);
                }
                else {
                    System.out.println("All inputs must be valid, greater than 0 numbers and less than the number of delivery locations.");
                    System.exit(0);
                }
            }
            catch (Exception e) {
                System.out.println("Input entered in the wrong format. Please follow the syntax and ensure all numbers are integers. Program will exit.");
                System.exit(0);
            }
        }

        int warehouse = 0;

        main.algorithmDij(warehouse);

        input.close();
    }
}
