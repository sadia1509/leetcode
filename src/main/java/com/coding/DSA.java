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
//        ListNode head = null;
//        head = ListNode.getSinglyList(new Object[]{7,7});
//        linkedList.printSinglyList(head);
//        head = ListNode.getDoublyList(new Object[]{10,4,5,3,6});
//        linkedList.printDoublyList(head);
//        head = ListNode.getSinglyCircularList(new Object[]{10,4,5,3,6});
//        linkedList.printSinglyCircularList(head);
//        head = ListNode.getDoublyCircularList(new Object[]{10,4,5,3,6});
//        linkedList.printDoublyCircularList(head);
//        linkedList.insert(head, 100, 6);
//        linkedList.insert(head, 100);
//        Logs.print(linkedList.lastNode(head).data);
//        linkedList.delete(head, 4);
//        linkedList.delete(head, 100);
//        Logs.print(linkedList.get(head,  4));
//        linkedList.insertDoubly(head, 100, 5);
//        linkedList.insertDoubly(head, 100);
//        linkedList.deleteDoubly(head, 5);
//        Logs.println("Total count: " + linkedList.count(head));
//        Logs.println("Is circular: " + linkedList.isCircular(head));
//        Logs.println("Reverse: ");  linkedList.reverseList(head);
//        Logs.println("Remove value: ");
//        linkedList.removeElements(head, 7);


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


        GraphClass graphClass = new GraphClass();

        ShortestPath shortestPath = new ShortestPath();
//        UndirectedGraph weightedGraph = new UndirectedGraph(true);
//        DirectedGraph weightedGraph = new DirectedGraph(true);
//        weightedGraph.addEdge(0, 1, 3);
//        weightedGraph.addEdge(0, 2, 2);
//        weightedGraph.addEdge(1, 2, 5);
//        weightedGraph.addEdge(1, 3, 7);
//        weightedGraph.addEdge(2, 4, 1);
//        weightedGraph.addEdge(3, 4, 4);
//        weightedGraph.addEdge(4, 5, 2);
//        shortestPath.dijkstra(weightedGraph.getWeightedGraph(), 0, 5);
//        shortestPath.bellmanFord(weightedGraph.getWeightedGraph(), new int[]{0,1,2,3,4,5}, 0);
//        shortestPath.floydWarshall(graphClass.to2DArray(weightedGraph.getWeightedGraph(), new int[]{0, 1, 2, 3, 4, 5}));
    }
}