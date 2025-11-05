package datasorter;

public class SortResult {
    String name;
    int[] sortedData;
    double timeMs;
    int steps;

    public SortResult(String name, int[] sortedData, double timeMs, int steps) {
        this.name = name;
        this.sortedData = sortedData;
        this.timeMs = timeMs;
        this.steps = steps;
    }
}