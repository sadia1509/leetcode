package leetcode.medium;

import java.util.*;

public class GraphProblem {
    // Cheapest Flights Within K Stops
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights)
            graph.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                int node = curr[0];
                int distance = curr[1];
                if (!graph.containsKey(node)) continue;
                for (int[] next : graph.get(node)) {
                    int neighbour = next[0];
                    int cost = next[1];
                    if (cost + distance >= dist[neighbour]) continue;
                    dist[neighbour] = cost + distance;
                    queue.offer(new int[]{neighbour, dist[neighbour]});
                }
            }
            k--;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    // Word Search
    public boolean exist(char[][] board, String word) {
        int row = board.length, column = board[0].length;
        for (int r = 0; r < row; r++)
            for (int c = 0; c < column; c++)
                if (exist(r, c, 0, board, word, row, column)) return true;
        return false;
    }

    private boolean exist(int r, int c, int i, char[][] board, String world, int row, int column) {
        if (i == world.length()) return true;
        if (r < 0 || c < 0 || r >= row || c >= column || world.charAt(i) != board[r][c])
            return false;
        char temp = board[r][c];
        board[r][c] = ' ';
        boolean ans = exist(r + 1, c, i + 1, board, world, row, column) ||
                exist(r - 1, c, i + 1, board, world, row, column) ||
                exist(r, c + 1, i + 1, board, world, row, column) ||
                exist(r, c - 1, i + 1, board, world, row, column);
        board[r][c] = temp;
        return ans;
    }
}
