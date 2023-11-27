package dsa.algorithm;

import common.*;

import java.util.*;

public class ShortestPath {
    int infinite = Integer.MAX_VALUE;

    // Detecting negative cycle using Floyd Warshall - Multi Source Shortest Path - Negative cycle
    public int[][] floydWarshall(int[][] graph) {
        int v = graph.length;
        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (graph[i][k] != infinite && graph[k][j] != infinite
                            && graph[i][k] + graph[k][j] < graph[i][j])
                        graph[i][j] = graph[i][k] + graph[k][j];
                }
            }
        }
        Utils.Integer().printArray(Utils.intToInteger(graph));
        return graph;
    }

    // Dijkstra Algorithm - Single Source Shortest Path - No Negative cycle
    public int[] dijkstra(Map<Integer, List<Edge>> graph, int source, int n) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, infinite);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.getWeight()));
        distance[source] = 0;
        priorityQueue.add(new Edge(source, 0));
        while (!priorityQueue.isEmpty()) {
            int currentVertex = priorityQueue.poll().getDestination();
            if (!graph.containsKey(currentVertex)) continue;
            for (Edge neighbor : graph.get(currentVertex)) {
                int newDistance = distance[currentVertex] + neighbor.getWeight();
                if (newDistance < distance[neighbor.getDestination()]) {
                    distance[neighbor.getDestination()] = newDistance;
                    priorityQueue.add(new Edge(neighbor.getDestination(), newDistance));
                }
            }
        }
        for (int i = 0; i < distance.length; i++)
            Logs.println("From 0 to " + i + " shortest distance: " + distance[i]);
        return distance;
    }

    // Bellman Ford Algorithm - Single Source Shortest Path - Negative cycle
    public void bellmanFord(Map<Integer, List<Edge>> graph, int[] nodes, int source) {
        Map<Integer, Integer> weights = new HashMap<>();
        weights.put(source, 0);
        for (int ob : nodes) {
            if (source == ob) continue;
            weights.put(ob, infinite);
        }
        for (int i = 0; i < nodes.length - 1; i++) relaxEdges(graph, weights);
        Map<Object, Integer> weights1 = Map.copyOf(weights);
        relaxEdges(graph, weights);
        if (weights.equals(weights1)) Logs.println("No negative cycle!");
        else Logs.println("Negative cycle!!!!");

    }

    void relaxEdges(Map<Integer, List<Edge>> graph, Map<Integer, Integer> weights) {
        graph.forEach((source, val) -> {
            val.forEach(edge -> {
                int totalWeights = weights.get(source) + edge.getWeight();
                if (totalWeights < weights.get(edge.getDestination()))
                    weights.put(edge.getDestination(), totalWeights);
            });
        });
    }
}
