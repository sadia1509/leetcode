package com.coding;

import common.*;
import dsa.algorithm.*;
import dsa.datastructure.linear.*;
import dsa.datastructure.nonlinear.*;

public class DSA {
    public static void run() {
        /* Trial */


        /* LINEAR */
        Array array = new Array();
//        Object [] arr = new Object[]{1,2,3,4,5};
//        array.leftShift(arr, 3);
//        array.rightShift(arr, 3);

        LinkedList linkedList = new LinkedList();
//        Node head = Node.getSinglyList(new Object[]{10,4,5,3,6});
//        linkedList.printSinglyList(head);
//        head = Node.getDoublyList(new Object[]{10,4,5,3,6});
//        linkedList.printDoublyList(head);
//        head = Node.getSinglyCircularList(new Object[]{10,4,5,3,6});
//        linkedList.printSinglyCircularList(head);
//        head = Node.getDoublyCircularList(new Object[]{10,4,5,3,6});
//        linkedList.printDoublyCircularList(head);
//        linkedList.insert(head, 100, 5);
//        linkedList.insert(head, 100);
//        Logs.print(linkedList.lastNode(head).data);
//        linkedList.delete(head, 4);
//        linkedList.delete(head, 100);
//        Logs.println("Total count: " + linkedList.count(head));
//        Logs.println("Is circular: " + linkedList.isCircular(head));

//        linkedList.rotateLinkedList(linkedList.makeDoublyLinkedList(new int[]{1,2,3,4,5}),3);
//        linkedList.removeDuplicate(linkedList.makeDoublyLinkedList(new int[]{1,2,3,2,2,4,2,2,4,4,5}));
//        linkedList.insertInSortedDoubly(linkedList.makeDoublyLinkedList(new int[]{2,4,5,6,8,9}), 11);
//        linkedList.pairSum(linkedList.makeDoublyLinkedList(new int[]{1,2,4,5,6,8,9}), 7);
//        linkedList.deletionCircular(linkedList.makeCircularLinkedList(new int[]{1,2,3,4,5,6}), 6);
//        linkedList.splitInHalves(linkedList.makeCircularLinkedList(new int[]{1,2,3,4,5,6}));
//        linkedList.intersectionTwoLinkedList(linkedList.makeLinkedList(new int[]{4,5}), linkedList.makeLinkedList(new int[]{1,2,4,5,6}));
//        linkedList.removeDuplicates(linkedList.makeLinkedList(new int[]{1,2,4}));
//        linkedList.detectLoopLength(linkedList.circleLinkedList());
//        linkedList.detectLoop(linkedList.circleLinkedList());
//        linkedList.deleteNodeDoubly(linkedList.makeDoublyLinkedList(new int[]{5, 4, 3, 2, 1}), linkedList.makeLinkedList(new int[]{1}));
//        linkedList.circularLinkedListTraversal(linkedList.makeCircularLinkedList(new int[]{5, 4, 3, 2, 1}));
//        linkedList.sizeOfDoubly(linkedList.makeDoublyLinkedList(new int[]{5, 4, 3, 2, 1}));
//        linkedList.reverseDoublyLinkedList(linkedList.makeDoublyLinkedList(new int[]{5, 4, 3, 2, 1}));
//        linkedList.exchangeFirstLast(linkedList.makeCircularLinkedList(new int[]{5, 4, 3, 2, 1}));
//        linkedList.convertToCircular(linkedList.makeLinkedList(new int[]{9, 1, 2, 10, 3, 7}));
//        linkedList.countCircularNodes(linkedList.makeCircularLinkedList(new int[]{9, 1, 2, 10, 3, 7}));
//        linkedList.circularLinkedListCheck(linkedList.makeLinkedList(new int[]{1, 1, 2, 10, 3, 7}));
//        linkedList.circularLinkedListCheck(linkedList.makeCircularLinkedList(new int[]{1, 1, 2, 10, 3, 7}));
//        linkedList.elemCount(linkedList.makeLinkedList(new int[]{1, 1, 2, 10, 3, 7, 1}), 1);
//        linkedList.middlePrint(linkedList.makeLinkedList(new int[]{1, 1, 2, 10, 3, 7}));

        Search search = new Search();
//        Logs.println("Binary Search: " + search.binarySearch(new int[]{2, 5, 6, 8, 9, 10}, 0, 5, 6));
//        Logs.println("Linear 2D Search: " + search.linerSearch2D(new String[][]{{"hay", "hay"}, {"hay", "hay"},
//                {"hay", "hay"}, {"hay", "hay"}, {"needle", "hay"}, {"hay", "hay"}}, "needle"));
//        Logs.println("Linear Search: " + search.linearSearch(new int[]{2, 3, 4, 10, 40}, 10));
//        Logs.println("TreeNode Search: " + search.searchInTree(TreeNode.getIntTree(new int[]{2, 3, 4, 10, 40},0), 10));
//        Logs.println("Binary Search TreeNode (BST) Search: " + search.searchInBST(TreeNode.getBSTTree(new int[]{2, 3, 4, 10, 40}), 40));

        Sort sort = new Sort();
//        Logs.print("Bubble sort: ");
//        sort.bubbleSort(new Integer[] {2,3,4,1,4,9,5,7});
//        Logs.print("Selection sort: ");
//        sort.selectionSort(new Integer[] {2,3,4,1,4,9,5,7});
//        Logs.print("Insertion sort: ");
//        sort.insertionSort(new Integer[] {2,3,4,1,4,9,5,7});
//        Logs.print("Quick sort: ");
//        sort.quickSort(new Integer[] {2,3,4,1,4,9,5,7});
//        Logs.print("Merge sort: ");
//        sort.mergeSort(new Integer[] {2,3,4,1,4,9,5,7});



        /* NON-LINEAR */
        TreeClass treeClass = new TreeClass();
//        TreeNode root = TreeNode.getTree(new Object[]{1, 2, 30, 40, 5, 6}, 0);
//        TreeNode subRoot = TreeNode.getTree(new Object[]{30, 40, 700}, 0);
//        TreeNode randomNode = treeClass.treeNode(root, 6);
//        TreeNode rootBST = TreeNode.getBSTTree(new int[]{40, 3, 1, 10, 2});
//        Logs.print("Checking BST: ");
//        treeClass.inOrderTraversal(rootBST);
//        Logs.lineBreak(1);
//        Logs.print("Preorder Traversal: ");
//        treeClass.preOrderTraversal(root);
//        Logs.lineBreak(1);
//        Logs.print("Inorder Traversal: ");
//        treeClass.inOrderTraversal(root);
//        Logs.lineBreak(1);
//        Logs.print("Postorder Traversal: ");
//        treeClass.postOrderTraversal(root);
//        Logs.lineBreak(1);
//        Logs.print("Level order Traversal: ");
//        treeClass.levelOrderTraversal(root);
//        Logs.lineBreak(1);
//
//        Logs.println("Get the node address from a tree: " + treeClass.treeNode(root, 5));
//        Logs.println("Get total count of a tree: " + treeClass.totalNodeCount(root));
//        Logs.println("Max height/depth of a tree: " + treeClass.maxDepthOrHeight(root));
//        Logs.println("Depth of a current node from a tree: " + treeClass.depth(root, randomNode, 0));
//        Logs.println("Level of a current node from a tree: " + treeClass.level(root, randomNode));
//        Logs.println("Height of a current node from a tree: " + treeClass.height(root.right));
//        Logs.println("Sum of a current node from a tree: " + treeClass.sum(root));
//        Logs.println("Find parent in a tree: " + treeClass.findParent(root, randomNode));
//        Logs.println("Is these two nodes are cousin in a tree: " + treeClass.isCousin(root, root.left.left, root.right.left));
//        Logs.println("Is the tree divisible in 2 halves: " + treeClass.isDivisibleByTwoHalves(root));
//        Logs.println("Is the tree perfect binary tree: " + treeClass.isPerfectBinary(root));
//        Logs.println("Is the tree a subtree of another tree: " + treeClass.isSubTree(root, subRoot));


    }
}
