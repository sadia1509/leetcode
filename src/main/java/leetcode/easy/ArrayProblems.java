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
    public void moveZeroes(int[] nums) { //0,1,0,3,12
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
        int sum = 0;
        for (int i = 0; i < nums.size(); i++)
            if (Integer.bitCount(i) == k) sum += nums.get(i);
        return sum;
    }

    // How Many Numbers Are Smaller Than the Current Number
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        int tempCount = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                tempCount++;
                continue;
            }
            map.put(arr[i], map.get(arr[i - 1]) + 1 + tempCount);
            tempCount = 0;
        }
        for (int i = 0; i < nums.length; i++)
            nums[i] = map.get(nums[i]);
        return nums;
    }

    // Running Sum of 1d Array
    public int[] runningSum(int[] nums) {
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] + prev;
            prev = nums[i];
        }
        return nums;
    }

    // Kids With the Greatest Number of Candies
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int currentMax = Integer.MIN_VALUE;
        List<Boolean> booleanList = new LinkedList<>();
        for (int i : candies) currentMax = Math.max(currentMax, i);
        for (int i : candies) {
            if (extraCandies + i >= currentMax) booleanList.add(true);
            else booleanList.add(false);
        }
        return booleanList;
    }

    // Richest Customer Wealth
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int[] acc : accounts) {
            int count = 0;
            for (int i : acc) count += i;
            max = Math.max(max, count);
        }
        return max;
    }

    // Number of Employees Who Met the Target
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int counter = 0;
        for (int i : hours)
            if (i >= target) counter++;
        return counter;
    }

    // Shuffle the Array
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int[] arr = new int[len];
        int i = 0, j = n;
        while (i < len) {
            arr[i++] = nums[j - n];
            arr[i++] = nums[j++];
        }
        return arr;
    }

    // Number of Good Pairs
    public int numIdenticalPairs(int[] nums) {
        int count = 0, len = nums.length;
        for (int i = 0; i < len - 1; i++)
            for (int j = i + 1; j < len; j++)
                if (nums[i] == nums[j]) count++;
        return count;
    }

    // Concatenation of Array
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len + len];
        for (int i = 0; i < len; i++)
            arr[i] = arr[i + len] = nums[i];
        return arr;
    }

    // Build Array from Permutation
    public int[] buildArray(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = nums[nums[i]];
        return arr;
    }

    // Intersection of Two Arrays II
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> arrList = new LinkedList<>();
        int[] count = new int[1001];
        for (int i : nums1) count[i]++;
        for (int i : nums2) {
            if (count[i] > 0) {
                arrList.add(i);
                count[i]--;
            }
        }
        int[] arr = new int[arrList.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = arrList.get(i);
        return arr;
    }

    // Find Common Elements Between Two Arrays
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int first = 0, last = 0;
        for (int i = 0; i < nums1.length; i++) {
            first = findCommon(nums2, nums1[i]);
            if (first != 0) break;
        }
        for (int i = nums2.length - 1; i >= 0; i--) {
            last = findCommon(nums1, nums2[i]);
            if (last != 0) break;
        }
        return new int[]{first, last};
    }

    // Find Common Elements Between Two Arrays
    public int[] findIntersectionValuesAnother(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
        int count1 = 0;
        for (int num : nums1) if (set2.contains(num)) count1++;
        int count2 = 0;
        for (int num : nums2) if (set1.contains(num)) count2++;
        return new int[]{count1, count2};
    }

    private int findCommon(int[] nums, int i) {
        for (int j = 0; j < nums.length; j++) if (i == nums[j]) return i;
        return 0;
    }

    // Count Tested Devices After Test Operations
    public int countTestedDevices(int[] batteryPercentages) {
        int count = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] > 0) {
                test(batteryPercentages, i);
                count++;
            }
        }
        return count;
    }

    private void test(int[] batteryPercentages, int start) {
        for (int i = start; i < batteryPercentages.length; i++)
            if (batteryPercentages[i] > 0) batteryPercentages[i]--;
    }

    // Find Missing and Repeated Values
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length, repeat = -1, missing = -1;
        int[] arr = new int[n * n + 1];
        for (int[] row : grid) for (int i : row) arr[i]++;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0 && missing == -1) missing = i;
            else if (arr[i] == 2 && repeat == -1) repeat = i;
        }
        return new int[]{repeat, missing};
    }

    // Largest Positive Integer That Exists With Its Negative
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        while (low < high) {
            if (nums[high] + nums[low] == 0) return nums[high];
            else if (Math.abs(nums[low]) < nums[high]) high--;
            else low++;
        }
        return -1;
    }

    // Divide Array Into Equal Pairs
    public boolean divideArray(int[] nums) {
        if (nums.length % 2 != 0) return false;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2)
            if (nums[i - 1] != nums[i]) return false;
        return true;
    }

    //  Find the Difference of Two Arrays
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) set1.add(i);
        for (int i : nums2) set2.add(i);
        List<Integer> list1 = new ArrayList<>();
        for (int uniq1 : set1) if (!set2.contains(uniq1)) list1.add(uniq1);
        List<Integer> list2 = new ArrayList<>();
        for (int uniq2 : set2) if (!set1.contains(uniq2)) list2.add(uniq2);
        return Arrays.asList(list1, list2);
    }

    // Find the Middle Index in Array
    public int findMiddleIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftSum = sum(nums, 0, i);
            int rightSum = sum(nums, i + 1, nums.length);
            if (leftSum == rightSum) return i;
        }
        return -1;
    }

    private int sum(int[] nums, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) count += nums[i];
        return count;
    }

    // Minimum Difference Between Highest and Lowest of K Scores
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = k - 1;
        while (j < nums.length)
            min = Math.min(min, nums[j++] - nums[i++]);
        return min;
    }

    // Matrix Similarity After Cyclic Shifts
    public boolean areSimilar(int[][] mat, int k) {
        final int n = mat[0].length;
        for (int[] row : mat)
            for (int j = 0; j < n; j++)
                if (row[j] != row[(j + k) % n]) return false;
        return true;
    }

    // Minimum Number Game
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        return nums;
    }

    // Sum of Squares of Special Elements
    public int sumOfSquares(int[] nums) {
        int result = 0;
        return result;
    }

    // Find the Peaks
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1])
                list.add(i);
        }
        return list;
    }

    // Special Positions in a Binary Matrix
    public int numSpecial(int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                if (mat[i][j] == 1)
                    if (allZerosInRow(mat, i, j, mat[i].length)) // Check if all other elements in the row are 0
                        if (allZerosInColumn(mat, i, j, mat.length))
                            count++; // Check if all other elements in the column are 0
        return count;
    }

    private boolean allZerosInRow(int[][] mat, int row, int col, int len) {
        for (int c = 0; c < len; c++)
            if (c != col && mat[row][c] != 0)
                return false;
        return true;
    }

    private boolean allZerosInColumn(int[][] mat, int row, int col, int len) {
        for (int r = 0; r < len; r++)
            if (r != row && mat[r][col] != 0)
                return false;
        return true;
    }

    // Difference Between Ones and Zeros in Row and Column
    public int[][] onesMinusZeros(int[][] grid) {
        int len = grid[0].length, rowLen = grid.length;
        int[] onesRow = new int[rowLen];
        int[] onesCol = new int[len];
        int[] zerosRow = new int[rowLen];
        int[] zerosCol = new int[len];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 1) {
                    onesRow[i]++;
                    onesCol[j]++;
                } else {
                    zerosRow[i]++;
                    zerosCol[j]++;
                }
            }
        }
        int[][] diff = new int[rowLen][len];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < len; j++) {
                diff[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
            }
        }
        return diff;
    }

    // Count Number of Distinct Integers After Reverse Operations
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> numberSet = new HashSet<>();
        for (int i : nums) {
            numberSet.add(i);
            numberSet.add(Utils.reverseNumber(i));
        }
        return numberSet.size();
    }

    // Sort Integers by The Number of 1 Bits
    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i : arr) {
            int bits = Integer.bitCount(i);
            List<Integer> list = map.getOrDefault(bits, new ArrayList<>());
            list.add(i);
            map.put(bits, list);
        }
        int i = 0;
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
            for (int elem : list) arr[i++] = elem;
        }
        return arr;
    }

    // Separate the Digits in an Array
    public int[] separateDigits(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int num : nums) {
            StringBuilder sb = new StringBuilder();
            sb.append(num);
            for (char ch : sb.toString().toCharArray())
                queue.offer(ch - '0');
        }
        int[] arr = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty())
            arr[i++] = queue.poll();
        return arr;
    }

    // Cells with Odd Values in a Matrix
    public int oddCells(int m, int n, int[][] indices) {
        int[][] arr = new int[m][n];
        for (int[] row : arr) Arrays.fill(row, 0);
        for (int[] row : indices) {
            for (int i = 0; i < n; i++) arr[row[0]][i]++;
            for (int i = 0; i < m; i++) arr[i][row[1]]++;
        }
        int oddCounter = 0;
        for (int[] row : arr)
            for (int i : row)
                if (i % 2 != 0) oddCounter++;
        return oddCounter;
    }

    // Number Of Rectangles That Can Form The Largest Square
    public int countGoodRectangles(int[][] rectangles) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] row : rectangles) {
            int min = Math.min(row[0], row[1]);
            map.put(min, map.getOrDefault(min, 0) + 1);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            max = Math.max(entry.getKey(), max);
        return map.get(max);
    }

    // Assign Cookies
    public int findContentChildren(int[] g, int[] s) {
        int contentChildren = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < s.length && j < g.length; i++) {
            if (s[i] >= g[j]) {
                contentChildren++;
                j++;
            }
        }
        return contentChildren;
    }

    // Set Mismatch
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[nums.length + 1];
        for (int i : nums) arr[i]++;
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > 1) list.add(i);
        for (int i = 1; i < arr.length; i++)
            if (arr[i] == 0) list.add(i);
        int[] ar = new int[list.size()];
        int k = 0;
        for (int i : list) ar[k++] = i;
        return ar;
    }

    // Rank Transform of an Array
    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];
        int[] tempArr = arr.clone();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(tempArr);
        for (int i : tempArr)
            map.putIfAbsent(i, map.size() + 1);
        for (int i = 0; i < len; i++)
            res[i] = map.get(arr[i]);
        return res;
    }

    // Minimum Absolute Difference
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new LinkedList<>();
        Map<List<Integer>, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length - 1; i++)
            map.put(List.of(arr[i], arr[i + 1]), Math.abs(arr[i] - arr[i + 1]));
        int min = Integer.MAX_VALUE;
        for (int i : map.values()) min = Math.min(min, i);
        for (Map.Entry<List<Integer>, Integer> entry : map.entrySet())
            if (min == entry.getValue()) list.add(entry.getKey());
        return list;
    }

    // Unique Number of Occurrences
    public boolean uniqueOccurrences(int[] arr) {
        int[] temp = new int[2001];
        for (int i : arr) temp[i + 1000]++;
        Set<Integer> set = new HashSet<>();
        for (int i : temp) {
            if (i == 0) continue;
            if (set.contains(i)) return false;
            set.add(i);
        }
        return true;
    }

    // Relative Sort Array
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int i : arr1) count[i]++;
        int k = 0;
        int[] arr = new int[arr1.length];
        for (int i : arr2) {
            if (count[i] != 0) {
                while (count[i] > 0) {
                    arr[k++] = i;
                    count[i]--;
                }
            }
        }
        for (int i = 0; i < 1001; i++) {
            if (count[i] != 0) {
                while (count[i] > 0) {
                    arr[k++] = i;
                    count[i]--;
                }
            }
        }
        return arr;
    }

    // Minimum Cost of Buying Candies With Discount
    public int minimumCost(int[] cost) {
        int total = 0;
        Arrays.sort(cost);
        int len = cost.length;
        if (len == 1) return cost[0];
        for (int i = len - 1; i >= 0; i -= 3) {
            total += cost[i];
            if (i - 1 >= 0) total += cost[i - 1];
        }
        return total;
    }

    // Find the Town Judge
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for (int[] person : trust) {
            in[person[0]]++;
            out[person[1]]++;
        }
        for (int i = 1; i <= n; i++)
            if (in[i] == 0 && out[i] == n - 1) return i;
        return -1;
    }

    // Flipping an Image
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            int left = 0;
            int right = row.length - 1;
            while (left <= right) {
                int temp = row[left];
                row[left] = row[right] ^ 1;
                row[right] = temp ^ 1;
                left++;
                right--;
            }
        }
        return image;
    }

    // Find All Numbers Disappeared in an Array
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new LinkedList<>();
        Sort.cycleSort(nums);
        for (int i = 0; i < nums.length; i++)
            if (i != nums[i] - 1) list.add(i + 1);
        return list;
    }

    // Find Smallest Letter Greater Than Target
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length - 1, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target < letters[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return letters[start % letters.length];
    }

    // Find Closest Number to Zero
    public int findClosestNumber(int[] nums) {
        int closest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i]) < Math.abs(closest)) closest = nums[i];
            else if (Math.abs(nums[i]) == Math.abs(closest))
                if (nums[i] > closest) closest = nums[i];
        }
        return closest;
    }

    // Number of Students Unable to Eat Lunch
    public int countStudents(int[] students, int[] sandwiches) {
        int std_0 = 0, std_1 = 0;
        for (int i : students) {
            if (i == 1) std_1++;
            else std_0++;
        }
        int i = 0;
        for (; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0 && std_0 > 0) std_0--;
            else if (sandwiches[i] == 1 && std_1 > 0) std_1--;
            else break;
        }
        return sandwiches.length - i;
    }

    // Longest Unequal Adjacent Groups Subsequence I
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> list = new ArrayList<>();
        int prev = groups[0];
        list.add(words[0]);
        for (int i = 1; i < groups.length; i++) {
            if (prev == groups[i]) continue;
            list.add(words[i]);
            prev = groups[i];
        }
        return list;
    }

    // Maximum Product Difference Between Two Pairs
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n - 1] * nums[n - 2]) - (nums[0] * nums[1]);
    }

    // Maximum Units on a Truck
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(a -> a[1]));
        int sum = 0;
        for (int i = boxTypes.length - 1; i >= 0; i--) {
            int temp = boxTypes[i][0];
            while (temp > 0 && truckSize > 0) {
                sum += boxTypes[i][1];
                temp--;
                truckSize--;
            }
        }
        return sum;
    }

    // Time Needed to Buy Tickets
    public int timeRequiredToBuy(int[] tickets, int k) {
        int totalSecond = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] < tickets[k]) totalSecond += tickets[i];
            else {
                totalSecond += tickets[k];
                if (i > k) totalSecond--;
            }
        }
        return totalSecond;
    }

    // Find Common Characters
    public List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();
        int[] minFrequency = new int[26];
        Arrays.fill(minFrequency, Integer.MAX_VALUE);
        for (String word : words) {
            int[] arr = new int[26];
            for (char ch : word.toCharArray())
                arr[ch - 'a']++;
            for (int i = 0; i < 26; i++)
                minFrequency[i] = Math.min(minFrequency[i], arr[i]);
        }
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < minFrequency[i]; j++)
                list.add(String.valueOf((char) ('a' + i)));
        return list;
    }

    // Three Consecutive Odds
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0, j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == j && arr[i] % 2 != 0) {
                count++;
                j++;
                if (count == 3) return true;
            } else {
                count = 0;
                j = i + 1;
            }
        }
        return false;
    }

    // Find the Highest Altitude
    public int largestAltitude(int[] gain) {
        int largestAltitude = 0;
        largestAltitude = Math.max(largestAltitude, gain[0]);
        for (int i = 1; i < gain.length; i++) {
            gain[i] += gain[i - 1];
            largestAltitude = Math.max(largestAltitude, gain[i]);
        }
        return largestAltitude;
    }

    // Sum of All Odd Length Subarrays
    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) arr[i] += arr[i - 1];
        int sum = arr[len - 1];
        int k = 3;
        while (k <= len) {
            int i = 0, j = k;
            sum += arr[j - 1];
            while (j < len) sum += arr[j++] - arr[i++];
            k += 2;
        }
        return sum;
    }

    // Height Checker
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < heights.length; i++)
            if (heights[i] != expected[i]) count++;
        return count;
    }

    // Find Minimum Operations to Make All Elements Divisible by Three
    public int minimumOperations(int[] nums) {
        int count = 0;
        for (int n : nums) {
            int mod = n % 3;
            count += Math.min(mod, 3 - mod);
        }
        return count;
    }

    // Sum of All Subset XOR Totals
    public int subsetXORSum(int[] nums) {
        ArrayList<Integer> xorList = new ArrayList<>();
        subsetXORSum(nums, 0, new ArrayList<>(), xorList);
        int sum = 0;
        for (int i : xorList) sum += i;
        return sum;
    }

    private void subsetXORSum(int[] nums, int index, ArrayList<Integer> list, ArrayList<Integer> xors) {
        int xor = 0;
        for (int i : list) xor ^= i;
        xors.add(xor);
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsetXORSum(nums, i + 1, list, xors);
            list.remove(list.size() - 1);
        }
    }

    // Count Number of Pairs With Absolute Difference K
    public int countKDifference(int[] nums, int k) {
        int count = 0, len = nums.length;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++)
                if (Math.abs(nums[i] - nums[j]) == k)
                    count++;
        return count;
    }

    // Matrix Diagonal Sum
    public int diagonalSum(int[][] mat) {
        int len = mat.length, sum = 0;
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            sum += mat[i][i];
            sum += mat[i][j];
        }
        if (len % 2 != 0) sum -= mat[len / 2][len / 2];
        return sum;
    }

    // Find Subarrays With Equal Sum
    public boolean findSubarrays(int[] nums) {
        Set<Integer> sums = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i - 1] + nums[i];
            if (sums.contains(sum)) return true;
            sums.add(sum);
        }
        return false;
    }
}
