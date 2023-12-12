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

    // Remove Letter To Equalize Frequency
    public boolean equalFrequency(String word) {
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (char i : word.toCharArray())
            map.put(i, map.getOrDefault(i, 0) + 1);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            mini = Math.min(mini, entry.getValue());
            maxi = Math.max(maxi, entry.getValue());
        }
        int len = word.length();
        return (map.size() * mini + 1 == len) ||
                (maxi * (map.size() - 1) + 1 == len && mini == 1) ||
                (map.size() == 1);
    }

    // Shuffle String
    public String restoreString(String s, int[] indices) {
        Map<Integer, Character> trackerMap = new TreeMap<>();
        for (int i = 0; i < indices.length; i++)
            trackerMap.put(indices[i], s.charAt(i));
        StringBuilder sb = new StringBuilder();
        for (char c : trackerMap.values()) sb.append(c);
        return sb.toString();
    }

    // Maximum Number of Words Found in Sentences
    public int mostWordsFound(String[] sentences) {
        int[] arr = new int[sentences.length];
        int k = 0;
        for (String i : sentences) {
            int counter = 0;
            for (String j : i.split(" ")) counter++;
            arr[k++] = counter;
        }
        k = 0;
        for (int i : arr) k = Math.max(k, i);
        return k;
    }

    // Goal Parser Interpretation
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        char[] arr = command.toCharArray();
        int i = 0;
        for (; i < arr.length - 1; i++) {
            if (arr[i] == '(' && arr[i + 1] == ')') {
                sb.append('o');
                i++;
            } else if (arr[i] == '(' && arr[i + 1] == 'a') {
                sb.append("al");
                i += 3;
            } else sb.append(arr[i]);
        }
        if (i < arr.length) sb.append(arr[i]++);
        return sb.toString();
    }

    // Jewels and Stones
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelsSet = new HashSet<>();
        for (char i : jewels.toCharArray()) jewelsSet.add(i);
        int counter = 0;
        for (char i : stones.toCharArray())
            if (jewelsSet.contains(i)) counter++;
        return counter;
    }

    // Final Value of Variable After Performing Operations
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String i : operations) {
            switch (i) {
                case "++X":
                    ++x;
                    break;
                case "X++":
                    x++;
                    break;
                case "--X":
                    --x;
                    break;
                case "X--":
                    x--;
                    break;
            }
        }
        return x;
    }

    // Circular Sentence
    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        int arrLen = arr.length;
        if (arrLen == 1)
            return arr[0].charAt(0) == arr[0].charAt(arr[0].length() - 1);
        String prev = arr[0];
        for (int i = 1; i < arrLen; i++) {
            if (prev.charAt(prev.length() - 1) != arr[i].charAt(0)) return false;
            prev = arr[i];
        }
        return prev.charAt(prev.length() - 1) == arr[0].charAt(0);
    }

    // Rotate String
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) return true;
        s += s;
        return s.contains(goal);
    }

    // Fizz Buzz
    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) list.add("FizzBuzz");
            else if (i % 3 == 0) list.add("Fizz");
            else if (i % 5 == 0) list.add("Buzz");
            else list.add(String.valueOf(i));
        }
        return list;
    }

    // Convert a Number to Hexadecimal
    public String toHex(int num) {
        return Integer.toHexString(num);
    }

    // Word Pattern
    public boolean wordPattern(String pattern, String s) {
        Set<Character> patternSet = new LinkedHashSet<>();
        for (char i : pattern.toCharArray()) patternSet.add(i);
        Set<String> sSet = new LinkedHashSet<>(Arrays.asList(s.split(" ")));
        if (patternSet.size() != sSet.size() || sSet.isEmpty() || patternSet.isEmpty()) return false;
        Map<String, String> hashMap = new HashMap<>();
        Iterator<String> sIterator = sSet.iterator();
        Iterator<Character> patternIterator = patternSet.iterator();
        while (sIterator.hasNext()) hashMap.put(sIterator.next(), patternIterator.next().toString());
        StringBuilder sb = new StringBuilder();
        for (String word : s.split(" ")) sb.append(hashMap.get(word));
        return pattern.contentEquals(sb);
    }
}
