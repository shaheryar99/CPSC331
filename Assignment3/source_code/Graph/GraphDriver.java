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
        boolean[] visisted = new boolean[vertex];

        Arrays.fill(weights, Integer.MAX_VALUE);
        Arrays.fill(nodes, -1);
        weights[startLocation] = 0;

    }
}
