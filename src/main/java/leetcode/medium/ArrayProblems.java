package leetcode.medium;

import common.*;
import java.util.Arrays;

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
}
