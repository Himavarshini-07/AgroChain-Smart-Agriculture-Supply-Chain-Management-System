import java.util.*;

public class ShortestPathAlgorithms {

    static final int INF = 99999;

    // Dijkstra's Algorithm
    static void dijkstra(int graph[][], int src) {
        int V = graph.length;
        int dist[] = new int[V];
        boolean visited[] = new boolean[V];

        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = -1;
            int min = INF;

            for (int i = 0; i < V; i++) {
                if (!visited[i] && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }
            }

            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Dijkstra's Algorithm:");
        for (int i = 0; i < V; i++)
            System.out.println("Distance from " + src + " to " + i + " = " + dist[i]);
    }

    // Bellman-Ford Algorithm
    static void bellmanFord(int edges[][], int V, int E, int src) {
        int dist[] = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];

                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        System.out.println("\nBellman-Ford Algorithm:");
        for (int i = 0; i < V; i++)
            System.out.println("Distance from " + src + " to " + i + " = " + dist[i]);
    }

    // Floyd-Warshall Algorithm
    static void floydWarshall(int graph[][]) {
        int V = graph.length;
        int dist[][] = new int[V][V];

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        System.out.println("\nFloyd-Warshall Algorithm:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                System.out.print(dist[i][j] + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int graph[][] = {
                {0, 4, 2, 0},
                {4, 0, 1, 5},
                {2, 1, 0, 8},
                {0, 5, 8, 0}
        };

        dijkstra(graph, 0);

        int edges[][] = {
                {0, 1, 4},
                {0, 2, 2},
                {1, 2, 1},
                {1, 3, 5},
                {2, 3, 8}
        };

        bellmanFord(edges, 4, 5, 0);

        int fwGraph[][] = {
                {0, 4, 2, INF},
                {4, 0, 1, 5},
                {2, 1, 0, 8},
                {INF, 5, 8, 0}
        };

        floydWarshall(fwGraph);
    }
}