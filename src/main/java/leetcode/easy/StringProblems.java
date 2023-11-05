package leetcode.easy;

import dsa.datastructure.linear.*;

import java.math.BigInteger;
import java.util.*;

public class StringProblems {
    //Minimize String Length
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) set.add(s.charAt(i));
        return set.size();
    }

    //Ransom Note
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

    //First Unique Character in a String
    public int firstUniqueChar(String s) {
        Map<Character, Integer> charCounterMap = new HashMap<>();
        for (char c : s.toCharArray()) charCounterMap.put(c, charCounterMap.getOrDefault(c, 0) + 1);

        for (int i = 0; i < s.length(); i++)
            if (charCounterMap.get(s.charAt(i)) == 1) return i;

        return -1;
    }

    //Find the Difference
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

    //Percentage of Letter in String
    public int percentageLetter(String s, char letter) {
//        return (s.replaceAll("[^[+" + letter + "+]]", "").length() * 100) / s.length();
        int count = 0;
        for (char i : s.toCharArray()) if (letter == i) count++;
        return (count * 100) / s.length();
    }

    //Number of Segments in a String
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
}
