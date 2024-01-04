package leetcode.medium;

import common.*;

import java.util.*;

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
;
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

}
