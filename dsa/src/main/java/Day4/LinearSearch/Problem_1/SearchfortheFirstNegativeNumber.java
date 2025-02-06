package Day4.LinearSearch.Problem_1;

import java.util.Scanner;

public class SearchfortheFirstNegativeNumber {

    // Method to perform linear search and find the first negative number's index
    static int LinearSearch(int[] arr){
        // Loop through the array to find the first negative number
        for(int i = 0; i < arr.length; i++){
            // If a negative number is found, return its index
            if(arr[i] < 0) {
                return i;
            }
        }
        // Return -1 if no negative number is found in the array
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Create Scanner object for user input
        int[] array = new int[5];  // Create an array of size 5

        // Prompt the user to enter values for the array
        for(int i = 0; i < array.length; i++){
            System.out.println("Enter the value " + (i + 1));  // Ask user for input
            array[i] = input.nextInt();  // Store the entered value in the array
        }

        // Call the LinearSearch method to find the index of the first negative number
        int indexOfNegativeNumber = LinearSearch(array);

        // If no negative number is found, index will be -1
        if(indexOfNegativeNumber == -1){
            System.out.println(indexOfNegativeNumber);  // Print -1 if no negative number
        }
        else{
            // Print the index of the first negative number
            System.out.println("Index of first negative number : " + indexOfNegativeNumber);
        }
    }
}
