package com.coding;

import common.*;
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
//        TreeNode root = TreeNode.getBSTTree(new int[]{1, 2, 2, 2, 5, 6, 6, 6, 6, 10});
        TreeNode root = TreeNode.getIntTree(new int[]{1, 2, 2, 3, 4, 4, 3}, 0);
//        Utils.Integer().printArray(treeProblems.findMode(root));
//        Logs.println("Same tree: " + treeProblems.isSameTree(root, rootAnother));
//        Logs.println("Mirror tree: " + treeProblems.isSymmetric(root));
        Logs.print("BST: ");
        treeProblems.temp(new int[]{-10, -3, 0, 5, 9});



        /* Array */
        ArrayProblems arrayProblems = new ArrayProblems();
//        int [] arr = {2,1,2,2,3,0,0,2};
//        Logs.println("Remove element: " + arrayProblems.removeElement(arr, 2));

    }
}
