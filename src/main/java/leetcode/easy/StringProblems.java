package leetcode.easy;

import dsa.datastructure.linear.Array;

import java.util.*;

public class StringProblems {
    //Minimize String Length
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++) set.add(s.charAt(i));
        return set.size();
    }
}
