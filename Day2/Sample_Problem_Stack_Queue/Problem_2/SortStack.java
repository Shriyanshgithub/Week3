package Day2.Sample_Problem_Stack_Queue.Problem_2;

//Sort a Stack Using Recursion
//Problem: Given a stack, sort its elements in ascending order using recursion.
//Hint: Pop elements recursively, sort the remaining stack, and insert the popped element back at the correct position.


import java.util.Stack;

import java.util.Stack;

public class SortStack {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        // Base case: If stack is empty or has only one element, it's already sorted
        if (stack.isEmpty()) {
            return;
        }

        // Pop the top element from the stack
        int topElement = stack.pop();

        // Recursively sort the remaining stack
        sortStack(stack);

        // Insert the popped element back in sorted order
        insertSorted(stack, topElement);
    }

    // Helper function to insert an element in the sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        // Base case: If stack is empty or element is greater than the top element
        if (stack.isEmpty() || element >= stack.peek()) {
            stack.push(element);
            return;
        }

        // Otherwise, pop the top element and recurse
        int temp = stack.pop();

        // Recursively insert the element in the sorted part of the stack
        insertSorted(stack, element);

        // Push the popped element back to the stack
        stack.push(temp);
    }

    // Main function to test the sorting
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}

