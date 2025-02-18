package com.CSVDataHandlingTest.BasicProblemsTest.ReadAndCountRowsInACSVFileTest;
import org.example.com.CSVDataHandling.BasicProblems.ReadAndCountRowsInACSVFile.ReadAndCountRows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//Testing class
public class ReadAndCountRowsTest {

        @Test
        public void testCountRowsInCSV() {
            //CSV filepath
            String filePath = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\BasicProblems\\ReadAndCountRowsInACSVFile\\Employeedetails.csv";

            //Expected row count
            int expectedRowCount = 5;

            //call the method to count rows
            int actualRowCount = ReadAndCountRows.countRowsInCSV(filePath);

            //check actual value with expected value
            Assertions.assertEquals(expectedRowCount, actualRowCount, "Row count does not match");
        }
    }
