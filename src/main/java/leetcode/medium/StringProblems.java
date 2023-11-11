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

    // Longest Palindromic Substring
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) return s;
        int maxLen = 0, start = 0;
        char[] sCharArray = s.toCharArray();
        for (int i = 0; i < len; i++) {
            int[] arr = isPalindrome(sCharArray, i, i, maxLen, start);
            maxLen = arr[0];
            start = arr[1];
            arr = isPalindrome(sCharArray, i, i + 1, maxLen, start);
            maxLen = arr[0];
            start = arr[1];
        }
        return s.substring(start, start + maxLen);
    }

    private int[] isPalindrome(char[] s, int j, int k, int maxLen, int start) {
        while (j >= 0 && k < s.length && s[j] == s[k]) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            maxLen = k - j - 1;
            start = j + 1;
        }
        return new int[]{maxLen, start};
    }

}
