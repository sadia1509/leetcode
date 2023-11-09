package leetcode.easy;

import common.*;
import dsa.datastructure.nonlinear.*;

import java.util.*;

public class TreeProblems {
    TreeClass treeClass = new TreeClass();

    // Find Mode in Binary Search Tree
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
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        max = Math.max(max, map.get(root.val));
        max = findMode(root.right, map, max);
        return max;
    }

    // Same Tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return isSameTree(p.left, q.left) && p.val == q.val && isSameTree(p.right, q.right);
    }

    // Symmetric Tree
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return isSymmetric(p.left, q.right) && p.val == q.val && isSymmetric(p.right, q.left);
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
        if (root.left == null && root.right == null && root.val == targetSum)
            return true;

        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);

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

    // Binary Tree Paths
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        getAllPaths(root, paths, stack);
        return paths;
    }

    private void getAllPaths(TreeNode root, List<String> paths, Stack<Integer> stack) {
        if (root == null) return;
        stack.push(root.val);
        getAllPaths(root.left, paths, stack);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            Iterator iterator = stack.iterator();
            while (iterator.hasNext()) sb.append(iterator.next() + "->");
            int count = sb.length();
            sb.delete(count - 2, count);
            paths.add(sb.toString());
        }
        getAllPaths(root.right, paths, stack);
        stack.pop();
    }

    // Sum of Left Leaves
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;

        if (root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }

    // Range Sum of BST
    int rangeSumBSTSum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        rangeSumBST(root.left, low, high);
        int value = root.val;
        if (value >= low && value <= high) rangeSumBSTSum += value;
        rangeSumBST(root.right, low, high);
        return rangeSumBSTSum;
    }

    // Find a Corresponding Node of a Binary Tree in a Clone of That Tree
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || cloned == null) return null;
        if (cloned.value == target.value) return cloned;
        TreeNode cloneRef;
        cloneRef = getTargetCopy(original.left, cloned.left, target);
        if (cloneRef != null) return cloneRef;
        return getTargetCopy(original.right, cloned.right, target);
    }
}
