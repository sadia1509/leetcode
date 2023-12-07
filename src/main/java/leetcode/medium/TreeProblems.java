package leetcode.medium;

import common.*;

public class TreeProblems {
    // Count Nodes Equal to Average of Subtree
    int counter = 0;

    public int averageOfSubtree(TreeNode root) {
        averageOfSubtreeHelper(root);
        return counter;
    }

    public int[] averageOfSubtreeHelper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = averageOfSubtreeHelper(root.left);
        int[] right = averageOfSubtreeHelper(root.right);
        int sum = left[0] + root.val + right[0];
        int total = left[1] + 1 + right[1];
        if (sum / total == root.val) counter++;
        return new int[]{sum, total};
    }

    // Sum Root to Leaf Numbers
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    int sumNumbers(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = (sum * 10) + (int) root.value;
        if (root.left == null && root.right == null) return sum;
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }

    // Validate Binary Search Tree
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private static boolean isValidBST(TreeNode root, long lowerBound, long upperBound) {
        if (root == null) return true;
        if ((int) root.value <= lowerBound || (int) root.value >= upperBound) return false;
        return isValidBST(root.left, lowerBound, (int) root.value) && isValidBST(root.right, (int) root.value, upperBound);
    }
}
