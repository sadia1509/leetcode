package leetcode.medium;

import common.*;
import dsa.algorithm.Search;

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
    public void sortColors(int[] nums) {
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
        Utils.Integer().printArray(Utils.intToInteger(nums));
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
        Logs.println(list);
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
        int i = 0, j = nums.length - 1;
        Arrays.sort(nums);
        while (i < j)
            max = Math.max(max, nums[i++] + nums[j--]);
        return max;
    }

    // Count Nice Pairs in an Array
    public int countNicePairs(int[] nums) {
        final int mod = 1000000007;
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (final int num : nums) {
            final int diff = num - rev(num);
            final int count = map.getOrDefault(diff, 0);
            total = (total + count) % mod;
            map.put(diff, count + 1);
        }
        return total;
    }

    private int rev(int num) {
        int revNum = 0;
        while (num != 0) {
            revNum = revNum * 10 + (num % 10);
            num /= 10;
        }
        return revNum;
    }

    // Widest Vertical Area Between Two Points Containing No Points
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] arr = new int[points.length];
        int i = 0, max = 0;
        for (int[] row : points) arr[i++] = row[0];
        Arrays.sort(arr);
        for (int j = arr.length - 1; j >= 1; j--)
            max = Math.max(max, arr[j] - arr[j - 1]);
        return max;
    }

    // Find The Original Array of Prefix Xor
    public int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        arr[0] = pref[0];
        for (int i = 1; i < pref.length; i++)
            arr[i] = pref[i - 1] ^ pref[i];
        return arr;
    }

    // Find Triangular Sum of an Array
    public int triangularSum(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        while (n != 1) {
            for (int i = 0; i < n - 1; i++)
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            n--;
        }
        return nums[0];
    }

    // Sort the Students by Their Kth Score
    public int[][] sortTheStudents(int[][] score, int k) {
        //  Arrays.sort(score, (a, b) -> Integer.compare(b[k],a[k]));  // 1 line code!
        quickSort(score, k, 0, score.length - 1);
        return score;
    }

    private void quickSort(int[][] arr, int k, int begin, int end) {
        if (begin < end) {
            int pivot = findPivot(arr, k, begin, end);
            quickSort(arr, k, begin, pivot - 1);
            quickSort(arr, k, pivot + 1, end);
        }
    }

    private int findPivot(int[][] arr, int k, int begin, int end) {
        int pivot = arr[end][k];
        int i = begin - 1;
        for (int j = begin; j < end; j++)
            if (arr[j][k] > pivot)
                swap(arr, ++i, j);
        swap(arr, i + 1, end);
        return i + 1;
    }

    private void swap(int[][] arr, int i, int j) {
        for (int k = 0; k < arr[0].length; k++) {
            int temp = arr[i][k];
            arr[i][k] = arr[j][k];
            arr[j][k] = temp;
        }
    }

    // Number of Laser Beams in a Bank
    public int numberOfBeams(String[] bank) {
        int num = 0, k = 0, arrSize = 0;
        for (int i = 0; i < bank.length; i++)
            if (bank[i].contains("1")) arrSize++;
        int[] arr = new int[arrSize];
        for (int i = 0; i < bank.length; i++) {
            if (bank[i].contains("1")) {
                int counter = 0;
                for (char ch : bank[i].toCharArray())
                    if (ch - '0' == 1) counter++;
                arr[k++] = counter;
            }
        }
        for (int i = 1; i < arrSize; i++)
            num += arr[i - 1] * arr[i];
        return num;
    }

    // Search a 2D Matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix)
            if (Search.binarySearch(row, target) >= 0) return true;
        return false;
    }

    // Maximum Number of Coins You Can Get
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int count = 0, limit = 0;
        for (int i = piles.length - 2; i >= limit; i -= 2) {
            count += piles[i];
            limit++;
        }
        return count;
    }

    // Partition Array According to Given Pivot
    public int[] pivotArray(int[] nums, int pivot) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] < pivot)
                Utils.Integer().swap(Utils.intToInteger(nums), ++i, j);
            else if (nums[j] == pivot) count++;
            else queue.offer(nums[j]);
        }
        while (count != 0) {
            nums[++i] = pivot;
            count--;
        }
        while (!queue.isEmpty())
            nums[++i] = queue.poll();
        return nums;
    }

    // Minimum Number of Operations to Make Array Empty
    public int minOperations(int[] nums) {
        int operations = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        for (int mv : map.values()) {
            if (mv % 3 == 0)
                operations += mv / 3;
            else {
                int res = mod(mv);
                if (res == -1) return -1;
                operations += res;
            }
        }
        return operations;
    }

    private int mod(int mv) {
        int operations = 0;
        while (mv - 3 > 1) {
            mv -= 3;
            operations++;
        }
        if (mv % 2 == 0) operations += mv / 2;
        else if (mv == 1) return -1;
        return operations;
    }
}
