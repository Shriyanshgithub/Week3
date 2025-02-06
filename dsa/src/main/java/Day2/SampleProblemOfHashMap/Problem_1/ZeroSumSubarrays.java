package Day2.SampleProblemOfHashMap.Problem_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZeroSumSubarrays {

    // Method to find all subarrays with zero sum
    public static List<List<Integer>> findZeroSumSubarrays(int[] arr) {
        // List to store all the subarrays with zero sum
        List<List<Integer>> result = new ArrayList<>();

        // HashMap to store the cumulative sum and their corresponding indices
        HashMap<Integer, List<Integer>> sumMap = new HashMap<>();

        // Initialize the hash map with sum 0 and an empty list (to handle subarrays that sum to 0 from the start)
        sumMap.put(0, new ArrayList<>());

        // Cumulative sum to track the sum up to each index
        int currentSum = 0;

        // Traverse the array to find all subarrays
        for (int i = 0; i < arr.length; i++) {
            // Update the cumulative sum
            currentSum += arr[i];

            // If the cumulative sum has been seen before, then we have found zero-sum subarrays
            if (sumMap.containsKey(currentSum)) {
                // Get all indices where this cumulative sum has occurred before
                List<Integer> indices = sumMap.get(currentSum);

                // For each such index, create a subarray and add it to the result
                for (int index : indices) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = index + 1; j <= i; j++) {
                        subarray.add(arr[j]);
                    }
                    result.add(subarray);
                }
            }

            // Add the current index to the map for this cumulative sum
            sumMap.putIfAbsent(currentSum, new ArrayList<>());
            sumMap.get(currentSum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, -1, 3, -3, 4, -2, 2, -4};  // Example input array

        // Find all subarrays with zero sum
        List<List<Integer>> subarrays = findZeroSumSubarrays(arr);

        // Print the subarrays
        System.out.println("Subarrays with zero sum:");
        for (List<Integer> subarray : subarrays) {
            System.out.println(subarray);
        }
    }
}
