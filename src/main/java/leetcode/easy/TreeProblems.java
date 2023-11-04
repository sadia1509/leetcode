package leetcode.easy;

import common.*;
import dsa.datastructure.nonlinear.*;

import java.util.*;

public class TreeProblems {
    TreeClass treeClass = new TreeClass();

    //Find Mode in Binary Search Tree
    public Integer[] findMode(TreeNode root) {
        if (root == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        int max = findMode(root, map, 0);
        List<Integer> list = new LinkedList<>();
        map.forEach((key, value) ->
                {
                    if (value == max) list.add(key);
                }
        );
        Integer[] arr = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);
        return arr;
    }

    public int findMode(TreeNode root, Map<Integer, Integer> map, int max) {
        if (root == null) return max;
        max = findMode(root.left, map, max);
        map.put((int) root.value, map.getOrDefault(root.value, 0) + 1);
        max = Math.max(max, map.get(root.value));
        max = findMode(root.right, map, max);
        return max;
    }

    //Same Tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return isSameTree(p.left, q.left) && (int) p.value == (int) q.value && isSameTree(p.right, q.right);
    }

    // Symmetric Tree
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return isSymmetric(p.left, q.right) && (int) p.value == (int) q.value && isSymmetric(p.right, q.left);
    }

    // Balanced Binary Tree
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = treeClass.height(root.left);
        int rightHeight = treeClass.height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // Minimum Depth of Binary Tree
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int leftDepth = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        int rightDepth = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;

        return Math.min(leftDepth, rightDepth) + 1;
    }

    // Path Sum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && (int) root.value == targetSum)
            return true;

        return hasPathSum(root.left, targetSum - (int) root.value)
                || hasPathSum(root.right, targetSum - (int) root.value);

    }

    // Invert Binary Tree
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
