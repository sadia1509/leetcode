package dsa.datastructure.nonlinear;

import common.*;

import java.util.*;

public class GraphClass {
    // Depth First Search or DFS
    public void dfsTraversal(Map<Object, List<Object>> graph, int startingIndex) {
        boolean[] visited = new boolean[graph.size()];
        Stack stack = new Stack();
        visited[startingIndex] = true;
        stack.add(startingIndex);
        while (!stack.isEmpty()) {
            Object removed = stack.pop();
            Logs.print(removed + " ");
            graph.get(removed).forEach(n -> {
                        if (!visited[(int) n]) {
                            visited[(int) n] = true;
                            stack.add(n);
                        }
                    }
            );
        }
        Logs.lineBreak(1);
    }

    // Breadth First Search or BFS
    public void bfsTraversal(Map<Object, List<Object>> graph, int startingIndex) {
        boolean[] visited = new boolean[graph.size()];
        Queue queue = new LinkedList<Integer>();
        visited[startingIndex] = true;
        queue.add(startingIndex);
        while (!queue.isEmpty()) {
            Object removed = queue.remove();
            Logs.print(removed + " ");
            graph.get(removed).forEach(n -> {
                        if (!visited[(int) n]) {
                            visited[(int) n] = true;
                            queue.add(n);
                        }
                    }
            );
        }
        Logs.lineBreak(1);
    }

    // BFS for Disconnected Graph
    public void disconnectedBfsTraversal(Map<Object, List<Object>> graph, int nodeCount) {
        Queue queue = new LinkedList();
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) visited.add(i, false);
        graph.keySet().forEach(k -> {
                    if (!visited.get((int) k)) bfsCheck(graph, visited, queue, (int) k);
                }
        );
        Logs.lineBreak(1);
    }

    private void bfsCheck(Map<Object, List<Object>> graph, List<Boolean> visited, Queue queue, int key) {
        visited.set(key, true);
        queue.add(key);
        while (!queue.isEmpty()) {
            Object removed = queue.remove();
            Logs.print(removed + " ");
            if (!graph.containsKey(removed)) continue;
            graph.get(removed).forEach(val -> {
                if (!visited.get((int) val)) {
                    visited.set((int) val, true);
                    queue.add(val);
                }
            });
        }
    }

    public int[][] to2DArray(Map<Integer, List<Edge>> graph, int[] nodes) {
        int len = nodes.length;
        int[][] graphArray = new int[len][len];
        for (int i = 0; i < len; i++) Arrays.fill(graphArray[i], Integer.MAX_VALUE);
        graph.forEach((source, edges) -> {
            edges.forEach(edge -> {
                graphArray[source][edge.getDestination()] = edge.getWeight();
            });
        });
        for (int i = 0; i < len; i++) graphArray[i][i] = 0;
//        Utils.Integer().printArray(Utils.intToInteger(graphArray));
        return graphArray;
    }
}