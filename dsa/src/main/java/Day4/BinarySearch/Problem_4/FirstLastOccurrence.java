package Day4.BinarySearch.Problem_4;

public class FirstLastOccurrence {
    // Function to find the first occurrence of the target
    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int firstOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                firstOccurrence = mid; // Record the occurrence
                right = mid - 1; // Continue searching the left side
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return firstOccurrence;
    }

    // Function to find the last occurrence of the target
    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int lastOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                lastOccurrence = mid; // Record the occurrence
                left = mid + 1; // Continue searching the right side
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastOccurrence;
    }

    // Main function to find first and last occurrence
    public static int[] findFirstAndLast(int[] arr, int target) {
        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        if (first == -1 || last == -1) {
            return new int[]{-1, -1}; // Target not found
        }

        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 6, 6, 8};
        int target = 4;

        int[] result = findFirstAndLast(arr, target);
        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);

        target = 5;
        result = findFirstAndLast(arr, target);
        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
    }
}
