package extra;

import common.*;
import java.util.*;

public class PracticeClass {
    // Rearrange array such that even positioned are greater than odd
    public void evenPositionedGreater(int[] arr) {
        Arrays.sort(arr);
        int[] arrRes = new int[arr.length];
        for (int i = 0, j = 0, k = arr.length - 1; i < arrRes.length; i++) {
            if ((i + 1) % 2 == 0) arrRes[i] = arr[k--];
            else arrRes[i] = arr[j++];
        }
        Utils.Integer().printArray(Utils.intToInteger(arrRes));
    }

    // Rearrange an array in maximum minimum form using Two Pointer Technique
    public void maxMinTwoPointer(int[] arr) {
        int smallPointer = 0, largePointer = arr.length - 1;
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            newArr[i] = i % 2 == 0 ? arr[largePointer--] : arr[smallPointer++];
        Utils.Integer().printArray(Utils.intToInteger(newArr));
    }

    // Segregate even and odd numbers
    public void segregateEvenOdd(int[] arr) {
        for (int i = 0, j = 0; i < arr.length; i++)
            if (arr[i] % 2 == 0) Utils.Integer().swap(Utils.intToInteger(arr), j++, i);
        Utils.Integer().printArray(Utils.intToInteger(arr));
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

    // Rearrange an array such that arr[i] = i
    public void rearrange(int[] arr) {
        for (int k = 0; k < 2; k++)
            for (int i = 0; i < arr.length; i++)
                if (arr[i] < arr.length && arr[i] != -1)
                    Utils.Integer().swap(Utils.intToInteger(arr), i, arr[i]);
        Utils.Integer().printArray(Utils.intToInteger(arr));
    }

    // Reorder an array according to given indexes
    public void reorderingTheArrays(int[] arr, int[] index) {
        for (int i = 0; i < index.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < index.length; j++)
                if (index[j] < index[minIndex]) minIndex = j;
            Utils.Integer().swap(Utils.intToInteger(index), i, minIndex);
            Utils.Integer().swap(Utils.intToInteger(arr), i, minIndex);
        }
        Utils.Integer().printArray(Utils.intToInteger(index));
        Utils.Integer().printArray(Utils.intToInteger(arr));
    }


}
