package common;

import java.util.*;

public class Graph {
    private int[][] edges;
    private int n;
    private int edgesCount;

    public Graph(int n, int[][] edges) {
        this.n = n;
        this.edges = edges;
        this.edgesCount = edges.length;
    }

    public void addEdge(int[] edge) {
        int[][] edges = new int[edgesCount + 1][3];
        for (int i = 0; i < edgesCount; i++) edges[i] = this.edges[i];
        edges[edgesCount] = edge;
        this.edges = edges;
        edgesCount++;
    }

    public int shortestPath(int node1, int node2) {
        Map<Integer, List<int[]>> graph = buildGraph(edges);
        int pathDistance = dijkstra(graph, node1, node2);
        return pathDistance != Integer.MAX_VALUE ? pathDistance : -1;
    }

    private Map<Integer, List<int[]>> buildGraph(int[][] edges) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            int weight = edge[2];
            graph.computeIfAbsent(source, k -> new ArrayList<>()).add(new int[]{destination, weight});
        }
        /*
        for (Map.Entry<Integer, List<int[]>> g : graph.entrySet()) {
            Logs.print(g.getKey() + "--->  ");
            for (int[] r : g.getValue()) {
                for (int i : r) Logs.print(i + " ");
                Logs.print(", ");
            }
            Logs.lineBreak(1);
        }
        */
        return graph;
    }

    private int dijkstra(Map<Integer, List<int[]>> graph, int source, int destiny) {
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        for (int count = 0; count < n - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;
            if (graph.containsKey(u)) {
                for (int[] edge : graph.get(u)) {
                    int v = edge[0];
                    int weight = edge[1];
                    if (!visited[v] && dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                        dist[v] = dist[u] + weight;
                }
            }
        }
        return dist[destiny];
    }

    private int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < n; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Graph{n=").append(n).append(", ");
        result.append("edges=");
        for (int i = 0; i < n; i++) {
            result.append(Arrays.toString(edges[i]));
            if (i < edgesCount - 1) {
                result.append(", ");
            }
        }
        result.append("}");
        return result.toString();
    }

}

/*
class Graph {

    int[][] adj;
    int n;
    public Graph(int n, int[][] edges) {
        adj = new int[n][n];
        this.n = n;
        for(int[] a: adj)  Arrays.fill(a, (int)1e9);


        for(int[] e: edges)  adj[e[0]][e[1]] = e[2];


        for(int i = 0; i < n; i++)   adj[i][i] = 0;


        for(int k = 0; k < n; k++)
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);

    }

    public void addEdge(int[] e) {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                adj[i][j] = Math.min(adj[i][j], adj[i][e[0]] + adj[e[1]][j] + e[2]);

    }

    public int shortestPath(int node1, int node2) {
        if(adj[node1][node2] >= (int)1e9) return -1;

        return adj[node1][node2];
    }
}

 */
