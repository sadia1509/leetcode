package common;

public class TreeNode {
    public Object value;
    public int val;
    public TreeNode left, right;

    public TreeNode(Object value) {
        this.value = value;
    }

    public TreeNode(int val) {
        this.val = val;
        this.value = val;
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

    // Making a Binary Search TreeNode from array (Sorted)
    public static TreeNode getBSTTreeSorted(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return buildBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (right + left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }

    // Making a Binary Search TreeNode from array (Unsorted)
    public static TreeNode getBSTTree(int[] arr) {
        TreeNode root = null;
        for (int i : arr) root = insertNodeBST(root, i);
        return root;
    }

    private static TreeNode insertNodeBST(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        else if (value < root.val) root.left = insertNodeBST(root.left, value);
        else root.right = insertNodeBST(root.right, value);
        return root;
    }

}
