package leetcode.medium;

import common.*;

import java.util.*;

public class ArrayProblems {
    // Find the Winner of an Array Game
    public int getWinner(int[] arr, int k) {
        int winnerMax = arr[0];
        int winCounter = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > winnerMax) {
                winnerMax = arr[i];
                winCounter = 1;
            } else winCounter++;
            if (winCounter == k) return winnerMax;
        }
        return winnerMax;
    }

    // Sort Colors
    public void sortColors(Integer[] nums) {
        int red = 0, white = 1, blue = 2;
        int redCounter = 0, whiteCounter = 0, blueCounter = 0;
        for (int i : nums) {
            if (i == red) redCounter++;
            else if (i == white) whiteCounter++;
            else if (i == blue) blueCounter++;
        }
        int k = 0;
        while (redCounter-- != 0) nums[k++] = red;
        while (whiteCounter-- != 0) nums[k++] = white;
        while (blueCounter-- != 0) nums[k++] = blue;
        Utils.Integer().printArray(nums);
    }

    // Valid Triangle Number
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int counter = 0, len = nums.length;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++)
                for (int k = j + 1; k < len; k++)
                    if (nums[i] + nums[j] > nums[k]) counter++;
        return counter;
    }

    // Search in Rotated Sorted Array
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    // Subarray Sum Equals K
    public int subArraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }

    // Kth Largest Element in an Array
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int n : nums) queue.offer(n);
        int ans = 0;
        for (int i = 0; i < k && !queue.isEmpty(); i++) ans = queue.poll();
        return ans;
    }

    // Restore the Array From Adjacent Pairs
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> list;
        int start = 0;
        for (int[] row : adjacentPairs) {
            graph.computeIfAbsent(row[0], k -> new ArrayList<>()).add(row[1]);
            graph.computeIfAbsent(row[1], k -> new ArrayList<>()).add(row[0]);
        }
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }
        // DFS
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        list = new LinkedList<>();
        dfs(start, graph, list, visited);
        int[] arr = new int[list.size()];
        start = 0;
        for (int i : list) arr[start++] = i;
        System.out.println(list);
        return arr;
    }

    private static void dfs(int current, Map<Integer, List<Integer>> graph, List<Integer> list, Set<Integer> visited) {
        list.add(current);
        visited.add(current);
        for (int neighbor : graph.get(current))
            if (!visited.contains(neighbor))
                dfs(neighbor, graph, list, visited);
    }

    // 3Sum
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) return finalList;
        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    finalList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < target) left++;
                else right--;
            }
        }
        return finalList;
    }

    // Minimize Maximum Pair Sum in Array
    public int minPairSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int i = 0, j=nums.length-1;
        Arrays.sort(nums);
        while (i<j)
            max = Math.max(max, nums[i++] + nums[j--]);
        return max;
    }


}
