package leetcode.medium;

import java.math.BigInteger;
import java.util.HashMap;

public class StringProblems {
    // Multiply Strings
    public String multiply(String num1, String num2) {
        BigInteger num1B = new BigInteger(num1);
        BigInteger num2B = new BigInteger(num2);
        return num1B.multiply(num2B).toString();
    }

    // Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;
        if (len == 1) return 1;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < len; end++) {
            char currentChar = s.charAt(end);
            if (map.containsKey(currentChar)) start = Math.max(map.get(currentChar) + 1, start);
            map.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    // Count Number of Homogenous Substrings
    public int countHomogenous(String s) {
        if (s.isEmpty()) return 0;
        final int MOD = 1000000007;
        int sum = 0, counter = 1;
        char prev = ' ', temp = ' ';
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (prev == temp) counter++;
            else {
                counter = 1;
                prev = temp;
            }
            counter %= MOD;
            sum += counter;
            sum %= MOD;
        }
        return sum;
    }
}
