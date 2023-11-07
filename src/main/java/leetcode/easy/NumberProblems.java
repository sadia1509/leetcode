package leetcode.easy;

import java.util.HashSet;

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

}
