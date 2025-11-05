package datasorter;

public class Member3_QuickSort {

    public static SortResult quickSort(int[] arr) {
        int[] data = arr.clone();
        long startTime = System.nanoTime();
        int[] steps = new int[1];
        quickSortRecursive(data, 0, data.length - 1, steps);
        long endTime = System.nanoTime();
        double timeMs = (endTime - startTime) / 1_000_000.0;
        return new SortResult("Quick Sort", data, timeMs, steps[0]);
    }

    private static void quickSortRecursive(int[] arr, int low, int high, int[] steps) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, steps);
            quickSortRecursive(arr, low, pivotIndex - 1, steps);
            quickSortRecursive(arr, pivotIndex + 1, high, steps);
        }
    }

    private static int partition(int[] arr, int low, int high, int[] steps) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            steps[0]++;
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}