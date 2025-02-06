package Day2.SampleProblemOfHashMap.Problem_3;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        // If the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }

        // Use a HashSet to store unique elements from the array
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        // Iterate over each element in the set
        for (int num : set) {
            // Only start counting if `num - 1` is not in the set (i.e., `num` is the start of a sequence)
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Keep checking for the next consecutive number
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak found so far
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive sequence length: " + longestConsecutive(nums));
    }
}

