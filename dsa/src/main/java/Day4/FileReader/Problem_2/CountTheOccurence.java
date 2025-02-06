package Day4.FileReader.Problem_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class CountTheOccurence {
    public static void main(String[] args) {
        // Asking the user for the target string
        System.out.println("Give the target string");

        // Reading the target string from user input
        String target = new Scanner(System.in).next();

        // StringBuilder to hold the content read from the file
        StringBuilder sb = new StringBuilder();

        // File path for reading the text file
        String FilePath = "C:/Users/HP/Desktop/dsa/src/main/java/Day4/FileReader/Problem_1/text.txt";

        // Reading the file using BufferedReader inside try-with-resources to ensure proper resource management
        try(BufferedReader bufferedReader =new BufferedReader(new FileReader(FilePath))){
            // Reading the file line by line and appending it to the StringBuilder
            while(bufferedReader.ready()){
                sb.append(bufferedReader.readLine()).append(' ');
            }
        }
        // Catching any IOExceptions that might occur during file reading
        catch (IOException e){
            e.printStackTrace();
        }

        // Calling the countOccurence method to count occurrences of the target string
        int count = countOccurence(sb.toString().trim() , target);

        // Printing the result
        System.out.println("Occurrence of target is : " + count);
    }

    // Method to count the occurrences of the target string in the given input string
    static int countOccurence(String s , String target){
        // Splitting the input string into words by spaces
        String[] str = s.split("\\s+");

        // Variable to hold the count of occurrences
        int count =0;

        // Iterating through each word in the split string array
        for(String strings : str){
            // Checking if the word starts with the target and has the same length
            if(strings.startsWith(target) && strings.length() == target.length()) count++;

                // Checking if the word starts with the target but is longer
            else if (strings.startsWith(target) && strings.length() > target.length()) {
                // Ensuring that the character right after the target string is not a letter (i.e., word boundary)
                if(strings.charAt(target.length()) < 97 || strings.charAt(target.length()) > 122){
                    count++;
                }
            }
        }
        // Returning the total count of occurrences
        return count;
    }
}
