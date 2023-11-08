package leetcode.medium;

import common.*;
import java.util.*;

public class ArrayProblems {
    // Find the Winner of an Array Game
    public int getWinner(int[] arr, int k) {
        int winnerMax = arr[0];
        int winCounter = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > winnerMax) {
                winnerMax = arr[i];
                winCounter = 1;
            } else winCounter++;
            if (winCounter == k) return winnerMax;
        }
        return winnerMax;
    }

    // Sort Colors
    public void sortColors(Integer[] nums) {
        int red = 0, white = 1, blue = 2;
        int redCounter = 0, whiteCounter = 0, blueCounter = 0;
        for (int i : nums) {
            if (i == red) redCounter++;
            else if (i == white) whiteCounter++;
            else if (i == blue) blueCounter++;
        }
        int k = 0;
        while (redCounter-- != 0) nums[k++] = red;
        while (whiteCounter-- != 0) nums[k++] = white;
        while (blueCounter-- != 0) nums[k++] = blue;
        Utils.Integer().printArray(nums);
    }

    // Valid Triangle Number
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int counter = 0, len = nums.length;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++)
                for (int k = j + 1; k < len; k++)
                    if (nums[i] + nums[j] > nums[k]) counter++;
        return counter;
    }

    // Search in Rotated Sorted Array
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    // Subarray Sum Equals K
    public int subArraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }
}