package datasorter;

import java.util.*;

public class Member4_DataSorterApp {

    static Scanner sc = new Scanner(System.in);
    static int[] dataset = new int[0];

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = getIntInput();

            switch (choice) {
                case 1 -> enterNumbers();
                case 2 -> generateRandomNumbers();
                case 3 -> displayResult(Member1_BubbleSort.bubbleSort(dataset));
                case 4 -> displayResult(Member2_MergeSort.mergeSort(dataset));
                case 5 -> displayResult(Member3_QuickSort.quickSort(dataset));
                case 6 -> compareAll();
                case 7 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice, please try again!");
            }

        } while (choice != 7);
    }

    static void enterNumbers() {
        System.out.print("Enter numbers separated by spaces: ");
        sc.nextLine(); // clear buffer
        String[] input = sc.nextLine().trim().split("\\s+");
        dataset = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        System.out.println("✅ Data successfully entered!");
    }

    static void generateRandomNumbers() {
        System.out.print("Enter dataset size: ");
        int size = getIntInput();
        System.out.print("Enter max number value: ");
        int max = getIntInput();
        Random rand = new Random();
        dataset = rand.ints(size, 0, max + 1).toArray();
        System.out.println("✅ Random dataset generated: " + Arrays.toString(dataset));
    }

    static void compareAll() {
        if (checkDataset()) return;

        SortResult b = Member1_BubbleSort.bubbleSort(dataset);
        SortResult m = Member2_MergeSort.mergeSort(dataset);
        SortResult q = Member3_QuickSort.quickSort(dataset);

        System.out.println("\n--- Performance Comparison Table ---");
        System.out.printf("%-15s %-15s %-10s\n", "Algorithm", "Time (ms)", "Steps");
        System.out.println("-----------------------------------------");
        System.out.printf("%-15s %-15.4f %-10d\n", b.name, b.timeMs, b.steps);
        System.out.printf("%-15s %-15.4f %-10d\n", m.name, m.timeMs, m.steps);
        System.out.printf("%-15s %-15.4f %-10d\n", q.name, q.timeMs, q.steps);
    }

    static void displayResult(SortResult result) {
        if (checkDataset()) return;
        System.out.println("\n" + result.name + " Result:");
        System.out.println("Sorted Data: " + Arrays.toString(result.sortedData));
        System.out.printf("Execution Time: %.4f ms\n", result.timeMs);
        System.out.println("Step Count: " + result.steps);
    }

    static boolean checkDataset() {
        if (dataset.length == 0) {
            System.out.println("⚠ Please enter or generate data first!");
            return true;
        }
        return false;
    }

    static int getIntInput() {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
