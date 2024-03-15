package leetcode.easy;

import java.util.*;

public class GraphProblems {
    // Find if Path Exists in Graph
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination && n > 0) return true;
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> list = graph.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            graph.put(edge[0], list);
            list = graph.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            graph.put(edge[1], list);
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(source);
        while (!stack.isEmpty()) {
            int popped = stack.pop();
            if (graph.containsKey(popped)) {
                List<Integer> tempList = graph.get(popped);
                for (int elem : tempList) {
                    if (elem == destination) return true;
                    if (!visited[elem]) {
                        stack.add(elem);
                        visited[elem] = true;
                    }
                }
            }
        }
        return false;
    }

    // Find Center of Star Graph
    public int findCenter(int[][] edges) {
        int max = 0;
        for (int[] arr : edges) {
            max = Math.max(max, arr[0]);
            max = Math.max(max, arr[1]);
        }
        int[] arr = new int[max + 1];
        for (int[] edge : edges) {
            arr[edge[0]]++;
            arr[edge[1]]++;
        }
        int maxIndex = 0;
        for (int i = 1; i <= max; i++)
            if (arr[maxIndex] < arr[i]) maxIndex = i;
        return maxIndex;
    }
}
