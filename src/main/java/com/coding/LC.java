package com.coding;

import common.*;
import dsa.datastructure.nonlinear.TreeClass;
import leetcode.easy.*;

public class LC {
    public static void run() {
        /* List */
        ListProblems listProblems = new ListProblems();
        ListNode head = ListNode.getSinglyList(new Object[]{1, 2, 3, 4, 5, 4});
//        head = ListNode.getSinglyCircularList(new Object[]{1, 2, 3, 4, 5});
//        Logs.println("Middle node: " + listProblems.middleNode(head));
//        Logs.println("Has cycle: " + listProblems.hasCycle(null));


        /* String */
        StringProblems stringProblems = new StringProblems();
//        Logs.println("Minimizing word length: " + stringProblems.minimizedStringLength(""));


        /* Tree */
        TreeProblems treeProblems = new TreeProblems();
        TreeClass treeClass = new TreeClass();
//        TreeNode root = TreeNode.getBSTTree(new int[]{1, 2, 2, 2, 5, 6, 6, 6, 6, 10});
        TreeNode root = TreeNode.getIntTree(new int[]{5,4,8,11,-1,13,4,7,2,-1,-1,-1,1}, 0);
//        Utils.Integer().printArray(treeProblems.findMode(root));
//        Logs.println("Same tree: " + treeProblems.isSameTree(root, rootAnother));
//        Logs.println("Mirror tree: " + treeProblems.isSymmetric(root));
//        Logs.println("Balanced tree: " + treeProblems.isBalanced(root));
//        Logs.println("Minimum depth of a tree: " + treeProblems.minDepth(root));
        Logs.println("Path sum of a tree: " + treeProblems.hasPathSum(root, 22));
//        Logs.print("BST: ");
//        treeProblems.temp(new int[]{-10, -3, 0, 5, 9});



        /* Array */
        ArrayProblems arrayProblems = new ArrayProblems();
//        int [] arr = {2,1,2,2,3,0,0,2};
//        Logs.println("Remove element: " + arrayProblems.removeElement(arr, 2));

    }
}
