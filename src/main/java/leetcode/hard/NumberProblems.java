package leetcode.hard;

public class NumberProblems {
    public int findIntegers(int n) {
        String s = Integer.toBinaryString(n + 1);
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < len; i++) dp[i] = dp[i - 1] + dp[i - 2];

        int flag = 0, ans = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') continue;
            if (flag == 1) break;
            if (i > 0 && s.charAt(i - 1) == '1') flag = 1;
            ans += dp[len - i - 1];
        }
        return ans;
    }
}
