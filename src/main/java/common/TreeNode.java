package common;

public class TreeNode {
    public Object value;
    public TreeNode left, right;

    public TreeNode(Object value) {
        this.value = value;
    }

    public TreeNode(Object value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    // Making a regular TreeNode from array
    public static TreeNode getTree(Object[] arr, int index) {
        if (index >= arr.length || arr[index] == null) return null;
        TreeNode root = new TreeNode(arr[index]);
        root.left = getTree(arr, index * 2 + 1);
        root.right = getTree(arr, index * 2 + 2);
        return root;
    }

    // Making a regular int type TreeNode from array
    public static TreeNode getIntTree(int[] arr, int index) {
        if (index >= arr.length || arr[index] == -1) return null;
        TreeNode root = new TreeNode(arr[index]);
        root.left = getIntTree(arr, index * 2 + 1);
        root.right = getIntTree(arr, index * 2 + 2);
        return root;
    }

    // Making a Binary Search TreeNode from array
    public static TreeNode getBSTTree(int[] arr) {
        TreeNode root = null;
        for (int i : arr) root = insertNodeBST(root, i);
        return root;
    }

    private static TreeNode insertNodeBST(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        else if (value < (int) root.value) root.left = insertNodeBST(root.left, value);
        else root.right = insertNodeBST(root.right, value);
        return root;
    }

}
