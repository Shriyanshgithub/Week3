package Day4.LinearSearch.Problem_2;

public class SearchWordInSentence {
    public static void main(String[] args) {
        // Array of sentences to search in
        String[] str = {"my name is shriyansh", "but is it really shriyansh?", "i guess i am", "my full name is shriyansh gupta"};
        String target = "shriyansh";  // The target word to search for

        // Loop through each sentence in the array
        for(String string: str){
            string = string.trim();  // Remove any leading or trailing whitespace
            String[] words = string.split("\s+");  // Split the sentence into words based on whitespace

            // Call the FindTheWord method to check if the target word exists in the sentence
            boolean result = FindTheWord(words , target);
            // If the target word is found, print the sentence
            if(result){
                System.out.println(string);
            }
        }
    }

    // Method to check if the target word exists in the array of words
    static boolean FindTheWord(String[] words , String target){
        // Loop through each word in the array
        for(String wordOfArray : words){
            // If the word matches the target exactly, return true
            if(wordOfArray.equals(target)){
                return true;
            }
            // Check if the word is longer than the target and if the character after the target is within a certain range
            else if (wordOfArray.length() > target.length()) {
                // If the word's character at target.length() index is a lowercase letter, consider it a match
                if(wordOfArray.charAt(target.length()) > 97 || wordOfArray.charAt(target.length()) < 122 ){
                    return true;
                }
            }
        }
        // Return false if the target word is not found
        return false;
    }
}
