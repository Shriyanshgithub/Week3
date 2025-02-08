package org.capgemini.Day6_Assignment.Problem_6;

import java.util.*;

public class CompareDataStructuresForSearching {

    public static void main(String[] args) {
        // Define dataset sizes
        int[] datasetSizes = {1000, 100000, 1000000};
        Random random = new Random();

        // Perform comparison for each dataset size
        for (int size : datasetSizes) {
            System.out.println("Dataset size: " + size);

            // Generate a dataset of random integers
            int[] dataArray = new int[size];
            for (int i = 0; i < size; i++) {
                dataArray[i] = random.nextInt(size * 10); // Random values within a range
            }

            // Convert dataset into HashSet and TreeSet
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int value : dataArray) {
                hashSet.add(value);
                treeSet.add(value);
            }

            // Define a target value to search for
            int target = dataArray[random.nextInt(size)];

            // Test Array search
            long startTime = System.nanoTime();
            boolean resultArray = linearSearch(dataArray, target);
            long endTime = System.nanoTime();
            System.out.println("Array Search Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

            // Test HashSet search
            startTime = System.nanoTime();
            boolean resultHashSet = hashSet.contains(target);
            endTime = System.nanoTime();
            System.out.println("HashSet Search Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

            // Test TreeSet search
            startTime = System.nanoTime();
            boolean resultTreeSet = treeSet.contains(target);
            endTime = System.nanoTime();
            System.out.println("TreeSet Search Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

            System.out.println();
        }
    }

    // Linear search for Array (O(N))
    public static boolean linearSearch(int[] array, int target) {
        for (int value : array) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }
}

