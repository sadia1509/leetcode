package dsa.datastructure.nonlinear;

import common.*;

import java.util.LinkedList;
import java.util.Queue;

public class TreeClass {
    // Preorder Traversal (root, left, right)
    public void preOrderTraversal(TreeNode root) {
        if (root != null) {
            Logs.print(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    // Inorder Traversal (left, root, right)
    public void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            Logs.print(root.value + " ");
            inOrderTraversal(root.right);
        }
    }

    // Postorder Traversal (left, right, root)
    public void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            Logs.print(root.value + " ");
        }
    }

    // level based BFS
    public void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) continue;
            Logs.print(node.value + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    // Get the address of a specific value
    public TreeNode treeNode(TreeNode root, Object value) {
        if (root == null) return null;
        if (root.value == value) return root;
        TreeNode node = treeNode(root.left, value);
        if (node != null) return node;
        return treeNode(root.right, value);
    }

    // Get the total node count
    public int totalNodeCount(TreeNode root) {
        if (root == null) return 0;
        return totalNodeCount(root.left) + totalNodeCount(root.right) + 1;
    }

    // Max depth or Max height
    public int maxDepthOrHeight(TreeNode root) {
        return root == null ? 0 :
                Math.max(maxDepthOrHeight(root.left), maxDepthOrHeight(root.right)) + 1;
    }

    // Get the current node's depth
    public int depth(TreeNode root, TreeNode node, int currentDepth) {
        int depth = -1;
        if (root != null && node != null) {
            if (root.value == node.value) return currentDepth;
            depth = depth(root.left, node, currentDepth + 1);
            if (depth != -1) return depth;
            depth = depth(root.right, node, currentDepth + 1);
        }
        return depth;
    }

    // Get the current node's depth
    public int level(TreeNode root, TreeNode node) {
        return depth(root, node, 0) + 1;
    }

    // Get the current node's height
    public int height(TreeNode root) {
        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }

    // Sum of the entire int tree
    public int sum(TreeNode node) {
        return node == null ? 0 : (sum(node.left) + node.val + sum(node.right));
    }

    // Two nodes are cousin of not
    public boolean isCousin(TreeNode root, TreeNode node1, TreeNode node2) {
        return (depth(root, node1, 0) == depth(root, node2, 0)
                && findParent(root, node1) != findParent(root, node2));
    }

    public TreeNode findParent(TreeNode root, TreeNode child) {
        TreeNode node = null;
        if (root != null) {
            if (root.left == child || root.right == child) return root;
            node = findParent(root.left, child);
            if (node != null) return node;
            node = findParent(root.right, child);
        }
        return node;
    }

    //Check if removing an edge can divide a Binary TreeNode in two halves
    public boolean isDivisibleByTwoHalves(TreeNode root) {
        int leftSize = totalNodeCount(root.left);
        int rightSize = totalNodeCount(root.right);
        return (leftSize == rightSize + 1 || rightSize == leftSize + 1);
    }

    //Check whether a given binary tree is perfect or not
    public boolean isPerfectBinary(TreeNode root) {
        int limit = maxDepthOrHeight(root), totalNodes = 0;
        for (int i = 0; i < limit; i++) totalNodes += Math.pow(2, i);
        return (totalNodes == totalNodeCount(root));
    }

    // Subtree of another tree?
    boolean isSimilar(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.value == subRoot.value)
            return isSimilar(root.left, subRoot.left) && isSimilar(root.right, subRoot.right);
        return false;
    }

    public boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (root.value == subRoot.value)
            if (isSimilar(root, subRoot)) return true;
        return isSubTree(root.left, subRoot.right) || isSubTree(root.right, subRoot.right);
    }

    // TODO diameter
}
