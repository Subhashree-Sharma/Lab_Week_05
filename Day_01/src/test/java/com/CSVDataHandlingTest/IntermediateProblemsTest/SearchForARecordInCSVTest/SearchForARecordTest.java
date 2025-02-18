package com.CSVDataHandlingTest.IntermediateProblemsTest.SearchForARecordInCSVTest;
import org.example.com.CSVDataHandling.IntermediateProblems.SearchForARecordInCSV.SearchForARecord;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

//Testing class
public class SearchForARecordTest {
        @Test
        public void testSearchEmployee() throws IOException {
            String filePath = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\IntermediateProblems\\SearchForARecordInCSV\\Employeedetails.csv";

            //testing for existing employee
            String result = SearchForARecord.searchEmployee(filePath, "Subhashree");
            assertTrue(result.contains("CSE") && result.contains("60000"), "Incorrect department or salary");

            //testing for non-existing employee
            assertEquals("Employee is not found", SearchForARecord.searchEmployee(filePath, "Unknown"));
        }
    }
