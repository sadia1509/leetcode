package leetcode.easy;

import common.*;
import dsa.datastructure.nonlinear.*;

import java.util.*;

public class TreeProblems {
    TreeClass treeClass = new TreeClass();

    // Find Mode in Binary Search Tree
    public int[] findMode(TreeNode root) {
        if (root == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        int max = findMode(root, map, 0);
        List<Integer> list = new LinkedList<>();
        map.forEach((key, value) ->
                {
                    if (value == max) list.add(key);
                }
        );
        int[] arr = new int[list.size()];
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
        if (cloned.val == target.val) return cloned;
        TreeNode cloneRef;
        cloneRef = getTargetCopy(original.left, cloned.left, target);
        if (cloneRef != null) return cloneRef;
        return getTargetCopy(original.right, cloned.right, target);
    }

    // Sum of Root To Leaf Binary Numbers
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    int sumRootToLeaf(TreeNode root, int val) {
        if (root == null) return 0;
        // Update val
        val = (val * 2) + root.val;
        // if current node is leaf, return the current value of val
        if (root.left == null && root.right == null) return val;
        return sumRootToLeaf(root.left, val) + sumRootToLeaf(root.right, val);
    }

    // Evaluate Boolean Binary Tree
    public boolean evaluateTree(TreeNode root) {
        if (root.val < 2) return root.val == 1;
        if (root.val == 2) // OR
            return evaluateTree(root.left) || evaluateTree(root.right);
        else // AND
            return evaluateTree(root.left) && evaluateTree(root.right);
    }

    // Increasing Order Search Tree
    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    private TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode ans = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return ans;
    }

    // Merge Two Binary Trees
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    // Search in a Binary Search Tree
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode temp = searchBST(root.left, val);
        if (temp != null) return temp;
        return searchBST(root.right, val);
    }

    // Leaf-Similar Trees
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new LinkedList<>();
        List<Integer> leaves2 = new LinkedList<>();
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void getLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) return;
        getLeaves(root.left, leaves);
        getLeaves(root.right, leaves);
        if (root.left == null && root.right == null) leaves.add(root.val);
    }

    // Cousins in Binary Tree
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findTreeNode(root, x);
        TreeNode yy = findTreeNode(root, y);
        return (levelTreeNode(root, xx, 0) == levelTreeNode(root, yy, 0) && !isSibling(root, xx, yy));
    }

    private boolean isSibling(TreeNode root, TreeNode x, TreeNode y) {
        if (root == null) return false;
        return (root.left == x && root.right == y || root.left == y && root.right == x
                || isSibling(root.left, x, y) || isSibling(root.right, x, y));

    }

    private int levelTreeNode(TreeNode root, TreeNode r, int level) {
        if (root == null) return 0;
        if (root == r) return level;
        int ans = levelTreeNode(root.left, r, level + 1);
        if (ans != 0) return ans;
        return levelTreeNode(root.right, r, level + 1);
    }

    private TreeNode findTreeNode(TreeNode node, int n) {
        if (node == null) return null;
        if (node.val == n) return node;
        TreeNode m = findTreeNode(node.left, n);
        if (m != null) return m;
        return findTreeNode(node.right, n);
    }

    // Average of Levels in Binary Tree
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return null;
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode popped = queue.poll();
                sum += popped.val;
                if (popped.left != null) queue.offer(popped.left);
                if (popped.right != null) queue.offer(popped.right);
            }
            result.add(sum / size);
        }
        return result;
    }
}
