package leetcode.hard;

import common.*;

public class GraphProblems {
    // Design Graph With Shortest Path Calculator
    public void runGraphClass() {
        Graph graph = new Graph(4, new int[][]{new int[]{0, 2, 5}, new int[]{0, 1, 2},
                new int[]{1, 2, 1}, new int[]{3, 0, 3}});
        Logs.println(graph);
        Logs.println(graph.shortestPath(3, 2));
        Logs.println(graph.shortestPath(0, 3));
    }
}
