package org.capgemini.Day6_Assignment.Problem_1;



// Main class to compare the performance of Linear Search and Binary Search
public class CompareLinearSearchBinarySearch {
    public static void main(String[] args) {
        // Define different sizes for the datasets
        int[] size = {1000, 100000, 1000000}; // Array sizes for testing
        DataSet[] dataSets = new DataSet[size.length]; // Array of DataSet objects
        int index = 0; // Index to populate the dataSets array
        int num = 0; // Counter for traversing through datasets

        long startTime = 0; // Variable to store the start time of an operation
        long endTime = 0;   // Variable to store the end time of an operation

        // Generate datasets for each size
        for (int sizeOfArray : size) {
            dataSets[index++] = new DataSet(sizeOfArray); // Create DataSet object and add it to the array
        }

        // Iterate over each dataset to measure performance
        while (num < dataSets.length) {
            // Measure time for Linear Search
            startTime = System.nanoTime(); // Start time
            boolean result = performanceOfLinearSearch(dataSets[num].data); // Perform linear search
            endTime = System.nanoTime(); // End time
            System.out.println(result + " Time by Linear Search is: " + (endTime - startTime)); // Output time taken

            // Measure time for Binary Search
            startTime = System.nanoTime(); // Start time
            boolean result2 = performanceOfBinarySearch(dataSets[num].data); // Perform binary search
            endTime = System.nanoTime(); // End time
            System.out.println(result2 + " Time by Binary Search is: " + (endTime - startTime)); // Output time taken

            num++; // Move to the next dataset
        }
    }

    // Method to perform Linear Search on an array
    public static boolean performanceOfLinearSearch(int[] data) {
        int target = 20000000; // The target value to search for (not present in the dataset)
        // Traverse the array and check each element
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) { // If the target is found
                return true; // Return true
            }
        }
        return false; // Return false if the target is not found
    }

    // Method to perform Binary Search on an array
    public static boolean performanceOfBinarySearch(int[] data) {
        int low = 0; // Start of the search range
        int high = data.length - 1; // End of the search range
        int target = 500; // The target value to search for

        // Binary Search loop
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the mid-point of the range

            if (data[mid] == target) { // If the target is found at the mid-point
                return true; // Return true
            } else if (data[mid] < target) { // If the target is larger than the mid-point value
                low = mid + 1; // Narrow the search range to the right half
            } else { // If the target is smaller than the mid-point value
                high = mid - 1; // Narrow the search range to the left half
            }
        }
        return false; // Return false if the target is not found
    }
}

