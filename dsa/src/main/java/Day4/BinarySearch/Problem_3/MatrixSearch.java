package Day4.BinarySearch.Problem_3;

public class MatrixSearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Treat the 2D matrix as a 1D array
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Convert 1D index to 2D indices
            int row = mid / cols;
            int col = mid % cols;

            // Get the middle element
            int midElement = matrix[row][col];

            // Compare the middle element with the target
            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }

        // If we exhaust the search space and don't find the target
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;

        boolean result = searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + result);

        target = 13;
        result = searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + result);
    }
}
