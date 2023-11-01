package leetcode.easy;

import common.*;

import java.util.*;

public class TreeProblems {
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
}
