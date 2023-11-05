package leetcode.hard;

public class ArrayProblems {
    //Median of Two Sorted Arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArr = merge(nums1, nums2);
        int len = mergedArr.length;
        int mid = len / 2;
        return len % 2 == 0 ? (double) (mergedArr[mid - 1] + mergedArr[mid]) / 2 : mergedArr[mid];

    }

    private int[] merge(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] merged = new int[len1 + len2];
        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] <= nums2[j]) merged[k++] = nums1[i++];
            else merged[k++] = nums2[j++];
        }
        if (i < len1 && j >= len2) while (i < len1) merged[k++] = nums1[i++];
        else if (j < len2 && i >= len1) while (j < len2) merged[k++] = nums2[j++];
        return merged;
    }
}
