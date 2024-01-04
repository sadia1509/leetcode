package leetcode.easy;

import common.*;

import java.util.*;

public class NumberProblems {
    // Add Digits
    public int addDigits(int num) {
        while (num > 9) {
            int total = 0;
            while (num != 0) {
                total += num % 10;
                num /= 10;
            }
            num = total;
        }
        return num;
    }

    // Ugly Number
    public boolean isUgly(int n) {
        if (n == 1) return true;
        if (n <= 0) return false;
        if (n % 2 == 0) return (isUgly(n / 2));
        if (n % 3 == 0) return (isUgly(n / 3));
        if (n % 5 == 0) return (isUgly(n / 5));
        return false;
    }

    // Valid Perfect Square
    public boolean isPerfectSquare(int num) {
        return (Math.sqrt(num) % 1) == 0;
    }

    // Third Maximum Number
    public int thirdMax(int[] nums) {
        long inf = Long.MIN_VALUE, first = inf, second = inf, third = inf;
        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num < first && num > second) {
                third = second;
                second = num;
            } else if (num < second && num > third)
                third = num;
        }
        return third == inf ? (int) first : (int) third;
    }

    // Perfect Number
    public boolean checkPerfectNumber(int num) {
        int i = 1, sum = 0;
        while (i <= num / 2) {
            if (num % i == 0) sum += i;
            i++;
        }
        return sum == num;
    }

    // Account Balance After Rounded Purchase
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        if (purchaseAmount % 10 < 5) while (purchaseAmount % 10 != 0) purchaseAmount--;
        else while (purchaseAmount % 10 != 0) purchaseAmount++;
        return 100 - purchaseAmount;
    }

    // Single Number
    public int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = generateHashSet(new HashSet<>(), nums, 0);
        return Integer.parseInt(hashSet.iterator().next().toString());
    }

    private HashSet<Integer> generateHashSet(HashSet<Integer> hashSet, int[] nums, int i) {
        if (i >= nums.length) return hashSet;
        else {
            if (hashSet.contains(nums[i])) hashSet.remove(nums[i]);
            else hashSet.add(nums[i]);
            return generateHashSet(hashSet, nums, ++i);
        }
    }

    // Divisor Game
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    // Minimum Sum of Four Digit Number After Splitting Digits
    public int minimumSum(int num) {
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = num % 10;
            num /= 10;
        }
        Arrays.sort(arr);
        return (arr[0] * 10 + arr[2]) + (arr[1] * 10 + arr[3]);
    }

    // Maximum 69 Number
    public int maximum69Number(int num) {
        int len = String.valueOf(num).length();
        int[] arr = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            arr[i] = num % 10;
            num /= 10;
        }
        for (int i = 0; i < len; i++) {
            if (arr[i] != 9) {
                arr[i] = 9;
                break;
            }
        }
        int sum = 0;
        for (int i : arr) sum = sum * 10 + i;
        return sum;
    }

    // Count of Matches in Tournament
    public int numberOfMatches(int n) {
        int matches = 0, temp;
        while (n != 1) {
            temp = n / 2;
            if (n % 2 == 0) matches += temp;
            else matches += temp + 1;
            n = temp;
        }
        return matches;
    }

    // First Bad Version
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean isBadVersion(int version) {
        int bad = 1702766719;
        return version == bad;
    }

    // Number of 1 Bits
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result += n & 1;
            n >>>= 1; // Unsigned right shift
//            n = n >> 1; // Signed right shift
        }
        return result;
    }

    // Check if The Number is Fascinating
    public boolean isFascinating(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        for (int i = 2; i < 4; i++) sb.append(n * i);
        int[] arr = new int[10];
        for (char i : sb.toString().toCharArray()) arr[i - '0']++;
        for (int i = 1; i < arr.length; i++) if (arr[i] != 1) return false;
        return true;
    }

    // Find the Maximum Achievable Number
    public int theMaximumAchievableX(int num, int t) {
        return num + t + t;
    }

    // Divisible and Non-divisible Sums Difference
    public int differenceOfSums(int n, int m) {
        int num1 = 0, num2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) num2 += i;
            else num1 += i;
        }
        return num1 - num2;
    }

    // Convert the Temperature
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }

    // Number of Common Factors
    public int commonFactors(int a, int b) {
        int min = Math.min(a, b);
        int count = 0;
        for (int i = 1; i <= min; i++)
            if (a % i == 0 && b % i == 0) count++;
        return count;
    }

    // A Number After a Double Reversal
    public boolean isSameAfterReversals(int num) {
        return num == Utils.reverseNumber(Utils.reverseNumber(num));
    }

    // Number of Steps to Reduce a Number to Zero
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num != 0) {
            if (num % 2 == 0) num /= 2;
            else num--;
            steps++;
        }
        return steps;
    }

    // Calculate Money in Leetcode Bank
    public int totalMoney(int n) {
        int increment = 0, number = 1, total = 0;
        for (int i = 1; i <= n; i++) {
            total += increment + number++;
            if (i % 7 == 0) {
                increment++;
                number = 1;
            }
        }
        return total;
    }

    // Self Dividing Numbers
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i = left; i <= right; i++)
            getNumbers(list, i);
        return list;
    }

    private void getNumbers(List<Integer> list, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        for (char ch : sb.toString().toCharArray()) {
            int num = ch - '0';
            if (num == 0 || i % num != 0) return;
        }
        list.add(i);
    }


}
