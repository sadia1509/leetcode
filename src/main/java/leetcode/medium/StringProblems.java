package leetcode.medium;

import java.math.BigInteger;
import java.util.*;

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

    // String to Integer (atoi)
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;
        s = s.trim();
        int i = 0, sign = 1, num = 0, len = s.length();
        while (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            if (i > 0) return num;
            i++;
        }
        while (i < len && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            try {
                num = Math.multiplyExact(num, 10);
                num = Math.addExact(num, digit);
            } catch (ArithmeticException e) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }
        return sign * num;
    }

    // Sort Vowels in a String
    public String sortVowels(String s) {
        List<Character> vowels = List.of('A', 'E', 'O', 'I', 'U', 'a', 'e', 'o', 'i', 'u');
        Map<Character, Integer> tempVowels = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowels.contains(c)) tempVowels.compute(c, (key, oldValue) -> (oldValue == null) ? 1 : oldValue + 1);
        }
        List<Character> tempV = new LinkedList<>(tempVowels.keySet());
        if (tempV.isEmpty()) return s;
        StringBuilder sb = new StringBuilder();
        char tempChar = tempV.get(0);
        for (int i = 0, k = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                int count = tempVowels.get(tempChar);
                if (count == 0) {
                    tempChar = tempV.get(++k);
                    count = tempVowels.get(tempChar);
                }
                sb.append(tempChar);
                tempVowels.put(tempChar, count - 1);
            } else sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // Find Unique Binary String
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        if (n == 0) return "";
        int num = (int) Math.pow(2, n) - 1;
        int[] intNums = new int[n];
        int k = 0;
        for (String i : nums) intNums[k++] = Integer.parseInt(i, 2);
        Arrays.sort(intNums);
        for (int i = n - 1; i >= 0; i--) if (num == intNums[i]) num--;
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(num));
        int numLength = sb.length();
        while (numLength++ < n) sb.insert(0, '0');
        return sb.toString();
    }

    // Optimal Partition of String
    public int partitionString(String s) {
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        int current = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (lastSeen[s.charAt(i) - 'a'] >= current) {
                count++;
                current = i;
            }
            lastSeen[s.charAt(i) - 'a'] = i;
        }
        return ++count;
    }

    // Generate Parentheses
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        generateParenthesis(n, 0, 0, list, new StringBuilder());
        return list;
    }

    private void generateParenthesis(int n, int open, int close, List<String> list, StringBuilder sb) {
        if (n == open && n == close) {
            list.add(sb.toString());
            sb = new StringBuilder();
        }
        if (open < n) {
            sb.append('(');
            generateParenthesis(n, open + 1, close, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            generateParenthesis(n, open, close + 1, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // Group Anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String tempStr = new String(temp);
            if (map.containsKey(tempStr)) map.get(tempStr).add(str);
            else {
                List<String> newList = new LinkedList<>();
                newList.add(str);
                map.put(tempStr, newList);
            }
        }
        return new LinkedList<>(map.values());
    }

    // Evaluate Reverse Polish Notation
    public int evalRPN(String[] tokens) {
        Set<String> set = Set.of("+", "-", "/", "*");
        Stack<String> stack = new Stack<>();
        for (String str : tokens) {
            if (set.contains(str)) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                evalRPN(a, b, str, stack);
            } else stack.push(str);
        }
        return Integer.parseInt(stack.pop());
    }

    private void evalRPN(int a, int b, String operator, Stack<String> stack) {
        switch (operator) {
            case "+":
                stack.push(String.valueOf(a + b));
                break;
            case "-":
                stack.push(String.valueOf(b - a));
                break;
            case "*":
                stack.push(String.valueOf(a * b));
                break;
            case "/":
                stack.push(String.valueOf(b / a));
                break;
        }
    }

    // Encode and Decode TinyURL
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        return Base64.getEncoder().encodeToString(longUrl.getBytes());
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return new String(Base64.getDecoder().decode(shortUrl));
    }


}
