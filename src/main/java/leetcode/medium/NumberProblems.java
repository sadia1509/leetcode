package leetcode.medium;

import common.*;
import java.util.*;

public class NumberProblems {
    //Reverse Integer
    public int reverse(int x) { //-12300   12
        int sign = 1;
        if (x < 0) sign = -1;
        StringBuilder sb = new StringBuilder();
        sb.append(sign * x);
        sb.reverse();
        try {
            return sign * Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    //Pow(x, n)
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;

        double result = 1.0;
        long finalN = Math.abs((long) n);

        while (finalN > 0) {
            if (finalN % 2 == 1) result *= x;
            x *= x;
            finalN /= 2;
        }
        return n < 0 ? (1 / result) : result;
    }

    // Determine if a Cell Is Reachable at a Given Time
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy && t == 1) return false;
        return Math.max(Math.abs(sx - fx), Math.abs(sy - fy)) <= t;
    }

    // Divide Two Integers
    public int divide(int dividend, int divisor) {
        int res = dividend / divisor;
        if (dividend < 0 && divisor < 0 && res == Integer.MIN_VALUE) res = Integer.MAX_VALUE;
        return res;
    }

    // Combinations
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new LinkedList<>();
        combine(1, n, k, list, new Stack<>());
        return list;
    }

    private void combine(int start, int n, int k, List<List<Integer>> list, Stack<Integer> temp) {
        if (k == 0) {
            list.add(new LinkedList<>(temp));
            return;
        }
        if (start > n) return;
        temp.push(start);
        combine(start + 1, n, k - 1, list, temp);
        temp.pop();
        combine(start + 1, n, k, list, temp);
    }

    // Strictly Palindromic Number
    public boolean isStrictlyPalindromic(int n) {
        for (int i=2; i<=n-1; i++){
            String str = base(i, n);
            if(!Utils.isPalindrome(str)) return false;
        }
        return true;
    }

    private String base(int i, int n) {
        StringBuilder sb = new StringBuilder();
        while (n!=0){
            sb.append(n%i);
            n /= i;
        }
        return sb.toString();
    }
}
