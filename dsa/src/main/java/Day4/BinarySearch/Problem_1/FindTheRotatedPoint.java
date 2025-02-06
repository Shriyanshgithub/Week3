package Day4.BinarySearch.Problem_1;

import java.util.Scanner;


public class FindTheRotatedPoint{
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // Prevent overflow

            // Check if the smallest element is in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                // Otherwise, it's in the left half
                right = mid;
            }
        }
        // At the end of the loop, left == right and points to the rotation point
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int rotationPointIndex = findRotationPoint(arr);
        System.out.println("Rotation Point Index: " + rotationPointIndex);
        System.out.println("Rotation Point Value: " + arr[rotationPointIndex]);
    }
}

