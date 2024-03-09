package dsa.algorithm;

import common.*;

import java.util.Arrays;
import java.util.Random;

public class Sort {

    // Bubble sort
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] > arr[j])
                    Utils.Integer().swap(Utils.intToInteger(arr), i, j);
        Utils.Integer().printArray(Utils.intToInteger(arr));
    }

    // Selection sort
    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIndex]) minIndex = j;
            if (minIndex != i)
                Utils.Integer().swap(Utils.intToInteger(arr), i, minIndex);
        }
        Utils.Integer().printArray(Utils.intToInteger(arr));
    }

    // Insertion sort
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentValue = arr[i], j = i - 1;
            while (j >= 0 && currentValue < arr[j])
                arr[j + 1] = arr[j--];
            arr[j + 1] = currentValue;
        }
        Utils.Integer().printArray(Utils.intToInteger(arr));
    }

    // Quick sort
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        Utils.Integer().printArray(Utils.intToInteger(arr));
    }

    public void quickSort(int[] arr, int high, int low) {
        if (high < low) {
            int partitionIndex = partition(arr, high, low);
            quickSort(arr, high, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, low);
        }
    }

    private int partition(int[] arr, int high, int low) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                if (j != i) Utils.Integer().swap(Utils.intToInteger(arr), i, j);
            }
        }
        // Swap array[i+1] and array[high] (to put the pivot in its correct position)
        Utils.Integer().swap(Utils.intToInteger(arr), i + 1, high);
        return i + 1;
    }

    // Merge sort
    public static void mergeSort(int[] arr) {
        mergeSort(arr, arr.length);
        Utils.Integer().printArray(Utils.intToInteger(arr));
    }

    private static void mergeSort(int[] arr, int arrLength) {
        if (arrLength < 2) return;
        int midIndex = arrLength / 2;

        int[] leftArray = new int[midIndex];
        int[] rightArray = new int[arrLength - midIndex];
        for (int i = 0; i < midIndex; i++) leftArray[i] = arr[i];
        for (int i = midIndex; i < arr.length; i++) rightArray[i - midIndex] = arr[i];

        mergeSort(leftArray, leftArray.length);
        mergeSort(rightArray, rightArray.length);
        merge(arr, leftArray, rightArray);
    }

    private static void merge(int[] arr, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) arr[k++] = leftArray[i++];
            else arr[k++] = rightArray[j++];
        }
        while (i < leftArray.length) arr[k++] = leftArray[i++];
        while (j < rightArray.length) arr[k++] = rightArray[j++];
    }

    // Sort an array in wave form
    public void waveSort(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i += 2)
            Utils.Integer().swap(Utils.intToInteger(arr), i, i + 1);
        Utils.Integer().printArray(Utils.intToInteger(arr));
    }

    // BOGO sort or Shuffle sort  (Please do not run it)
    public void bogoSort(int[] arr) {
        while (!isSorted(arr)) shuffleArray(arr);
        Utils.Integer().printArray(Utils.intToInteger(arr));
    }

    private void shuffleArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = new Random().nextInt(i + 1);
            Utils.Integer().swap(Utils.intToInteger(arr), i, index);
        }
    }

    private boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1] > arr[i]) return false;
        return true;
    }
}
