package com.CSVDataHandlingTest.IntermediateProblemsTest.SortCSVRecordsByAColumnTest;
import org.example.com.CSVDataHandling.IntermediateProblems.SortCSVRecordsByAColumn.SortCSVBySalary;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.util.List;

      public class SortCSVBySalaryTest {
        @Test
        public void testSortCSVBySalary() throws IOException {
            String filePath = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\IntermediateProblems\\SortCSVRecordsByAColumn\\Employee.csv";
            List<String[]> sortedData = SortCSVBySalary.readAndSortCSV(filePath);

            //assuming the first row is the header and skipping it, check the first record's salary
            double expectedSalary = 70000;
            double actualSalary = Double.parseDouble(sortedData.get(0)[3]);

            assertEquals(expectedSalary, actualSalary, "Top salary should be 70000");
        }
    }
