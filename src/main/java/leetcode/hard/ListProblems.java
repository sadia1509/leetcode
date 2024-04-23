package leetcode.hard;

import common.*;

import java.util.*;

public class ListProblems {
    // Reverse Nodes in k-Group
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int count = 0;
        ListNode c = head;
        while (c != null) {
            count++;
            c = c.next;
        }
        count = count / k;
        ListNode[] hlr = reverseKGroupHelper(head, k);
        head = hlr[0];
        ListNode n = hlr[2], temp = hlr[1];
        while (count-- != 1) {
            hlr = reverseKGroupHelper(n, k);
            if (hlr.length == 0) break;
            temp.next = hlr[0];
            n = hlr[2];
            temp = hlr[1];
        }
        return head;
    }

    private ListNode[] reverseKGroupHelper(ListNode head, int k) {
        if (head == null || k == 0) return new ListNode[]{};
        ListNode n = head, prev = null;
        while (n != null) {
            if (k-- == 0) break;
            ListNode next = n.next;
            n.next = prev;
            prev = n;
            n = next;
        }
        head.next = n;
        return new ListNode[]{prev, head, n};
    }

    // Merge k Sorted Lists
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode tempHead;
        if (len == 0) return null;
        else tempHead = lists[0];
        for (int i = 1; i < len; i++)
            tempHead = merge(tempHead, lists[i]);

        return tempHead;
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null && right == null) return null;
        ListNode nl = left, ml = right, head;
        if (left == null) {
            head = new ListNode(ml.data);
            ml = ml.next;
        } else if (right == null) {
            head = new ListNode(nl.data);
            nl = nl.next;
        } else {
            if ((int) nl.data > (int) ml.data) {
                head = new ListNode(ml.data);
                ml = ml.next;
            } else {
                head = new ListNode(nl.data);
                nl = nl.next;
            }
        }
        ListNode tail = head;
        while (nl != null && ml != null) {
            if ((int) nl.data > (int) ml.data) {
                tail.next = new ListNode(ml.data);
                ml = ml.next;
            } else {
                tail.next = new ListNode(nl.data);
                nl = nl.next;
            }
            tail = tail.next;
        }
        while (nl != null) {
            tail.next = new ListNode(nl.data);
            tail = tail.next;
            nl = nl.next;
        }
        while (ml != null) {
            tail.next = new ListNode(ml.data);
            tail = tail.next;
            ml = ml.next;
        }
        return head;
    }

    //  N-Queens
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> list = new ArrayList<>();
        solveNQueens(board, 0, list);
        return list;
    }

    private void solveNQueens(boolean[][] board, int row, List<List<String>> list) {
        if (row == board.length) {
            addToList(list, board);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                solveNQueens(board, row + 1, list);
                board[row][col] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int row, int col) {
        // vertical
        for (int i = 0; i < row; i++)
            if (board[i][col]) return false;
        // left diagonal
        int minLeft = Math.min(row, col);
        for (int i = 1; i <= minLeft; i++)
            if (board[row - i][col - i]) return false;
        // right diagonal
        int minRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= minRight; i++)
            if (board[row - i][col + i]) return false;
        return true;
    }

    private void addToList(List<List<String>> list, boolean[][] board) {
        List<String> innerList = new LinkedList<>();
        StringBuilder sb;
        for (boolean[] row : board) {
            sb = new StringBuilder();
            for (boolean elem : row) {
                if (elem) sb.append("Q");
                else sb.append(".");
            }
            innerList.add(sb.toString());
        }
        list.add(innerList);
    }

    // N-Queens II
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return totalNQueens(board, 0);
    }

    private int totalNQueens(boolean[][] board, int row) {
        if (row == board.length) return 1;
        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += totalNQueens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

}
