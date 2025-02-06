package Day4.FileReader.Problem_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLine {
    public static void main(String[] args) {
        // Path to the file that needs to be read
        String filePath = "C:/Users/HP/Desktop/dsa/src/main/java/Day4/FileReader/Problem_1/text.txt";

        // Try-with-resources to automatically close the BufferedReader after use
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String name; // Variable to hold each line read from the file

            // Loop to read each line from the file until the end is reached
            while ((name = bufferedReader.readLine()) != null) {
                // Print the current line to the console
                System.out.println(name);
            }
        } catch (IOException e) {
            // Catch and print any IOExceptions that occur while reading the file
            e.printStackTrace();
        }
    }
}
