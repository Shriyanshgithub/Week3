package Day2.SampleProblemOfHashMap.Problem_2;

import java.util.HashMap;
import java.util.Scanner;

public class CheckPairSumArray {

    // Method to find and print pairs that sum up to the target value
    public static void PairSum(int[] arr, int target) {
        // HashMap to store the elements and their corresponding indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Loop through the array
        for (int i = 0; i < arr.length; i++) {
            // Calculate the complement of the current element (what we need to sum up to the target)
            int num = target - arr[i];

            // Check if the complement exists in the map
            if (map.containsKey(num)) {
                // If the complement exists, print the pair
                // map.get(num) gives the index of the previous occurrence of the complement
                System.out.println("Pair exists from " + map.get(num) + " to " + i);
            }

            // Store the current element and its index in the map
            map.put(arr[i], i);
        }
    }

    // Main method to take input from the user and call PairSum method
    public static void main(String[] args) {
        // Create a scanner object to read input
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter the size of the array
        System.out.println("Enter the size of array ");
        int size = sc.nextInt();

        // Initialize an array of the specified size
        int[] arr = new int[size];

        // Prompt the user to enter the elements of the array
        System.out.println("Enter the elements in ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Prompt the user to enter the target sum
        System.out.println("Enter the target element ");
        int target = sc.nextInt();

        // Call the PairSum method to find pairs that sum up to the target
        PairSum(arr, target);
    }
}

