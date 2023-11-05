package leetcode.easy;

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

}
