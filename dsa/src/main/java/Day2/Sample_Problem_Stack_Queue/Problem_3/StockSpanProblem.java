package Day2.Sample_Problem_Stack_Queue.Problem_3;




import java.util.Scanner;
import java.util.Stack;

// Class to calculate stock span for each day
class StokeSpan {

    public int[] calculateSpanArray(int[] price, int n) {
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>(); // Stack to store indices

        st.push(0); // Push index of first price onto the stack
        span[0] = 1; // Span of first day is always 1

        // Loop through the price array from day 1 to day n-1
        for (int i = 1; i < n; i++) {
            // Remove all elements from stack where price is less than or equal to current price
            while (!st.isEmpty() && price[st.peek()] <= price[i]) {
                st.pop();
            }

            // If stack is empty, span is entire range (i+1), else span is difference of indices
            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - st.peek();
            }


            // Push the current index onto the stack
            st.push(i);
        }
        return span; // Return the calculated span array
    }
}

public class StockSpanProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6]; // Array to store user-input stock prices

        // Input stock prices for 6 days
        for (int i = 0; i < 6; i++) {
            System.out.println("Enter the price of stock on day " + (i + 1));
            arr[i] = sc.nextInt();
        }

        // Calculate stock span using StokeSpan class
        int[] ans = new StokeSpan().calculateSpanArray(arr, 6);

        // Display the calculated stock span
        System.out.println("Stock span result: ");
        for (int i : ans) {
            System.out.print(i + "  ");
        }
    }
}
