package Day4.BinarySearch.Problem_2;

public class PeakElementFinder {
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // Prevent overflow

            // Compare middle element with its neighbors
            if (arr[mid] > arr[mid + 1]) {
                // If arr[mid] is greater than the next element,
                // the peak lies in the left half (including mid)
                right = mid;
            } else {
                // Otherwise, the peak lies in the right half (excluding mid)
                left = mid + 1;
            }
        }

        // At the end of the loop, left == right and points to a peak element
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int peakIndex = findPeakElement(arr);
        System.out.println("Peak Element Index: " + peakIndex);
        System.out.println("Peak Element Value: " + arr[peakIndex]);
    }
}
