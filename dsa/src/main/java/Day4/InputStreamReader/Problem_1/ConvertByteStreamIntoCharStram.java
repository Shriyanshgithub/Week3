package Day4.InputStreamReader.Problem_1;

import java.io.*;

public class ConvertByteStreamIntoCharStram {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        // Path of the file to be read
        String FilePath = "C:/Users/HP/Desktop/dsa/src/main/java/Day4/FileReader/Problem_1/text.txt";

        // Creating an InputStreamReader to convert byte stream into character stream with UTF-8 encoding
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(FilePath ), "UTF-8");

        // Using try-with-resources to automatically close BufferedReader after use
        try(BufferedReader bufferedReader = new BufferedReader(inputStreamReader)){
            // String variable to hold each line read from the file
            String name;

            // Reading the file line by line while there are more lines to read
            while(bufferedReader.ready()){
                name = bufferedReader.readLine(); // Read a line from the file
                System.out.println(name); // Print the line to the console
            }
        }
        // Catching any IOExceptions that might occur during the file reading process
        catch (IOException e){
            e.printStackTrace(); // Print the stack trace if an exception occurs
        }

    }
}
