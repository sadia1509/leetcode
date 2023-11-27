package dsa.datastructure.nonlinear;

import common.*;

import java.util.*;

public class DirectedGraph {
    Map<Integer, List<Edge>> weightedGraph;
    Map<Integer, Integer> graph;

    public DirectedGraph(boolean isWeightedGraph) {
        if (isWeightedGraph) this.weightedGraph = new HashMap<>();
        else this.graph = new HashMap<>();
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(destination, weight);
        weightedGraph.computeIfAbsent(source, k -> new ArrayList<>()).add(edge);

    }

    public void addEdge(int source, int destination) {
        graph.put(source, destination);
    }

    public Map<Integer, List<Edge>> getWeightedGraph() {
        return weightedGraph;
    }

    public Map<Integer, Integer> getGraph() {
        return graph;
    }

    @Override
    public String toString() {
        return "DirectedGraph{" +
                "weightedGraph=" + weightedGraph +
                ", graph=" + graph +
                '}';
    }
}
