package leetcode.hard;

import java.util.Arrays;

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
}
