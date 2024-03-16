/**
* Assignment 2 Exercise 1 - Shaheryar Syed 
* CPSC 331 
* UCID: 30052162
* TA: Harnoor Khehra 
*/

import java.util.*;

public class Assignment2_Exercise1 {
    private LinkedList<Integer>[] listPointer;

    public Assignment2_Exercise1(int n) {
        listPointer = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            listPointer[i] = new LinkedList<>();
        }
    }

    public void addEdge(int start, int end) {
        listPointer[start].add(end);
    }

    public boolean isReachable(int start, int end) {
        boolean[] visited = new boolean[listPointer.length];
        return searchForPath(start, end, visited);
    }

    private boolean searchForPath(int start, int m, boolean[] isSeen) {
        if (start == m) {
            return true;
        }
        isSeen[start] = true;
        for (int next : listPointer[start]) {
            if (!isSeen[next]) {
                if (searchForPath(next, m, isSeen)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int countNumberPaths(int start, int end, int visit) {
        return countNumberPathsMainRecursive(start, end, visit);
    }

    private int countNumberPathsMainRecursive(int start, int end, int m) {
        if (m == 0 && start == end) {
            return 1;
        }

        if (m < 0) {
            return 0;
        }
        
        int pathCount = 0;
        for (int next : listPointer[start]) {
            pathCount += countNumberPathsMainRecursive(next, end, m - 1);
        }
        return pathCount;
    }

    public static void main(String[] args) {

        System.out.println("PART 1:");
        Assignment2_Exercise1 graph = new Assignment2_Exercise1(8);
        graph.addEdge(0, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 3);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);

        int start = 4, end = 5;
        boolean result = graph.isReachable(start, end);
        System.out.printf("Input: Graph [edges = [(0, 6), (6, 7), (7, 3), (3, 5), (4, 6)], n = 6], src = " + start + ", dest = " + end + "\n");
        System.out.printf("Output: " + result + "\n");
        System.out.println("Explanation: There exists a path [4" + "-" + "6" + "-" + "7" + "-" + "3" + "-" + "5] from vertex 4 to vertex 5.\n");

        start = 5; end = 0;
        result = graph.isReachable(start, end);
        System.out.printf("Input: Graph [edges = [(0, 6), (6, 7), (7, 3), (3, 5), (4, 6)], n = 6], src = " + start + ", dest = " + end + "\n");
        System.out.printf("Output: " + result + "\n");
        System.out.println("Explanation: There is no path from vertex 5 to any other vertex.");

        /* Part 2 */
        System.out.println();
        System.out.println("PART 2:");

        Assignment2_Exercise1 graph_2 = new Assignment2_Exercise1(12);
        graph_2.addEdge(0, 6);
        graph_2.addEdge(0, 1);
        graph_2.addEdge(1, 6);
        graph_2.addEdge(1, 9);
        graph_2.addEdge(1, 5);
        graph_2.addEdge(5, 3);
        graph_2.addEdge(3, 4);
        graph_2.addEdge(9, 5);
        graph_2.addEdge(9, 3);
        graph_2.addEdge(9, 4);
        graph_2.addEdge(6, 9);
        graph_2.addEdge(7, 6);
        graph_2.addEdge(7, 1);

        int paths = graph_2.countNumberPaths(0, 3, 4);
        System.out.printf("Input: Graph [edges = [(0, 6), (0, 1), (1, 6), (1, 9), (1, 5), (5, 3), (3, 4), (9, 5), (9, 3), (9, 4), (6, 9), (7, 6), (7, 1)], n=8], src = 0, dest = 3, m = 4\n");
        System.out.printf("Output: " + paths + "\n");
        System.out.println("Explanation: The graph has 3 routes from source 0 to destination 3 with 4 edges.\n" +
                           "0 - 1 - 9 - 5 - 3\n" +
                           "0 - 1 - 6 - 9 - 3\n" +
                           "0 - 6 - 9 - 5 - 3");
    }
}
