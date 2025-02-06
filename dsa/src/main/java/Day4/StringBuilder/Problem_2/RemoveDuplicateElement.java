package Day4.StringBuilder.Problem_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class RemoveDuplicateElement {
    public static void main(String[] args) throws IOException {
        // Initialized the StringBuilder to hold and manipulate the string
        StringBuilder sb = new StringBuilder();

        //Initialized the Hashset that store unique element
        HashSet<Character> set = new HashSet<>();

        // Created a BufferedReader to read input from the console
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        // Prompt the user to enter a string
        System.out.println("Enter the string");

        // Read the input string from the user
        String str = buffer.readLine();
        sb.append(str);

        //for loop to access the each character of String
        for(int i=0; i<sb.length(); i++){
            //Check element present in set or not
           if(set.contains(sb.charAt(i))){
               //delete duplicate character
               sb.deleteCharAt(i);
           }
           else{
               //Add character in set
               set.add(sb.charAt(i));
           }
        }
        System.out.println(sb);
    }
}
