package dsa.datastructure.nonlinear;

import common.*;

import java.util.*;

public class UndirectedGraph {
    Map<Integer, List<Edge>> weightedGraph;
    Map<Integer, Integer> graph;

    public UndirectedGraph(boolean isWeightedGraph) {
        if (isWeightedGraph) this.weightedGraph = new HashMap<>();
        else this.graph = new HashMap<>();
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(destination, weight);
        weightedGraph.computeIfAbsent(source, k -> new ArrayList<>()).add(edge);
        edge = new Edge(source, weight);
        weightedGraph.computeIfAbsent(destination, k -> new ArrayList<>()).add(edge);
    }

    public void addEdge(int source, int destination) {
        graph.put(source, destination);
        graph.put(destination, source);
    }

    public Map<Integer, List<Edge>> getWeightedGraph() {
        return weightedGraph;
    }

    public Map<Integer, Integer> getGraph() {
        return graph;
    }

    @Override
    public String toString() {
        return "UndirectedGraph{" +
                "weightedGraph=" + weightedGraph +
                ", graph=" + graph +
                '}';
    }
}
