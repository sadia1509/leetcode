package leetcode.easy;

import java.util.*;
import java.util.LinkedList;

public class StringProblems {
    // Minimize String Length
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) set.add(s.charAt(i));
        return set.size();
    }

    // Ransom Note
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineWordCounterMap = new HashMap<>();
        for (char word : magazine.toCharArray())
            magazineWordCounterMap.put(word, magazineWordCounterMap.getOrDefault(word, 0) + 1);
        for (char word : ransomNote.toCharArray()) {
            if (!magazineWordCounterMap.containsKey(word) || magazineWordCounterMap.get(word) <= 0)
                return false;
            magazineWordCounterMap.put(word, magazineWordCounterMap.get(word) - 1);
        }
        return true;
    }

    // First Unique Character in a String
    public int firstUniqueChar(String s) {
        Map<Character, Integer> charCounterMap = new HashMap<>();
        for (char c : s.toCharArray()) charCounterMap.put(c, charCounterMap.getOrDefault(c, 0) + 1);
        for (int i = 0; i < s.length(); i++)
            if (charCounterMap.get(s.charAt(i)) == 1) return i;
        return -1;
    }

    // Find the Difference
    public char findTheDifference(String s, String t) {
        int[] charCount = new int[26];
        for (char c : t.toCharArray()) charCount[c - 'a']++;
        for (char c : s.toCharArray()) charCount[c - 'a']--;
        for (int i = 0; i < charCount.length; i++)
            if (charCount[i] > 0)
                return (char) (i + 'a');
        return ' ';
    }

    // Add Strings
    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            ans.insert(0, sum % 10);
            i--;
            j--;
        }
        return ans.toString();
    }

    // Percentage of Letter in String
    public int percentageLetter(String s, char letter) {
//        return (s.replaceAll("[^[+" + letter + "+]]", "").length() * 100) / s.length();
        int count = 0;
        for (char i : s.toCharArray()) if (letter == i) count++;
        return (count * 100) / s.length();
    }

    // Number of Segments in a String
    public int countSegments(String s) {
        int counter = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            while (i < len && s.charAt(i) == ' ') i++;
            if (i < len) {
                counter++;
                while (i < len && s.charAt(i) != ' ') i++;
            }
        }
        return counter;
    }

    // Check if Strings Can be Made Equal With Operations I
    public boolean canBeEqual(String s1, String s2) {
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        int len1 = s1arr.length;
        if (len1 != s2arr.length) return false;
        int j;
        for (int i = 0; i < len1; i++) {
            j = i + 2;
            if (s1arr[i] != s2arr[i] && j < len1 && s1arr[j] == s2arr[i]) {
                char temp = s1arr[i];
                s1arr[i] = s1arr[j];
                s1arr[j] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char i : s1arr) sb.append(i);
        return sb.toString().equals(s2);
    }

    // Check if a String Is an Acronym of Words
    public boolean isAcronym(List<String> words, String s) {
        int j = 0, len = words.size();
        for (char i : s.toCharArray())
            if (j == len || i != words.get(j++).charAt(0)) return false;
        return j == len;
    }

    // Faulty Keyboard
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char i : s.toCharArray()) {
            if (i == 'i') sb.reverse();
            else sb.append(i);
        }
        return sb.toString();
    }

    // Isomorphic Strings
    public boolean isIsomorphic(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen != tLen) return false;
        List<Character> sList = new LinkedList<>();
        List<Character> tList = new LinkedList<>();
        for (char i : s.toCharArray()) if (!sList.contains(i)) sList.add(i);
        for (char i : t.toCharArray()) if (!tList.contains(i)) tList.add(i);
        if (sList.size() != tList.size()) return false;
        StringBuilder sb = new StringBuilder();
        sb.append(t);
        for (int i = 0; i < tLen; i++) sb.setCharAt(i, sList.get(tList.indexOf(t.charAt(i))));
        return s.contentEquals(sb);
    }

    // Split a String in Balanced Strings
    public int balancedStringSplit(String s) {
        int counterL = 0, counterR = 0, counter = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') counterL++;
            else counterR++;
            if (counterL == counterR) {
                counter++;
                counterL = 0;
                counterR = 0;
            }
        }
        return counter;
    }

    // DI String Match
    public int[] diStringMatch(String s) {
        int high = s.length(), low = 0;
        int[] arr = new int[high + 1];
        int k = 0;
        for (char c : s.toCharArray())
            arr[k++] = c == 'I' ? low++ : high--;
        arr[k] = s.charAt(s.length() - 1) == 'I' ? low : high;
        return arr;
    }
}
