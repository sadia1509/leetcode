package leetcode.easy;

import common.*;
import dsa.algorithm.*;

import java.util.*;


public class ArrayProblems {
    //    Search search = new Search();
    //Remove Element
    public int removeElement(int[] nums, int val) {
        int currentIndex = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != val)
                nums[currentIndex++] = nums[i];
        return currentIndex;
    }

    //Reverse String
    public void reverseString(Character[] s) {
        int i = 0, j = s.length - 1;
        while (i < j)
            Utils.Character().swap(s, i++, j--);
        Utils.Character().printArray(s);
    }

    //Counting Bits
    public void countBits(int n) {
        Integer[] arr = new Integer[n + 1];
        for (int i = 0; i <= n; i++)
            arr[i] = Integer.toBinaryString(i).replaceAll("0", "").length();
        Utils.Integer().printArray(arr);
    }

    //Reverse Vowels of a String
    public String reverseVowels(String s) {
        List<Character> vowels = List.of('a', 'e', 'o', 'i', 'u', 'A', 'E', 'O', 'I', 'U');
        char[] arr = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !vowels.contains(arr[l])) l++;

            while (l < r && !vowels.contains(arr[r])) r--;

            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            l++;
            r--;
        }
        return new String(arr);
    }

    //Intersection of Two Arrays
    public void intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> num1Set = new HashSet<>();
        for (int i : nums1) num1Set.add(i);
        for (int i : nums2) if (num1Set.contains(i)) set.add(i);

        int[] arr = new int[set.size()];
        int i = 0;
        for (int x : set) arr[i++] = x;
        System.out.println(set);
    }

    //Contains Duplicate II
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) return true;
            else map.put(nums[i], i);
        }
        return false;
    }

    //Contains Duplicate
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] == nums[i + 1]) return true;

        return false;
    }

    //Summary Ranges
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        int val = nums[0];
        String temp = "" + val;
        for (int i = 1; i < nums.length; i++) {
            val++;
            if (nums[i] != val) {
                val = nums[i];
                list.add(temp);
                temp = "" + val;
            } else {
                if (i + 1 < nums.length && nums[i + 1] == val + 1) continue;
                temp += "->" + val;
            }
        }
        list.add(temp);
        return list;
    }


    //3Sum
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (i != j && i != k && j != k && nums[i] + nums[j] + nums[k] == 0) {

                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);

                        if (!lists.contains(list)) lists.add(list);
                    }
                }
            }
        }
        return lists;
    }

    //Missing Number
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int missingNum = nums[0];
        for (int i : nums) {
            if (i != missingNum) return missingNum;
            missingNum++;
        }
        return nums[0] == 0 ? missingNum : 0;
    }

    //Move Zeroes
    public void moveZeroes(int[] nums) { //0,1,0,3,12
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            nums[nonZeroIndex] = nums[i];
            if (i != nonZeroIndex) nums[i] = 0;
            nonZeroIndex++;
        }
        for (int i : nums) System.out.print(i + " ");
    }
}
