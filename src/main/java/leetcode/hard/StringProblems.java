package leetcode.hard;

import java.util.*;

public class StringProblems {
    // Orderly Queue
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder();
            for (char c : chars)
                sb.append(c);
            return sb.toString();
        }
        String tempS = s;
        for (int i = 1; i < s.length(); i++) {
            String rotation = s.substring(i) + s.substring(0, i);
            if (tempS.compareTo(rotation) > 0) tempS = rotation;
        }
        return tempS;
    }

    // Permutation Sequence
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n)
        ;
        StringBuilder ans = new StringBuilder();
        k--;
        while (true) {
            ans.append(numbers.get(k / fact));
            numbers.remove(k / fact);
            if (numbers.isEmpty()) break;
            k %= fact;
            fact /= numbers.size();
        }
        return ans.toString();
    }

    public String getPermutation1(int n, int k) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(i);
        getPermutation("", sb.toString(), list);
        Collections.sort(list);
        return list.get(k - 1);
    }

    private void getPermutation(String p, String un, ArrayList<String> list) {
        if (un.isEmpty()) {
            list.add(p);
            return;
        }
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String last = p.substring(i);
            getPermutation(first + un.charAt(0) + last, un.substring(1), list);
        }
    }
}
