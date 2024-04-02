public class Main {
    public static void main(String[] args) {
        StudentDB main = new StudentDB();

        /* Task 1 */
        main.insert(20500120, "Bob");
        main.insert(20700200, "Alice");
        main.insert(30100230, "Cathy");
        main.insert(20200156, "Ali");

        /* Task 2 */
        System.out.println(main.toString());

        /* Task 3 */
        main.insert(20500120, "Bobby");

        /* Task 4 & 5 */
        System.out.println("Task 5, Value associated with ID 20500120 is: " + main.retrieve(20500120) + "\n");

        /* Task 6 */
        main.delete(20500120);

        /* Task 7 */
        System.out.println("Task 7: "+ main.delete(20500120) + "\n");

        /* Task 8 */
        System.out.println("Task 8: " + main.retrieve(20500120) + "\n");

        /* Task 9 */
        System.out.println(main.toString());
    }
}
