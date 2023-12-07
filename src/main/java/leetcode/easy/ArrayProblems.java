package leetcode.easy;

import common.*;
import dsa.algorithm.*;

import java.util.*;


public class ArrayProblems {
    // Remove Element
    public int removeElement(int[] nums, int val) {
        int currentIndex = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != val)
                nums[currentIndex++] = nums[i];
        return currentIndex;
    }

    // Reverse String
    public void reverseString(Character[] s) {
        int i = 0, j = s.length - 1;
        while (i < j)
            Utils.Character().swap(s, i++, j--);
        Utils.Character().printArray(s);
    }

    // Counting Bits
    public void countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++)
            arr[i] = Integer.toBinaryString(i).replaceAll("0", "").length();
        Utils.Integer().printArray(Utils.intToInteger(arr));
    }

    // Reverse Vowels of a String
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

    // Intersection of Two Arrays
    public void intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> num1Set = new HashSet<>();
        for (int i : nums1) num1Set.add(i);
        for (int i : nums2) if (num1Set.contains(i)) set.add(i);

        int[] arr = new int[set.size()];
        int i = 0;
        for (int x : set) arr[i++] = x;
        Logs.println(set);
    }

    // Contains Duplicate II
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) return true;
            else map.put(nums[i], i);
        }
        return false;
    }

    // Contains Duplicate
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] == nums[i + 1]) return true;
        return false;
    }

    // Summary Ranges
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


    // 3Sum
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

    // Missing Number
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int missingNum = nums[0];
        for (int i : nums) {
            if (i != missingNum) return missingNum;
            missingNum++;
        }
        return nums[0] == 0 ? missingNum : 0;
    }

    // Move Zeroes
    public void moveZeroes(int [] nums) { //0,1,0,3,12
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            nums[nonZeroIndex] = nums[i];
            if (i != nonZeroIndex) nums[i] = 0;
            nonZeroIndex++;
        }
        Utils.Integer().printArray(Utils.intToInteger(nums));
    }

    // Find Target Indices After Sorting Array
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new LinkedList<>();
        Sort.mergeSort(nums);
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == target) list.add(i);
        return list;
    }

    // Count Negative Numbers in a Sorted Matrix
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            for (int i = row.length - 1; i >= 0; i--) {
                if (row[i] < 0) count++;
                else break;
            }
        }
        return count;
    }

    // Points That Intersect With Cars
    public int numberOfPoints(List<List<Integer>> nums) {
        if (nums.isEmpty()) return 0;
        Set<Integer> set = new HashSet<>();
        for (List<Integer> n : nums) {
            int l = n.get(0), h = n.get(1);
            while (l <= h) {
                set.add(l++);
                set.add(h--);
            }
        }
        return set.size();
    }

    // Count Pairs Whose Sum is Less than Target
    public int countPairs(List<Integer> nums, int target) {
        int count = 0, len = nums.size();
        for (int i = 0; i < len - 1; i++)
            for (int j = i + 1; j < len; j++)
                if (nums.get(i) + nums.get(j) < target) count++;
        return count;
    }

    // Min Cost Climbing Stairs
    public int minCostClimbingStairs(int[] cost) {
        int p1 = 0, p2 = 0;
        for (int i = 0; i < cost.length; i++) {
            int p0 = cost[i] + Math.min(p1, p2);
            p2 = p1;
            p1 = p0;
        }
        return Math.min(p1, p2);
    }

    // Final Prices With a Special Discount in a Shop
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            int discount = 0;
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j];
                    break;
                }
            }
            prices[i] -= discount;
        }
        Utils.Integer().printArray(Utils.intToInteger(prices));
        return prices;
    }

    // Next Greater Element I
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int n : nums2) {
            while (!stack.isEmpty() && stack.peek() < n)
                map.put(stack.pop(), n);
            stack.push(n);
        }
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }

    // Array Partition
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2)
            sum += nums[i];
        return sum;
    }

    // Maximum Sum With Exactly K Elements
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int m = nums[nums.length - 1];
        int sum = 0;
        while (k-- != 0) sum += m++;
        return sum;
    }

    // Minimum Operations to Make the Array Increasing
    public int minOperations(int[] nums) {
        int total = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                total += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return total;
    }

    // Maximum Product of Two Elements in an Array
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        Arrays.sort(nums);
        return (nums[len - 2] - 1) * (nums[len - 1] - 1);
    }

    // Delete Greatest Value in Each Row
    public int deleteGreatestValue(int[][] grid) {
        int sum = 0;
        for (int[] row : grid) Arrays.sort(row);
        int size = grid[0].length;
        for (int i = size - 1; i >= 0; i--) {
            int max = Integer.MIN_VALUE;
            for (int[] ints : grid) max = Math.max(max, ints[i]);
            sum += max;
        }
        return sum;
    }

    // The K Weakest Rows in a Matrix
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] arr = new int[k];
        int[][] tempArr = new int[mat.length][2];
        int j = 0;
        for (int[] row : mat) {
            int sum = 0;
            for (int i : row) {
                if (i == 0) break;
                sum += i;
            }
            tempArr[j][0] = sum;
            tempArr[j][1] = j++;
        }
        Arrays.sort(tempArr, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < k; i++) arr[i] = tempArr[i][1];
        return arr;
    }

    // Left and Right Sum Differences
    public int[] leftRightDifference(int[] nums) {
        int len = nums.length;
        int[] leftSum = new int[len];
        int[] rightSum = new int[len];
        int prev = 0;
        for (int i = 1; i < len; i++) {
            leftSum[i] = nums[i - 1] + prev;
            prev = leftSum[i];
        }
        prev = 0;
        for (int i = len - 2; i >= 0; i--) {
            rightSum[i] = nums[i + 1] + prev;
            prev = rightSum[i];
        }
        for (int i = 0; i < len; i++)
            nums[i] = Math.abs(leftSum[i] - rightSum[i]);
        return nums;
    }

    // Sum of Values at Indices With K Set Bits
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum=0;
        for(int i=0; i<nums.size(); i++)
            if(Integer.bitCount(i) == k) sum += nums.get(i);
        return sum;
    }

    // How Many Numbers Are Smaller Than the Current Number
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int [] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        int tempCount = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i-1] == arr[i]) {
                tempCount++;
                continue;
            }
            map.put(arr[i], map.get(arr[i-1]) + 1 + tempCount);
            tempCount = 0;
        }
        for (int i = 0; i<nums.length; i++)
            nums[i] = map.get(nums[i]);
        return nums;
    }

    // Running Sum of 1d Array
    public int[] runningSum(int[] nums) {
        int prev = 0;
        for(int i=0;  i<nums.length; i++){
            nums[i] = nums[i]+prev;
            prev = nums[i];
        }
        return nums;
    }

    // Kids With the Greatest Number of Candies
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int currentMax = Integer.MIN_VALUE;
        List<Boolean> booleanList = new LinkedList<>();
        for(int i : candies) currentMax = Math.max(currentMax, i);
        for(int i : candies) {
            if (extraCandies+i >= currentMax) booleanList.add(true);
            else booleanList.add(false);
        }
        return booleanList;
    }

    // Richest Customer Wealth
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for(int [] acc : accounts){
            int count = 0;
            for (int i: acc) count += i;
            max = Math.max(max, count);
        }
        return max;
    }

    // Number of Employees Who Met the Target
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int counter = 0;
        for(int i : hours)
            if (i >= target) counter++;
        return counter;
    }

    // Shuffle the Array
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int [] arr = new int[len];
        int i = 0, j=n;
        while (i<len){
            arr[i++] = nums[j-n];
            arr[i++] = nums[j++];
        }
        return arr;
    }

    // Number of Good Pairs
    public int numIdenticalPairs(int[] nums) {
        int count = 0, len = nums.length;
        for(int i=0; i<len-1; i++)
            for(int j = i+1; j<len; j++)
                if (nums[i] == nums[j]) count++;
        return count;
    }

    // Concatenation of Array
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int [] arr = new int[len + len];
        for(int i=0; i < len; i++)
            arr[i] = arr[i+len] = nums[i];
        return arr;
    }

    // Build Array from Permutation
    public int[] buildArray(int[] nums) {
        int [] arr = new int[nums.length];
        for(int i = 0; i<arr.length; i++)
            arr[i] = nums[nums[i]];
        return arr;
    }
}
