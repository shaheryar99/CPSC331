/* Shaheryar Syed
 * TA: Harnoor K.
 * UCID: 30052162
 * Question 4 - Graphs
 */

import java.util.Arrays;

public class GraphDriver {
    public int[][] mainArray;
    private int vertex; 

    public GraphDriver(int vertex) {
        this.vertex = vertex;
        this.mainArray = new int[vertex][vertex];
    }

    public void addEdge(int source, int destination, int weight) {
        mainArray[source][destination] = weight;
    }

    public int minDistance(int[] distances, boolean[] visited) {
        int minimum = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < vertex; i++) {
            if(!visited[i] && distances[i] <= minimum) {
                minimum = distances[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void algorithmDij(int startLocation) {
        int[] weights = new int[vertex];
        int[] nodes = new int[vertex];
        boolean[] visited = new boolean[vertex];

        Arrays.fill(weights, Integer.MAX_VALUE);
        Arrays.fill(nodes, -1);
        weights[startLocation] = 0;

        for(int i = 0; i < vertex - 1; i++) {
            int minimum = minDistance(weights, visited);
            visited[minimum] = true;

            for(int j = 0; j < vertex; j++) {
                if (!visited[j] && mainArray[minimum][j] != 0 && weights[minimum] != Integer.MAX_VALUE && weights[minimum] + mainArray[minimum][j] < weights[j]) {
                    nodes[j] = minimum;
                    weights[j] = weights[minimum] + mainArray[minimum][j];
                }
            }
        }
        printMethod(startLocation, weights, nodes);
    }

    public void printMethod(int startLocation, int[] weights, int[] nodes) {
        int vertexIndex;
        for(vertexIndex = 1; vertexIndex < vertex; vertexIndex++) {
            System.out.print("Delivery Location " + vertexIndex + " - Shortest Route: ");

            if(weights[vertexIndex] != Integer.MAX_VALUE) {
                pathways(vertexIndex, nodes, true);
                System.out.println(", Distance: " + weights[vertexIndex]);
            }
            else {
                System.out.println("No route exists, Distance: Infinity (Location " + vertexIndex + " is unreachable from the central warehouse)");
            }
        }
    }

    public void pathways(int current, int[] nodes, boolean last) {
        if (current == -1) {
            return;
        }

        pathways(nodes[current], nodes, false);

        if(last) {
            System.out.print(current);
        }
        else {
            System.out.print(current + " -> ");
        }

    }


}
