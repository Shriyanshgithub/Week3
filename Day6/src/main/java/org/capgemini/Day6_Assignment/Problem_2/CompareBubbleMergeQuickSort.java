package org.capgemini.Day6_Assignment.Problem_2;

import java.util.Arrays;
import java.util.Random;

public class CompareBubbleMergeQuickSort {

    public static void main(String[] args) {
        // Define dataset sizes for testing
        int[] datasetSizes = {1000, 10000, 100000};
        Random random = new Random();

        // Perform sorting comparisons for each dataset size
        for (int size : datasetSizes) {
            System.out.println("Dataset size: " + size);

            // Generate a random dataset
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size * 10); // Random values within a large range
            }

            // Test Bubble Sort
            int[] bubbleSortData = Arrays.copyOf(data, data.length); // Copy of the dataset
            long startTime = System.nanoTime();
            bubbleSort(bubbleSortData);
            long endTime = System.nanoTime();
            System.out.println("Bubble Sort Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

            // Test Merge Sort
            int[] mergeSortData = Arrays.copyOf(data, data.length); // Copy of the dataset
            startTime = System.nanoTime();
            mergeSort(mergeSortData, 0, mergeSortData.length - 1);
            endTime = System.nanoTime();
            System.out.println("Merge Sort Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

            // Test Quick Sort
            int[] quickSortData = Arrays.copyOf(data, data.length); // Copy of the dataset
            startTime = System.nanoTime();
            quickSort(quickSortData, 0, quickSortData.length - 1);
            endTime = System.nanoTime();
            System.out.println("Quick Sort Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

            System.out.println();
        }
    }

    // Bubble Sort (O(N²))
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Break if no elements were swapped in the inner loop
            if (!swapped) {
                break;
            }
        }
    }

    // Merge Sort (O(N log N))
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively divide the array
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data into temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // Merge the temporary arrays
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k++] = leftArray[i++];
        }
        while (j < n2) {
            arr[k++] = rightArray[j++];
        }
    }

    // Quick Sort (O(N log N))
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array
            int pivotIndex = partition(arr, low, high);

            // Recursively sort the left and right partitions
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the last element as the pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return the pivot index
    }
}

