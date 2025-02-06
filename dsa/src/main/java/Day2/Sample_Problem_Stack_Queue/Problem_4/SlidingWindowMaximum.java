package Day2.Sample_Problem_Stack_Queue.Problem_4;


import java.util.PriorityQueue;
import java.util.Scanner;

class SlidingWindow {

    public int[] maximumNumberInQueue(int[] arr, int n, int k) {
        int[] result = new int[n - k + 1]; // Output array to store max of each window
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b-a); // Max-Heap (Descending Order)

        // Iterate through each window
        for (int i = 0; i <= n - k; i++) {
            queue.clear(); // Clear the heap for the new window

            // Add elements of the current window to the max-heap
            for (int j = i; j < i + k; j++) {
                queue.add(arr[j]);
            }

            // The top element of max-heap is the maximum for this window
            result[i] = queue.peek();
        }
        return result;
    }
}

public class SlidingWindowMaximum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input: Size of array
        System.out.println("Enter the size of array:");
        int size = sc.nextInt();
        int[] arr = new int[size];

        // Input: Array elements
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the value " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }

        // Input: Window size (k)
        System.out.println("Enter the window size:");
        int k = sc.nextInt();

        // Compute sliding window maximum
        int[] ans = new SlidingWindow().maximumNumberInQueue(arr, size, k);

        // Output: Maximum elements in each window
        System.out.println("Maximum element in each window:");
        for (int i : ans) {
            System.out.print(i + "  ");
        }
    }
}


