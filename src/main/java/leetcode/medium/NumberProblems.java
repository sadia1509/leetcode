package leetcode.medium;

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
}
