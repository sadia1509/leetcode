package leetcode.medium;

import common.*;
import java.util.*;
import dsa.datastructure.nonlinear.TreeClass;

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
        sum = (sum * 10) + root.val;
        if (root.left == null && root.right == null) return sum;
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }

    // Validate Binary Search Tree
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long lowerBound, long upperBound) {
        if (root == null) return true;
        if (root.val <= lowerBound || root.val >= upperBound) return false;
        return isValidBST(root.left, lowerBound, root.val) && isValidBST(root.right, root.val, upperBound);
    }

    // Maximum Binary Tree
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++)
            if (nums[maxIndex] < nums[i]) maxIndex = i;
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildTree(nums, start, maxIndex - 1);
        root.right = buildTree(nums, maxIndex + 1, end);
        return root;
    }

    // Binary Tree Level Order Traversal II
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> parentList = new LinkedList<>();
        if (root == null) return parentList;
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()) {
            int tempCount = 0;
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    tempCount++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    tempCount++;
                }
            }
            count = tempCount;
            stack.add(list);
        }
        while (!stack.isEmpty()) parentList.add(stack.pop());
        return parentList;
    }

    // Binary Tree Right Side View
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()) {
            int tempCount = 0;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (i + 1 == count) list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    tempCount++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    tempCount++;
                }
            }
            count = tempCount;
        }
        return list;
    }

    // Recover Binary Search Tree
    private TreeNode prev, first, middle, last;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root);
        if (first != null && last != null) swap(first, last);
        else if (first != null && middle != null) swap(first, middle);
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else last = root;
        }
        prev = root;
        inorderTraversal(root.right);
    }

    private void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    // Binary Tree Level Order Traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> parentList = new LinkedList<>();
        if (root == null) return parentList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()) {
            int tempCount = 0;
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    tempCount++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    tempCount++;
                }
            }
            count = tempCount;
            parentList.add(list);
        }
        return parentList;
    }


    // Count Good Nodes in Binary Tree
    private int sum = 0;

    public int goodNodes(TreeNode root) {
        findSum(root, root.val);
        return sum;
    }

    private void findSum(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) sum++;
        max = Math.max(root.val, max);
        findSum(root.left, max);
        findSum(root.right, max);
    }

    // All Paths From Source to Target
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new LinkedList<>();
        Stack<Integer> pathStack = new Stack<>();
        dfs(graph, paths, pathStack, 0);
        return paths;
    }

    private void dfs(int[][] graph, List<List<Integer>> paths, Stack<Integer> pathStack, int elem) {
        pathStack.add(elem);
        if (elem == graph.length - 1)
            paths.add(new LinkedList<>(pathStack));
        else
            for (int x : graph[elem])
                dfs(graph, paths, pathStack, x);
        pathStack.pop();
    }

    // Deepest Leaves Sum
    public int deepestLeavesSum(TreeNode root) {
        deepestLeavesSum(root, 1, TreeClass.maxDepthOrHeight(root));
        return sum;
    }

    private void deepestLeavesSum(TreeNode root, int level, int maxLevel) {
        if (root == null) return;
        if (root.left == null && root.right == null && level == maxLevel) sum += root.val;
        deepestLeavesSum(root.left, level + 1, maxLevel);
        deepestLeavesSum(root.right, level + 1, maxLevel);
    }

    // Pseudo-Palindromic Paths in a Binary Tree
    int count = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        pseudoPalindromicPathsHelper(root, new int[10]);
        return count;
    }

    public void pseudoPalindromicPathsHelper(TreeNode root, int[] arr) {
        if (root == null) return;
        arr[root.val]++;
        pseudoPalindromicPathsHelper(root.left, arr);
        pseudoPalindromicPathsHelper(root.right, arr);
        if (root.left == null && root.right == null) {
            int odds = 0;
            for (int i : arr)
                if (i % 2 != 0) odds++;
            if (odds == 1 || odds == 0) count++;
        }
        arr[root.val]--;
    }

    // Flatten Binary Tree to Linked List
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode rightSubtree = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode current = root;
        while (current.right != null) current = current.right;
        current.right = rightSubtree;
    }
}
