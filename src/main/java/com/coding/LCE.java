package com.coding;

import common.*;
import dsa.datastructure.nonlinear.*;
import leetcode.easy.*;

public class LCE {
    public static void run() {
        /* List */
        ListProblems listProblems = new ListProblems();
//        ListNode head = ListNode.getSinglyList(new Object[]{1, 1, 3, 2, 1});
//        head = ListNode.getSinglyCircularList(new Object[]{1, 2, 3, 4, 5});
//        Logs.println("Middle node: " + listProblems.middleNode(head));
//        Logs.println("Has cycle: " + listProblems.hasCycle(null));
//        Logs.println("is Palindrome: " + listProblems.isPalindrome(head));


        /* Stack */
        StackProblems stackProblems = new StackProblems();
//        Logs.println("Queue: "); stackProblems.queueUsingStack();

        /* String */
        StringProblems stringProblems = new StringProblems();
//        Logs.println("Minimizing word length: " + stringProblems.minimizedStringLength(""));
//        Logs.println("Ransom note: " + stringProblems.canConstruct("baa", "aab"));
//        Logs.println("First unique char: " + stringProblems.firstUniqueChar("aabb"));
//        Logs.println("Difference: " + stringProblems.findTheDifference("abcd", "abcdw"));
//        Logs.println("Add strings: " + stringProblems.addStrings("3876620623801494171", "6529364523802684779"));
//        Logs.println("Percentage: " + stringProblems.percentageLetter("foobar", 'o'));
//        Logs.println("Segments: " + stringProblems.countSegments("Hello, my name is John"));
//        Logs.println("Split in equal: " + stringProblems.balancedStringSplit("RLRRRLLRLL"));
//        Logs.println("DI string match: " + stringProblems.diStringMatch("IDID"));

        /* Number */
        NumberProblems numberProblems = new NumberProblems();
//        Logs.println("Add digits: " + numberProblems.addDigits(101));
//        Logs.println("Is ugly: " + numberProblems.isUgly(1));
//        Logs.println("Is perfect square: " + numberProblems.isPerfectSquare(16));
//        Logs.println("Third max: " + numberProblems.thirdMax(new int[]{1,2,-2147483648}));
//        Logs.println("Perfect number: " + numberProblems.checkPerfectNumber(28));
//        Logs.println("Min sum of 4 digits: " + numberProblems.minimumSum(2932));
//        Logs.println("Max 69: " + numberProblems.maximum69Number(6995));


        /* Recursion */
        RecursiveProblems recursiveProblems = new RecursiveProblems();
//        Logs.println("Pow of 2: " + recursiveProblems.isPowerOfTwo(16));
//        Logs.println("Pow of 3: " + recursiveProblems.isPowerOfThree(9));


        /* Tree */
        TreeProblems treeProblems = new TreeProblems();
//        TreeClass treeClass = new TreeClass();
//        TreeNode root = TreeNode.getBSTTree(new int[]{8,3,1,2,6,3});
//        TreeNode root = TreeNode.getIntTree(new int[]{1, 3, 2, 5}, 0);
//        TreeNode rootClone = TreeNode.getIntTree(new int[]{2, 1, 3, -1, 4, -1, 7}, 0);
//        Utils.Integer().printArray(treeProblems.findMode(root));
//        Logs.println("Same tree: " + treeProblems.isSameTree(root, rootAnother));
//        Logs.println("Mirror tree: " + treeProblems.isSymmetric(root));
//        Logs.println("Balanced tree: " + treeProblems.isBalanced(root));
//        Logs.println("Minimum depth of a tree: " + treeProblems.minDepth(root));
//        Logs.println("Path sum of a tree: " + treeProblems.hasPathSum(root, 22));
//        Logs.print("Inverted tree: "); treeClass.levelOrderTraversal(treeProblems.invertTree(root));
//        Logs.println("Paths of a tree: " + treeProblems.binaryTreePaths(root));
//        Logs.println("Sum of the leaves: " + treeProblems.sumOfLeftLeaves(root));
//        Logs.println("Sum of within range: " + treeProblems.rangeSumBST(root, 7, 15));
//        Logs.println("Find target in a clone: " + treeProblems.getTargetCopy(root, rootClone, root.right));


        /* Array */
        ArrayProblems arrayProblems = new ArrayProblems();
//        int [] arr = {2,1,2,2,3,0,0,2};
//        Logs.println("Remove element: " + arrayProblems.removeElement(arr, 2));
//        Logs.println("Reverse a string: "); arrayProblems.reverseString(new Character[]{'h','e','l','l','o'});
//        Logs.println("Counting bits: "); arrayProblems.countBits(5);
//        Logs.println("Reverse vowels only: " + arrayProblems.reverseVowels("Euston saw I was not Sue."));
//        arrayProblems.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4}, 1);
//        Logs.println("Intersect: "); arrayProblems.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});
//        Logs.println("Contains duplicates ||: " + arrayProblems.containsNearbyDuplicate(new int[]{1,1,0,2,3,1}, 1));
//        Logs.println("Contains duplicates: " + arrayProblems.containsDuplicate(new int[]{1,1,0,2,3,1}));
//        Logs.println("Summary ranges: " + arrayProblems.summaryRanges(new int[]{0,2,3,4,6,8,9}));
//        Logs.println("3 sum: " + arrayProblems.threeSum(new int[]{-1,0,1,2,-1,-4}));
//        Logs.println("Missing number: " + arrayProblems.missingNumber(new int[]{1}));
//        Logs.println("Move zeros: " ); arrayProblems.moveZeroes(new int[]{0,1,0,3,12});
//        Logs.println("Discount: " ); arrayProblems.finalPrices(new Integer[]{4,7,1,9,4,8,8,9,4});
//        Logs.println("Next greater num: "); arrayProblems.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 2, 3, 4});
//        Logs.println("Array partition: " + arrayProblems.arrayPairSum(new int[]{6,2,6,5,1,2}));
//        Logs.println("Max sum: " + arrayProblems.maximizeSum(new int[]{1,2,3,4,5},3));
//        Logs.println("Min operation for increasing: " + arrayProblems.minOperations(new int[]{1,5,2,4,1}));
    }
}
