package org.capgemini.Day6_Assignment.Problem_5;


public class CompareRecursiveIterativeFibonacci {
    public static void main(String[] args) {
        int n = 40; // Reduced n for testing recursive (100000 is too large for naive recursion)
        long startTime;
        long endTime;

        // Recursive Fibonacci
        startTime = System.nanoTime();
        long recursiveResult = fibonacciRecursive(n);
        endTime = System.nanoTime();
        System.out.println("Recursive Fibonacci result: " + recursiveResult);
        System.out.println("Time taken by recursive: " + (endTime - startTime) + " ns");

        // Iterative Fibonacci
        startTime = System.nanoTime();
        long iterativeResult = fibonacciIterative(n);
        endTime = System.nanoTime();
        System.out.println("Iterative Fibonacci result: " + iterativeResult);
        System.out.println("Time taken by iterative: " + (endTime - startTime) + " ns");
    }

    // Optimized Recursive Function (Using Memoization)
    public static long fibonacciRecursive(int n) {
        long[] memo = new long[n + 1];
        return fibonacciRecursiveHelper(n, memo);
    }

    private static long fibonacciRecursiveHelper(int n, long[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n]; // Return cached result
        }
        memo[n] = fibonacciRecursiveHelper(n - 1, memo) + fibonacciRecursiveHelper(n - 2, memo);
        return memo[n];
    }

    // Iterative Function (Efficient for Large n)
    public static long fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
