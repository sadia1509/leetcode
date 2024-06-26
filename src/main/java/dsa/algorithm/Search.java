package dsa.algorithm;

import common.*;

public class Search {
    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (target == arr[i]) return i;
        return -1;
    }

    public int linerSearch2D(String[][] arr, String target) {
        for (String[] row : arr)
            for (String elem : row)
                if (elem.equals(target)) return 1;
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        return binarySearch(arr, 0, arr.length - 1, target);
    }

    private static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) return binarySearch(arr, left, mid - 1, target);
        else return binarySearch(arr, mid + 1, right, target);
    }

    public int[] binarySearch2D(int[][] arr, int target) {
        int r = 0, c = arr.length - 1;
        while (r < arr.length && c >= 0) {
            if (arr[r][c] == target) return new int[]{r, c};
            else if (arr[r][c] > target) c--;
            else r++;
        }
        return new int[]{-1, -1};
    }

    public boolean searchInTree(TreeNode root, Object elem) {
        if (root == null) return false;
        if (root.value == elem || searchInTree(root.left, elem) || searchInTree(root.right, elem))
            return true;
        return false;
    }

    public boolean searchInBST(TreeNode root, int elem) {
        if (root == null) return false;
        if (root.val == elem) return true;
        else if (elem < root.val) return searchInBST(root.left, elem);
        else return searchInBST(root.right, elem);
    }
}
