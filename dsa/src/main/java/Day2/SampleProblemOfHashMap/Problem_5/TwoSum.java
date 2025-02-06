package Day2.SampleProblemOfHashMap.Problem_5;

import java.util.HashMap;

public class TwoSum {

    // Method to find two indices whose values add up to the target
    public static int[] twoSum(int[] nums, int target) {
        // HashMap to store the element and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  // Calculate the complement

            // If the complement is found in the map, return the pair of indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Otherwise, store the current element in the map with its index
            map.put(nums[i], i);
        }

        // If no solution is found, return an empty array (or handle error as needed)
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};  // Example input array
        int target = 9;  // Example target sum

        // Find two indices whose values sum to the target
        int[] result = twoSum(nums, target);

        // Output the result (indices of the two numbers that add up to the target)
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}

