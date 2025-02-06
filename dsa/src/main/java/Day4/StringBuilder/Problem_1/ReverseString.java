package Day4.StringBuilder.Problem_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {
    public static void main(String[] args) throws IOException {
        // Initialized the StringBuilder to hold and manipulate the string
        StringBuilder sb = new StringBuilder();

        // Created a BufferedReader to read input from the console
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        // Prompt the user to enter a string
        System.out.println("Enter the string");

        // Read the input string from the user
        String str = buffer.readLine();

        // Append the entered string to the StringBuilder
        sb.append(str);

        // Reverse the string using the reverse() method of StringBuilder
        sb.reverse();

        // Print the reversed string
        System.out.println(sb.toString());
    }
}
