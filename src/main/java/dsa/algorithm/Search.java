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

    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) return binarySearch(arr, left, mid - 1, target);
        else return binarySearch(arr, mid + 1, right, target);
    }

    public boolean searchInTree(TreeNode root, Object elem) {
        if (root == null) return false;
        if (root.value == elem || searchInTree(root.left, elem) || searchInTree(root.right, elem))
            return true;
        return false;
    }

    public boolean searchInBST(TreeNode root, int elem) {
        if (root == null) return false;
        if ((int) root.value == elem) return true;
        else if (elem < (int) root.value) return searchInBST(root.left, elem);
        else return searchInBST(root.right, elem);
    }
}
