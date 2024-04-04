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

    }

    
}
