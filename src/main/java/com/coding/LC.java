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
//        Utils.Integer().printArray(treeProblems.findMode(root));
    }
}
