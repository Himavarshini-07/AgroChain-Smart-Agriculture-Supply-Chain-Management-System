import java.util.*;

public class AgroChainGraph {

    private int vertices;
    private LinkedList<Integer>[] adjList;

    AgroChainGraph(int v) {
        vertices = v;
        adjList = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    void BFS(int start) {

        boolean visited[] = new boolean[vertices];

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {

            int node = queue.poll();
            System.out.print(node + " ");

            for (int n : adjList[node]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void DFS(int node, boolean visited[]) {

        visited[node] = true;
        System.out.print(node + " ");

        for (int n : adjList[node]) {
            if (!visited[n]) {
                DFS(n, visited);
            }
        }
    }

    public static void main(String[] args) {

        AgroChainGraph graph = new AgroChainGraph(5);

        graph.addEdge(0, 1); // Farmer -> Warehouse
        graph.addEdge(1, 2); // Warehouse -> Market A
        graph.addEdge(1, 3); // Warehouse -> Market B
        graph.addEdge(2, 4); // Market A -> Customer

        System.out.println("AGROCHAIN SUPPLY NETWORK");

        System.out.print("\nBFS Traversal: ");
        graph.BFS(0);

        System.out.print("\nDFS Traversal: ");
        boolean visited[] = new boolean[5];
        graph.DFS(0, visited);
    }
}