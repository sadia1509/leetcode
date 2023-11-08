package leetcode.easy;

import java.util.*;

public class RecursiveProblems {
    //Power of Two
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    //Power of Three
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;

        while (n % 3 == 0) n /= 3;

        return n == 1;
    }

    // fibonacci
    public long fibonacci(int n, List<Long> mem){
        if(mem.size() > n && mem.get(n) != null) return mem.get(n);
        if(n<2) return n;
        mem.add(n, fibonacci(n-1, mem) + fibonacci(n-2, mem));
        return mem.get(n);
    }

    // factorial
    public int factorial(int n){
        if(n==1) return 1;
        else return factorial(n-1) * n ;
    }
}
