package Day2.Sample_Problem_Stack_Queue.Problem_5;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class CircularTourWithQueue {

    public int findStartingPoint(int[] petrol, int[] distance, int n) {
        // Queue to simulate the circular tour
        Queue<Integer> queue = new LinkedList<>();
        int currentSurplus = 0;  // Petrol surplus as we move through the tour
        int totalSurplus = 0;  // Total surplus petrol to determine if the tour is possible
        int startIndex = 0;  // The potential starting point

        // Traverse through all petrol pumps
        for (int i = 0; i < n; i++) {
            int netPetrol = petrol[i] - distance[i]; // Petrol surplus at each pump

            currentSurplus += netPetrol;  // Add to the current surplus
            totalSurplus += netPetrol;  // Add to the total surplus

            // If the current surplus becomes negative, reset the tour and start from the next pump
            if (currentSurplus < 0) {
                // Remove the pumps from the queue until the surplus is non-negative
                while (!queue.isEmpty()) {
                    queue.poll();
                }

                // Set the new start index to the next pump
                startIndex = i + 1;
                currentSurplus = 0; // Reset current surplus
            }
            // Enqueue the current petrol pump to the queue
            queue.offer(i);
        }

        // If the total surplus is negative, it's impossible to complete the tour
        if (totalSurplus < 0) {
            return -1;
        }
        // Otherwise, return the starting index
        return startIndex;
    }
}

public class CircularTourProblemWithQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of petrol pumps
        System.out.println("Enter the number of petrol pumps:");
        int n = sc.nextInt();

        int[] petrol = new int[n];
        int[] distance = new int[n];

        // Input: Petrol available at each pump
        System.out.println("Enter the petrol available at each pump:");
        for (int i = 0; i < n; i++) {
            petrol[i] = sc.nextInt();
        }

        // Input: Distance to the next pump
        System.out.println("Enter the distance to the next pump:");
        for (int i = 0; i < n; i++) {
            distance[i] = sc.nextInt();
        }

        // Compute starting index
        CircularTourWithQueue ct = new CircularTourWithQueue();
        int start = ct.findStartingPoint(petrol, distance, n);

        // Output the result
        if (start == -1) {
            System.out.println("It is not possible to complete the circular tour.");
        } else {
            System.out.println("Start the tour from petrol pump index: " + start);
        }
    }
}

