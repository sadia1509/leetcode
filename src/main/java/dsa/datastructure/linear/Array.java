package dsa.datastructure.linear;

import common.*;

public class Array {

    // Left shift by k-th position
    public void leftShift(Object[] arr, int k) {
        int arrLength = arr.length;
        k %= arrLength;
        Object[] tempArr = new Object[k];
        for (int i = 0; i < k; i++) tempArr[i] = arr[i];

        int i = 0;
        while (i < arrLength - k) arr[i] = arr[(i++) + k];

        for (int j = 0; i < arrLength; i++, j++) arr[i] = tempArr[j];
        Logs.print("Left shift by " + k + ": ");
        Utils.Object().printArray(arr);
    }

    // Right shift by k-th position
    public void rightShift(Object[] arr, int k) {
//        leftShift(arr, arr.length-k);
        int arrLength = arr.length;
        k %= arrLength;
        Object[] tempArr = new Object[k];
        for (int i = arrLength - k, j = 0; j < k; i++, j++) tempArr[j] = arr[i];

        for (int i = 0; i < arrLength - k; i++) arr[i + k] = arr[i];
        for (int i = 0; i < k; i++) arr[i] = tempArr[i];
        Logs.print("Right shift by " + k + ": ");
        Utils.Object().printArray(arr);
    }

    // Print left rotation of array in O(n) time and O(1) space
    public void printLeftRotation(int[] arr, int k) {
        for (int i : arr) {
            k %= arr.length;
            Logs.print(arr[k++] + " ");
        }
    }
}
