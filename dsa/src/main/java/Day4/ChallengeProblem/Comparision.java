package Day4.ChallengeProblem;

import java.io.*;
import java.util.Arrays;

public class Comparision {

    private static long calculateTimeOfStringBuilder(StringBuilder stringBuilder, String[] str) {
        // Record the start time in nanoseconds
        long startTime = System.nanoTime();

        // Loop through each string in the array and append it to the StringBuilder
        for (int i = 0; i < str.length; i++) {
            stringBuilder.append(str[i]);
        }

        // Record the end time in nanoseconds
        long endTime = System.nanoTime();

        // Return the time taken for concatenation
        return endTime - startTime;
    }

    // Method to calculate the time taken by StringBuffer to concatenate strings
    private static long calculateTimeOfStringBufferr(StringBuffer stringBuffer, String[] str) {
        // Record the start time in nanoseconds
        long startTime = System.nanoTime();

        // Loop through each string in the array and append it to the StringBuffer
        for (int i = 0; i < str.length; i++) {
            stringBuffer.append(str[i]);
        }

        // Record the end time in nanoseconds
        long endTime = System.nanoTime();

        // Return the time taken for concatenation
        return endTime - startTime;
    }


    // Method to read a file using FileReader and calculate time taken for reading and word count
    static void ReadFileByFileReader(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();  // StringBuilder to store file content
        int count = 0;  // Variable to count words
        long startTime = System.nanoTime();  // Start time for measuring read time
        FileReader fileReader = new FileReader(filePath);  // Create FileReader object
        char ch;  // Variable to store each character

        // Loop to read the file character by character
        while ((fileReader.read()) != -1) {
            ch = (char) fileReader.read();  // Read a character and cast it to char
            sb.append(ch);  // Append the character to StringBuilder
        }

        long endTime = System.nanoTime();  // End time for measuring read time
        System.out.println("The time of FileReader is: " + (endTime - startTime));  // Print time taken
        String[] str = sb.toString().split("\s+");  // Split the content into words using whitespace as a delimiter
        // Count the number of words in the file
        for (String string : str) {
            count++;
        }
        System.out.println("The number of word is : " + count);  // Print the word count
    }

    // Method to read a file using InputStreamReader and calculate time taken for reading and word count
    static void ReadFileInputStreamReader(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();  // StringBuilder to store file content
        int count = 0;  // Variable to count words
        long startTime = System.nanoTime();  // Start time for measuring read time
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));  // Create InputStreamReader object
        char ch;  // Variable to store each character

        // Loop to read the file character by character
        while (inputStreamReader.read() != -1) {
            ch = (char) inputStreamReader.read();  // Read a character and cast it to char
            sb.append(ch);  // Append the character to StringBuilder
        }

        long endTime = System.nanoTime();  // End time for measuring read time
        System.out.println("The time of InputStreamReader is: " + (endTime - startTime));  // Print time taken
        String[] str = sb.toString().split("\s+");  // Split the content into words using whitespace as a delimiter
        // Count the number of words in the file
        for (String string : str) {
            count++;
        }
        System.out.println("The number of word is : " + count);  // Print the word count
    }

    // Main method to execute file reading and String concatenation time calculation
    public static void main(String[] args) throws IOException {
        // Create an instance of StringBuilder and StringBuffer
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();

        // Create an array of 1,000,000 strings, all initialized to "Hello"
        String[] str = new String[1000000];
        Arrays.fill(str, "Hello");

        // Calculate the time taken by StringBuilder to concatenate the strings
        long timeOfStringBuilder = calculateTimeOfStringBuilder(stringBuilder, str);
        System.out.println("The time of String Builder is : " + timeOfStringBuilder);  // Print time taken by StringBuilder

        // Calculate the time taken by StringBuffer to concatenate the strings
        long timeOfStringBuffer = calculateTimeOfStringBufferr(stringBuffer, str);
        System.out.println("The time of String Buffer is : " + timeOfStringBuffer);  // Print time taken by StringBuffer

        // Define the file path for reading
        String FilePath = "C:/Users/HP/Desktop/dsa/src/main/java/Day4/ChallengeProblem/file.txt";

        // Call the method to read the file using FileReader
        ReadFileByFileReader(FilePath);

        // Call the method to read the file using InputStreamReader
        ReadFileInputStreamReader(FilePath);
    }
}

