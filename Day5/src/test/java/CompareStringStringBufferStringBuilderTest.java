
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.capgemini.Day5_Assignment.Problem_3.CompareStringStringBufferStringBuilder.*;
import static org.junit.jupiter.api.Assertions.*;

    public class CompareStringStringBufferStringBuilderTest {

        @Test
        public void testStringPerformance() {
            // Prepare test data
            String[] str = new String[10_000]; // Reduced size for faster testing
            Arrays.fill(str, "Hello");

            // Measure performance
            long timeTaken = calculateStringPerformance(str);

            // Assert that the time taken is greater than 0
            assertTrue(timeTaken > 0, "String performance time should be greater than 0");
        }




        @Test
        public void testStringBuilderPerformance() {
            // Prepare test data
            String[] str = new String[10_000]; // Reduced size for faster testing
            Arrays.fill(str, "Hello");

            // Measure performance

            long timeTaken = calculateStringBuilderPerformance(str);

            // Assert that the time taken is greater than 0
            assertTrue(timeTaken > 0, "StringBuilder performance time should be greater than 0");
        }

        @Test
        public void testStringBufferPerformance() {
            // Prepare test data
            String[] str = new String[10_000]; // Reduced size for faster testing
            Arrays.fill(str, "Hello");

            // Measure performance
            long timeTaken = calculateStringBufferPerformance(str);

            // Assert that the time taken is greater than 0
            assertTrue(timeTaken > 0, "StringBuffer performance time should be greater than 0");
        }


    }


