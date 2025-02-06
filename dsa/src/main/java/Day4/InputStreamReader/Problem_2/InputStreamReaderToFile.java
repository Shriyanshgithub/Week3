package Day4.InputStreamReader.Problem_2;

import java.io.*;

public class InputStreamReaderToFile {
    public static void main(String[] args) {
        // Define the path where the file will be saved
        String filePath = "C:/Users/HP/Desktop/dsa/src/main/java/Day4/FileReader/Problem_1/text.txt";

        // Creating an InputStreamReader to read from the console (System.in)
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        // Wrapping the InputStreamReader with BufferedReader for efficient reading
        try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             // Creating a FileWriter to write to the file, and enabling append mode
             FileWriter fileWriter = new FileWriter(filePath, true);
             // Wrapping the FileWriter with BufferedWriter for efficient writing
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            String userInput;

            System.out.println("Enter your input (type 'exit' to stop):");

            // Read user input line by line
            while (true) {
                // Reading a line of user input
                userInput = bufferedReader.readLine();

                // If user enters "exit", stop reading and writing
                if ("exit".equalsIgnoreCase(userInput)) {
                    System.out.println("Exiting...");
                    break;
                }

                // Write the user input to the file with a new line
                bufferedWriter.write(userInput);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            // Handle any I/O exceptions
            e.printStackTrace();
        }
    }
}

