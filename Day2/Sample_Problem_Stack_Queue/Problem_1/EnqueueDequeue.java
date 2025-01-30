package Day2.Sample_Problem_Stack_Queue.Problem_1;

import java.util.Scanner;
import java.util.Stack;

// Define a Queue class that uses two stacks to implement a queue
class Queue {
    private Stack<Integer> enqueue; // Stack used for enqueue operations
    private Stack<Integer> dequeue; // Stack used for dequeue operations

    // Constructor to initialize the two stacks
    public Queue() {
        enqueue = new Stack<>();
        dequeue = new Stack<>();
    }

    // Method to add an element to the queue (enqueue operation)
    public void offer(int value) {
        enqueue.push(value); // Push the value onto the enqueue stack
    }

    // Method to remove and return an element from the queue (dequeue operation)
    public int poll() {
        // If the dequeue stack is empty, transfer elements from the enqueue stack to the dequeue stack
        if (dequeue.isEmpty()) {
            // If both stacks are empty, the queue is empty
            if (enqueue.isEmpty()) {
                System.out.println("Queue is empty");
                return -1; // Return -1 to indicate the queue is empty
            }
            // Transfer all elements from the enqueue stack to the dequeue stack
            while (!enqueue.isEmpty()) {
                dequeue.push(enqueue.pop());
            }
        }
        // Pop and return the top element from the dequeue stack
        return dequeue.pop();
    }
}

// Main class to test the Queue implementation
public class EnqueueDequeue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an instance of the Queue
        Queue queue = new Queue();

        // Enqueue 5 elements into the queue
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter the value: ");
            int value = sc.nextInt();
            queue.offer(value); // Add the value to the queue
        }

        // Dequeue 5 elements from the queue and print them
        for (int i = 0; i < 5; i++) {
            System.out.println("Get the element from Queue: " + queue.poll());
        }

        sc.close(); // Close the scanner to free resources
    }
}