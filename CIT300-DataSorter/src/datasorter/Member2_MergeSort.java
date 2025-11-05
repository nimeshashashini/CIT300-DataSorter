package datasorter;

import java.util.Arrays;

public class Member2_MergeSort {

    public static SortResult mergeSort(int[] arr) {
        int[] data = arr.clone();
        long startTime = System.nanoTime();
        int[] steps = new int[1];
        mergeSortRecursive(data, 0, data.length - 1, steps);
        long endTime = System.nanoTime();
        double timeMs = (endTime - startTime) / 1_000_000.0;
        return new SortResult("Merge Sort", data, timeMs, steps[0]);
    }

    private static void mergeSortRecursive(int[] arr, int left, int right, int[] steps) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortRecursive(arr, left, mid, steps);
            mergeSortRecursive(arr, mid + 1, right, steps);
            merge(arr, left, mid, right, steps);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] steps) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = Arrays.copyOfRange(arr, left, mid + 1);
        int[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            steps[0]++;
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}
