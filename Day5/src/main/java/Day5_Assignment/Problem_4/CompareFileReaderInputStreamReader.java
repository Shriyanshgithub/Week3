package Day5.Problem_4;

import java.io.*;

public class CompareFileReaderInputStreamReader {
    public static void main(String[] args) throws FileNotFoundException {
        // Define the file and its path
        File file = new File("C:/Users/HP/Desktop/Week3/Day5/src/main/java/Day5/Problem_4/file.txt");
        int size = 500; // Number of repetitions for writing
        int number = 500 * 1024; // Total size of data to write
        String FilePath = "C:/Users/HP/Desktop/Week3/Day5/src/main/java/Day5/Problem_4/file.txt";

        // Write data to the file
        try (FileWriter fileWriter = new FileWriter(FilePath)) {
            for (int i = 1; i < number; i++) {
                // Write "Hello" repeatedly
                fileWriter.write("Hello");
            }
        } catch (IOException e) {
            // Handle file write exceptions
            e.printStackTrace();
        }

        // Measure and print time taken by FileReader
        long readTimeOfFileReader = PerformanceOfFileReader(FilePath);
        System.out.println("The time required by the fileReader to read the file is : " + readTimeOfFileReader);

        // Measure and print time taken by InputStreamReader
        long readTimeOfInputStreamReader = PerformanceOfInputStreamReader(FilePath);
        System.out.println("The time required by the InputStreamReader to read the file is : " + readTimeOfInputStreamReader);
    }

    // Measure time taken to read the file using FileReader
    public static long PerformanceOfFileReader(String FilePath) throws FileNotFoundException {
        // Start timing
        long startTime = System.nanoTime();

        try (FileReader fileReader = new FileReader(FilePath)) {
            // Read the file
            fileReader.read();
        } catch (IOException e) {
            // Handle file read exceptions
            e.printStackTrace();
        }

        // End timing
        long endTime = System.nanoTime();

        // Return time in microseconds
        return (endTime - startTime) / 1000;
    }

    // Measure time taken to read the file using InputStreamReader
    public static long PerformanceOfInputStreamReader(String FilePath) {
        // Start timing
        long startTime = System.nanoTime();

        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(FilePath), "UTF-8")) {
            // Read the file
            inputStreamReader.read();
        } catch (IOException e) {
            // Handle file read exceptions
            e.printStackTrace();
        }

        // End timing
        long endTime = System.nanoTime();

        // Return time in microseconds
        return (endTime - startTime) / 1000;
    }
}
