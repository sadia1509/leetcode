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

    // Longest Common Subsequence
    int[][] memo;
    int n, m;

    public int longestCommonSubsequence(String text1, String text2) {
        n = text1.length();
        m = text2.length();
        memo = new int[n][m];
        for (int[] row : memo) Arrays.fill(row, -1);
        return longestCommonSubsequence(text1, text2, 0, 0);
    }

    private int longestCommonSubsequence(String text1, String text2, int i, int j) {
        if (i >= n || j >= m) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        if (text1.charAt(i) == text2.charAt(j))
            return memo[i][j] = 1 + longestCommonSubsequence(text1, text2, i + 1, j + 1);
        return memo[i][j] = Math.max(longestCommonSubsequence(text1, text2, i + 1, j),
                longestCommonSubsequence(text1, text2, i, j + 1));
    }

    // Letter Combinations of a Phone Number
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        List<String> list = new LinkedList<>();
        Map<Character, String> map = Map.of('2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz");
        letterCombinations(0, digits, list, new StringBuilder(), map);
        return list;
    }

    private void letterCombinations(int i, String digits, List<String> list, StringBuilder sb, Map<Character, String> map) {
        if (i >= digits.length()) {
            list.add(sb.toString());
            return;
        }
        char num = digits.charAt(i);
        for (char ch : map.get(num).toCharArray()) {
            sb.append(ch);
            letterCombinations(i + 1, digits, list, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // Sort Characters By Frequency
    public String frequencySort(String s) {
        int[] letters = new int[62];
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) letters[c - '0' + 52]++;
            else if (c - 'a' < 0) letters[c - 'A' + 26]++;
            else letters[c - 'a']++;
        }
        List<Object[]> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                char ch = (char) ('a' + i);
                fillList(ch, letters[i], list);
            }
        }
        for (int i = 26; i < 52; i++) {
            if (letters[i] != 0) {
                char ch = (char) ('A' + i - 26);
                fillList(ch, letters[i], list);
            }
        }
        for (int i = 52; i < 62; i++) {
            if (letters[i] != 0) {
                char ch = (char) ('0' + i - 52);
                fillList(ch, letters[i], list);
            }
        }
        Collections.sort(list, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                Integer value1 = (Integer) o1[1];
                Integer value2 = (Integer) o2[1];
                return value2.compareTo(value1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Object[] ar : list)
            sb.append(String.valueOf(ar[0]).repeat(Math.max(0, (int) ar[1])));
        return sb.toString();
    }

    private void fillList(char ch, int freq, List<Object[]> list) {
        Object[] arr = new Object[2];
        arr[0] = ch;
        arr[1] = freq;
        list.add(arr);
    }

    // Make String a Subsequence Using Cyclic Increments
    public boolean canMakeSubsequence(String str1, String str2) {
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        int i = 0, j = 0, len2 = str2Arr.length, prev = -1;
        while (i < str1Arr.length && j < len2) {
            if (str1Arr[i] == str2Arr[j]) {
                i++;
                j++;
            } else if (prev == i) {
                i++;
            } else {
                if (str1Arr[i] == 'z') str1Arr[i] = 'a';
                else str1Arr[i]++;
                prev = i;
            }
        }
        return j == len2;
    }

    // Minimum Length of String After Deleting Similar Ends
    public int minimumLength(String s) { // 594
        int left = 0, right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            int cur = s.charAt(left);
            while (left <= right && s.charAt(left) == cur) left++;
            while (right >= left && s.charAt(right) == cur) right--;
        }
        return left <= right ? right - left + 1 : 0;
    }

    // Append Characters to String to Make Subsequence
    public int appendCharacters(String s, String t) {
        int j = 0;
        for (int i = 0; i < s.length() && j < t.length(); i++) {
            char sCh = s.charAt(i);
            char tCh = t.charAt(j);
            if (sCh == tCh) j++;
        }
        return t.substring(j).length();
    }
}
