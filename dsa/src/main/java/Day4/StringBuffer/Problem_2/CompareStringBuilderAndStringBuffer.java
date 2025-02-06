package Day4.StringBuffer.Problem_2;

import java.util.Arrays;

public class CompareStringBuilderAndStringBuffer {
    // Method to calculate the time taken by StringBuilder to concatenate strings
    private static long calculateTimeOfStringBuilder(StringBuilder stringBuilder , String[] str ){
        // Record the start time in nanoseconds
        long startTime  = System.nanoTime();

        // Loop through each string in the array and append it to the StringBuilder
        for(int i = 0; i < str.length; i++){
            stringBuilder.append(str[i]);
        }

        // Record the end time in nanoseconds
        long endTime = System.nanoTime();

        // Return the time taken for concatenation
        return endTime - startTime;
    }

    // Method to calculate the time taken by StringBuffer to concatenate strings
    private static long calculateTimeOfStringBufferr(StringBuffer stringBuffer , String[] str ){
        // Record the start time in nanoseconds
        long startTime  = System.nanoTime();

        // Loop through each string in the array and append it to the StringBuffer
        for(int i = 0; i < str.length; i++){
            stringBuffer.append(str[i]);
        }

        // Record the end time in nanoseconds
        long endTime = System.nanoTime();

        // Return the time taken for concatenation
        return endTime - startTime;
    }

    public static void main(String[] args) {
        // Create an instance of StringBuilder and StringBuffer
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();

        // Create an array of 1,000,000 strings, all initialized to "Hello"
        String[] str = new String[1000000];
        Arrays.fill(str , "Hello");

        // Calculate the time taken by StringBuilder to concatenate the strings
        long timeOfStringBuilder = calculateTimeOfStringBuilder(stringBuilder, str);
        System.out.println("The time of String Builder is : " + timeOfStringBuilder);

        // Calculate the time taken by StringBuffer to concatenate the strings
        long timeOfStringBuffer = calculateTimeOfStringBufferr(stringBuffer, str);
        System.out.println("The time of String Buffer is : " + timeOfStringBuffer);
    }
}
