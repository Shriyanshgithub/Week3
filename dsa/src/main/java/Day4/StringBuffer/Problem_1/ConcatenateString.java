package Day4.StringBuffer.Problem_1;

public class ConcatenateString {
    public static void main(String[] args) {
        // Initialize an array of strings to be concatenated
        String[] str = {"Hello" , "My",  "Name" , "Is" , "Shriyansh", "Gupta"};

        // Create a StringBuffer object to store the concatenated result
        StringBuffer sb = new StringBuffer();

        // Iterate through the array of strings
        for(int i = 0; i< str.length; i++){
            // Append each string from the array to the StringBuffer
            sb.append(str[i]);
        }

        // Convert the StringBuffer to a String
        String result = sb.toString();

        // Print the concatenated result
        System.out.println(result);
    }
}

