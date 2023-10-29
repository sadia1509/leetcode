package dsa.datastructure.linear;

import common.Utils;

public class Sort {
    private int length;

    // Bubble sort
    public void bubbleSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] > arr[j])
                    Utils.Integer().swap(arr, i, j);
        Utils.Integer().printArray(arr);
    }

    // Selection sort
    public void selectionSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIndex]) minIndex = j;
            if (minIndex != i)
                Utils.Integer().swap(arr, i, minIndex);
        }
        Utils.Integer().printArray(arr);
    }

    // Insertion sort
    public void insertionSort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentValue = arr[i], j = i - 1;
            while (j >= 0 && currentValue < arr[j])
                arr[j + 1] = arr[j--];
            arr[j + 1] = currentValue;
        }
        Utils.Integer().printArray(arr);
    }

    // Quick sort
    public void quickSort(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);
        Utils.Integer().printArray(arr);
    }

    public void quickSort(Integer[] arr, int startingIndex, int endingIndex) {
        if (startingIndex < endingIndex) {
            int partitionIndex = partition(arr, startingIndex, endingIndex);
            quickSort(arr, startingIndex, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, endingIndex);
        }
    }

    private int partition(Integer[] arr, int startingIndex, int endingIndex) {
        int pivot = arr[endingIndex],
                leftPointer = startingIndex,
                rightPointer = endingIndex - 1;

        while (leftPointer < rightPointer) {
            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) leftPointer++;
            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) rightPointer--;
            if (leftPointer == rightPointer) continue;
            Utils.Integer().swap(arr, leftPointer, rightPointer);
        }

        if (arr[leftPointer] > pivot) Utils.Integer().swap(arr, leftPointer, endingIndex);
        else leftPointer = endingIndex;

        return leftPointer;
    }

    // Merge sort
    public void mergeSort(Integer[] arr) {
        mergeSort(arr, arr.length);
        Utils.Integer().printArray(arr);
    }

    public void mergeSort(Integer[] arr, int arrLength) {
        if (arrLength < 2) return;
        int midIndex = arrLength / 2;

        Integer[] leftArray = new Integer[midIndex];
        Integer[] rightArray = new Integer[arrLength - midIndex];
        for (int i = 0; i < midIndex; i++) leftArray[i] = arr[i];
        for (int i = midIndex; i < arr.length; i++) rightArray[i - midIndex] = arr[i];

        mergeSort(leftArray, leftArray.length);
        mergeSort(rightArray, rightArray.length);
        merge(arr, leftArray, rightArray);
    }

    private void merge(Integer[] arr, Integer[] leftArray, Integer[] rightArray) {
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) arr[k++] = leftArray[i++];
            else arr[k++] = rightArray[j++];
        }
        while (i < leftArray.length) arr[k++] = leftArray[i++];
        while (j < rightArray.length) arr[k++] = rightArray[j++];
    }
}
