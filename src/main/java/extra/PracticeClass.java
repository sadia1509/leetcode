package extra;

import common.*;
import java.util.*;

public class PracticeClass {
    // Rearrange array such that even positioned are greater than odd
    public void evenPositionedGreater(int[] arr) {
        Arrays.sort(arr);
        Integer[] arrRes = new Integer[arr.length];
        for (int i = 0, j = 0, k = arr.length - 1; i < arrRes.length; i++) {
            if ((i + 1) % 2 == 0) arrRes[i] = arr[k--];
            else arrRes[i] = arr[j++];
        }
        Utils.Integer().printArray(arrRes);
    }

    // Rearrange an array in maximum minimum form using Two Pointer Technique
    public void maxMinTwoPointer(int[] arr) {
        int smallPointer = 0, largePointer = arr.length - 1;
        Integer[] newArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
            newArr[i] = i % 2 == 0 ? arr[largePointer--] : arr[smallPointer++];
        Utils.Integer().printArray(newArr);
    }

    // Segregate even and odd numbers
    public void segregateEvenOdd(Integer[] arr) {
        for (int i = 0, j = 0; i < arr.length; i++)
            if (arr[i] % 2 == 0) Utils.Integer().swap(arr, j++, i);
        Utils.Integer().printArray(arr);
    }

    // Print All Distinct Elements of a given integer array
    public void distinctElement(int[] arr) {
        for (int i = 0, j; i < arr.length; i++) {
            for (j = 0; j < i; j++)
                if (arr[i] == arr[j]) break;
            if (i == j) Logs.print(arr[i] + " ");
        }
    }


    // Leaders in an array
    public List<Integer> leadersInArray(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        leaders.add(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--)
            if (arr[i] > sumArray(arr, i + 1, arr.length - 1))
                leaders.add(arr[i]);
        return leaders;
    }

    private int sumArray(int[] arr, int from, int to) {
        int total = 0;
        while (from <= to) total += arr[from++];
        return total;
    }

    // Find sub-array with given sum
    public void subArray(int[] arr, int sum) {
        int i = 0, j = 0, tempSum = 0, flag = 0;
        while (i < arr.length) {
            if (tempSum == sum) break;
            if (tempSum < sum) {
                tempSum += arr[i++];
            }
            if (tempSum > sum) {
                tempSum -= arr[j++];
                i--;
            }
            flag++;
        }
        flag = flag - j;
        Logs.println(tempSum + " || " + j + " " + flag);
    }
}
