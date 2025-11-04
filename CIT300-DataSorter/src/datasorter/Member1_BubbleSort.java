package datasorter;

public class Member1_BubbleSort {

    public static SortResult bubbleSort(int[] arr) {
        int[] data = arr.clone();
        long startTime = System.nanoTime();
        int steps = 0;

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                steps++;
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();
        double timeMs = (endTime - startTime) / 1_000_000.0;
        return new SortResult("Bubble Sort", data, timeMs, steps);
    }
}

