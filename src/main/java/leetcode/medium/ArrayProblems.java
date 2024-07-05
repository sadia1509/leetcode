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

    // Permutations
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        permuteUnique(list, nums, new LinkedList<>(), new boolean[nums.length]);
        return list;
    }

    private void permuteUnique(List<List<Integer>> list, int[] nums, LinkedList<Integer> tempList, boolean[] used) {
        if (tempList.size() == nums.length && !list.contains(tempList)) {
            list.add(new LinkedList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            tempList.add(nums[i]);
            permuteUnique(list, nums, tempList, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    // Permutations
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        permute(list, nums, new LinkedList<>());
        return list;
    }

    private void permute(List<List<Integer>> list, int[] nums, LinkedList<Integer> tempList) {
        if (tempList.size() == nums.length) {
            list.add(new LinkedList<>(tempList));
            return;
        }
        for (int num : nums) {
            if (tempList.contains(num)) continue;
            tempList.add(num);
            permute(list, nums, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    // Rotate Image
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int[] row : matrix)
            for (int i : row)
                queue.offer(i);
        for (int i = len - 1; i >= 0; i--)
            for (int j = 0; j < len; j++)
                matrix[j][i] = queue.poll();
    }

    // Next Permutation
    public void nextPermutation(int[] nums) {
        int mark = -1, len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                mark = i;
                break;
            }
        }
        if (mark == -1) {
            reverse(nums, 0, len - 1);
            return;
        }
        for (int i = len - 1; i > mark; i--) {
            if (nums[i] > nums[mark]) {
                Utils.Integer().swap(Utils.intToInteger(nums), i, mark);
                break;
            }
        }
        reverse(nums, mark + 1, len - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        while (begin < end)
            Utils.Integer().swap(Utils.intToInteger(nums), begin++, end--);
    }

    // Minimum Falling Path Sum
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] paths = new int[rows][cols];
        // Copy the first row from the input matrix to the DP matrix
        System.arraycopy(matrix[0], 0, paths[0], 0, cols);
        // Iterate through the remaining rows
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Calculate the minimum falling path sum for the current cell
                paths[i][j] = matrix[i][j] +
                        Math.min(
                                paths[i - 1][Math.max(0, j - 1)],
                                Math.min(paths[i - 1][j],
                                        paths[i - 1][Math.min(cols - 1, j + 1)])
                        );
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int value : paths[rows - 1])
            minSum = Math.min(minSum, value);
        return minSum;
    }

    // Out of Boundary Paths
    final int MOD = 1_000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] arr = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(arr[i][j], -1);
                arr[i][j][0] = 0;
            }
        }
        return findPaths(m, n, maxMove, startRow, startColumn, arr);
    }

    private int findPaths(int m, int n, int move, int i, int j, int[][][] arr) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) return 1;
        if (arr[i][j][move] != -1) return arr[i][j][move];
        long ans = 0;
        ans += findPaths(m, n, move - 1, i + 1, j, arr) % MOD;
        ans += findPaths(m, n, move - 1, i - 1, j, arr) % MOD;
        ans += findPaths(m, n, move - 1, i, j + 1, arr) % MOD;
        ans += findPaths(m, n, move - 1, i, j - 1, arr) % MOD;
        return arr[i][j][move] = (int) (ans % MOD);
    }

    // Single Number III
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        int counter = 0;
        int[] arr = new int[2];
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() == 1)
                arr[counter++] = entry.getKey();
        return arr;
    }

    // 3Sum Closest
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closeSum = Integer.MAX_VALUE;
        int len = nums.length;
        for (int k = 0; k < len - 2; k++) {
            int i = k + 1, j = len - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (Math.abs(target - sum) < Math.abs(target - closeSum))
                    closeSum = sum;
                if (sum < target) i++;
                else j--;
            }
        }
        return closeSum;
    }

    //  Spiral Matrix II
    public int[][] generateMatrix(int n) {
        if (n == 0) return new int[][]{};
        int[][] matrix = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int sign = 0, value = 1;
        while (top <= bottom && left <= right) {
            switch (sign) {
                case 0:
                    for (int i = left; i <= right; i++)
                        matrix[top][i] = value++;
                    top++;
                    break;
                case 1:
                    for (int i = top; i <= bottom; i++)
                        matrix[i][right] = value++;
                    right--;
                    break;
                case 2:
                    for (int i = right; i >= left; i--)
                        matrix[bottom][i] = value++;
                    bottom--;
                    break;
                case 3:
                    for (int i = bottom; i >= top; i--)
                        matrix[i][left] = value++;
                    left++;
                    break;
            }
            sign = (sign + 1) % 4;
        }
        return matrix;
    }

    // Spiral Matrix
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        int n = matrix.length;
        if (n == 0) return ans;
        int m = matrix[0].length;
        int top = 0, bottom = n - 1, left = 0, right = m - 1;
        int sign = 0;
        while (top <= bottom && left <= right) {
            switch (sign) {
                case 0:
                    for (int i = left; i <= right; i++)
                        ans.add(matrix[top][i]);
                    top++;
                    break;
                case 1:
                    for (int i = top; i <= bottom; i++)
                        ans.add(matrix[i][right]);
                    right--;
                    break;
                case 2:
                    for (int i = right; i >= left; i--)
                        ans.add(matrix[bottom][i]);
                    bottom--;
                    break;
                case 3:
                    for (int i = bottom; i >= top; i--)
                        ans.add(matrix[i][left]);
                    left++;
                    break;
            }
            sign = (sign + 1) % 4;
        }
        return ans;
    }

    // Merge Intervals
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < intervals.length; i++) {
            if (stack.isEmpty()) stack.push(intervals[i]);
            else {
                int end = stack.peek()[1];
                if (end >= intervals[i][0]) stack.peek()[1] = Math.max(end, intervals[i][1]);
                else stack.push(intervals[i]);
            }
        }
        int[][] result = new int[stack.size()][];
        int k = 0;
        for (int[] arr : stack) result[k++] = arr;
        return result;
    }

    // Bag of Tokens
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int maxScore = 0, score = 0;
        int i = 0, j = tokens.length - 1;
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                score++;
                i++;
                maxScore = Math.max(score, maxScore);
            } else {
                if (score >= 1) {
                    power += tokens[j];
                    score--;
                    j--;
                } else i++;
            }
        }
        return maxScore;
    }

    // Binary Subarrays With Sum
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0, prefixSum = 0;
        Map<Integer, Integer> sumCounts = new HashMap<>();
        sumCounts.put(0, 1);
        for (int a : nums) {
            prefixSum += a;
            count += sumCounts.getOrDefault(prefixSum - goal, 0);
            sumCounts.put(prefixSum, sumCounts.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    // Length of Longest Subarray With at Most K Frequency
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, maxLength = 0;
        for (int j = 0; j < nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (i <= j && map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }

    // Find All Duplicates in an Array
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new LinkedList<>();
        int[] arr = new int[nums.length + 1];
        for (int i : nums) arr[i]++;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > 1) list.add(i);
        return list;
    }

    // Find the Duplicate Number
    public int findDuplicate(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i : nums) arr[i]++;
        for (int i = 0; i < nums.length; i++)
            if (arr[i] > 1) return i;
        return -1;
    }

    // Find Peak Element
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1, mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    // Search in Rotated Sorted Array II
    public boolean searchII(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public boolean search(int[] nums, int target, int s, int e) {
        if (s > e) return false;
        int m = s + (e - s) / 2;
        if (nums[m] == target) return true;
        if (nums[s] == nums[m] && nums[m] == nums[e])
            return search(nums, target, s + 1, e - 1);
        if (nums[s] <= nums[m]) {
            if (target >= nums[s] && target <= nums[m])
                return search(nums, target, s, m - 1);
            else return search(nums, target, m + 1, e);
        } else {
            if (target >= nums[m] && target <= nums[e])
                return search(nums, target, m + 1, e);
            else return search(nums, target, s, m - 1);
        }
    }

    // Subsets II
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> outerList = new LinkedList<>();
        Arrays.sort(nums);
        outerList.add(new ArrayList<>());
        int start, end = 0;
        for (int k = 0; k < nums.length; k++) {
            start = 0;
            if (k > 0 && nums[k] == nums[k - 1])
                start = end + 1;
            int n = outerList.size();
            end = n - 1;
            for (int i = start; i < n; i++) {
                List<Integer> innerList = new ArrayList<>(outerList.get(i));
                innerList.add(k);
                outerList.add(innerList);
            }
        }
        return outerList;
    }

    // Valid Sudoku
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char num = board[i][j];
                    board[i][j] = '.';
                    if (!leetcode.hard.ArrayProblems.isSafe(board, i, j, num)) return false;
                    board[i][j] = num;
                }
            }
        }
        return true;
    }

    // Rotate Array
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        int[] temp = new int[k];
        int idx = len - k;
        for (int i = 0; i < k; i++) temp[i] = nums[idx++];
        idx = len - k - 1;
        for (; idx >= 0; idx--) nums[idx + k] = nums[idx];
        idx = 0;
        for (int i : temp) nums[idx++] = i;
    }

    // Count Number of Nice Subarrays
    public int numberOfSubarrays(int[] nums, int k) {
        int[] count = new int[nums.length + 1];
        count[0] = 1;
        int sum = 0, ans = 0;
        for (int num : nums) {
            sum += num % 2;
            if (sum >= k) ans += count[sum - k];
            count[sum]++;
        }
        return ans;
    }
}
