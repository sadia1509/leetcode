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
}
