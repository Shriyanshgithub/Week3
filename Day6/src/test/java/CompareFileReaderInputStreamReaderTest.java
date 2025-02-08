import org.capgemini.Day5_Assignment.Problem_4.CompareFileReaderInputStreamReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class CompareFileReaderInputStreamReaderTest {

    @Test
    public void TestPerformanceOfFileReader() throws FileNotFoundException {
        String FilePath = "C:/Users/HP/Desktop/Week3/Day5/src/test/java/file.txt";
        long timeTaken = CompareFileReaderInputStreamReader.PerformanceOfFileReader(FilePath);
        Assertions.assertTrue(timeTaken > 0 , "Time taken by the FileReader is greater than 0");
    }

    @Test
    public void TestPerformanceOfInputStramReader(){
        String FilePath = "C:/Users/HP/Desktop/Week3/Day5/src/test/java/file.txt";
        long timeTaken = CompareFileReaderInputStreamReader.PerformanceOfInputStreamReader(FilePath);
        Assertions.assertTrue(timeTaken > 0 , "Time taken by the InputStreamReader is greater than 0");
    }
}
