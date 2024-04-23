package leetcode.hard;

import common.*;

public class TreeProblems {
    // Binary Tree Maximum Path Sum
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxPathSum;
    }

    private int maxPathSumHelper(TreeNode root) {
        if (root == null) return 0;
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);
        left = Math.max(0, left);
        right = Math.max(0, right);
        maxPathSum = Math.max(maxPathSum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
