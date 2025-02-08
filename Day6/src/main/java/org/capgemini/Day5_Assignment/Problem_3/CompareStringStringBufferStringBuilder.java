package org.capgemini.Day5_Assignment.Problem_3;

import java.util.Arrays;

public class CompareStringStringBufferStringBuilder {
    public static void main(String[] args) {
        // Create an array of 100,000 strings initialized with "Hello"
        String[] str = new String[1_00_000];
        Arrays.fill(str, "Hello");

        // Measure and print the performance of String concatenation
        long timeOfString = calculateStringPerformance(str);
        System.out.println("The time required to concat the string by String: " + timeOfString);

        // Measure and print the performance of StringBuilder concatenation
        long timeOfStringBuilder = calculateStringBuilderPerformance(str);
        System.out.println("The time required to concat the string by StringBuilder: " + timeOfStringBuilder);

        // Measure and print the performance of StringBuffer concatenation
        long timeOfStringBuffer = calculateStringBufferPerformance(str);
        System.out.println("The time required to concat the string by StringBuffer: " + timeOfStringBuffer);
    }

    // Measure time taken for String concatenation
    public static long calculateStringPerformance(String[] str) {
        String string = "";
        // Record start time
        long startTime = System.nanoTime();
        for (String s : str) {
            // Concatenate strings
            string = string.concat(s);
        }
        // Record end time
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    // Measure time taken for StringBuilder concatenation
    public static long calculateStringBuilderPerformance(String[] str) {
        StringBuilder sb = new StringBuilder();

        // Record start time
        long startTime = System.nanoTime();
        for (String s : str) {
            // Append strings
            sb.append(s);
        }
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    // Measure time taken for StringBuffer concatenation
    public static long calculateStringBufferPerformance(String[] str) {
        StringBuffer stringBuffer = new StringBuffer();

        // Record start time
        long startTime = System.nanoTime();
        for (String s : str) {
            // Append strings
            stringBuffer.append(s);
        }
        long endTime = System.nanoTime();

        return endTime - startTime; // Return time taken
    }
}
