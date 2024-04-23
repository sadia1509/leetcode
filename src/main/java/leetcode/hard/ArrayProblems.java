package leetcode.hard;

import common.*;

import java.util.*;

public class ArrayProblems {
    //Median of Two Sorted Arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArr = merge(nums1, nums2);
        int len = mergedArr.length;
        int mid = len / 2;
        return len % 2 == 0 ? (double) (mergedArr[mid - 1] + mergedArr[mid]) / 2 : mergedArr[mid];

    }

    private int[] merge(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] merged = new int[len1 + len2];
        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] <= nums2[j]) merged[k++] = nums1[i++];
            else merged[k++] = nums2[j++];
        }
        if (i < len1 && j >= len2) while (i < len1) merged[k++] = nums1[i++];
        else if (j < len2 && i >= len1) while (j < len2) merged[k++] = nums2[j++];
        return merged;
    }

    // Reverse Pairs
    public int reversePairs(int[] nums) {
        int numLength = nums.length;
        int counter = 0;
        if (numLength < 2) return 0;
        int midIndex = numLength / 2;
        int[] leftArray = new int[midIndex];
        int[] rightArray = new int[numLength - midIndex];
        for (int i = 0; i < midIndex; i++) leftArray[i] = nums[i];
        for (int i = midIndex; i < nums.length; i++) rightArray[i - midIndex] = nums[i];
        counter += reversePairs(leftArray);
        counter += reversePairs(rightArray);
        counter += countThePairs(leftArray, rightArray);
        merge(nums, leftArray, rightArray);
        return counter;
    }

    private int countThePairs(int[] left, int[] right) {
        int counter = 0, j = 0;
        for (int i = 0; i < left.length; i++) {
            while (j < right.length && (long) left[i] > (long) 2 * right[j]) j++;
            counter += j;
        }
        return counter;
    }

    private void merge(int[] arr, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) arr[k++] = leftArray[i++];
            else arr[k++] = rightArray[j++];
        }
        while (i < leftArray.length) arr[k++] = leftArray[i++];
        while (j < rightArray.length) arr[k++] = rightArray[j++];
    }

    // First Missing Positive
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int nextPositive = 1, prev = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i <= 0 || prev == i) continue;
            if (i == nextPositive) nextPositive++;
            else break;
            prev = i;
        }
        return nextPositive;
    }

    // Longest Valid Parentheses
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    // Unique Paths III
    int rs, cs, ans, noObsCount, iStart, jStart;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int uniquePathsIII(int[][] grid) {
        rs = grid.length;
        cs = grid[0].length;
        for (int i = 0; i < rs; i++) {
            for (int j = 0; j < cs; j++) {
                if (grid[i][j] == 0) noObsCount++;
                else if (grid[i][j] == 1) {
                    iStart = i;
                    jStart = j;
                    noObsCount++;
                }
            }
        }
        backTrackForUniquePathsIII(grid, 0, iStart, jStart);
        return ans;
    }

    private void backTrackForUniquePathsIII(int[][] grid, int count, int i, int j) {
        if (i < 0 || i >= rs || j < 0 || j >= cs || grid[i][j] == -1) return;
        if (grid[i][j] == 2) {
            if (count == noObsCount) ans++;
            return;
        }
        grid[i][j] = -1;
        for (int[] dirRow : directions)
            backTrackForUniquePathsIII(grid, count + 1, i + dirRow[0], j + dirRow[1]);
        grid[i][j] = 0;
    }

    // Sudoku Solver
    public void solveSudoku(char[][] board) {
        solveSudoku(board, board.length);
//        for (char[] r : board) Logs.println(Arrays.toString(r));
    }

    private boolean solveSudoku(char[][] board, int n) {
        int row = -1, col = -1;
        boolean isNoEmptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    isNoEmptyLeft = false;
                    break;
                }
            }
            if (!isNoEmptyLeft) break;
        }
        if (isNoEmptyLeft) return true; //Solved
        for (int i = 1; i <= 9; i++) {
            char num = (char) (i + '0');
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n))
                    return true;
                else board[row][col] = '.';
            }
        }
        return false;
    }

    public static boolean isSafe(char[][] board, int row, int col, char num) {
        // row
        for (int i = 0; i < board.length; i++)
            if (board[row][i] == num) return false;
        // column
        for (char[] rowBoard : board)
            if (rowBoard[col] == num) return false;
        // box
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for (int i = rowStart; i < rowStart + sqrt; i++)
            for (int j = colStart; j < colStart + sqrt; j++)
                if (board[i][j] == num) return false;
        return true;
    }
}
