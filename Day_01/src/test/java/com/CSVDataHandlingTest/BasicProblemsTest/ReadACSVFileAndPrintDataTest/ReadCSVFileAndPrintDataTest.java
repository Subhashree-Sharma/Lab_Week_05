package com.CSVDataHandlingTest.BasicProblemsTest.ReadACSVFileAndPrintDataTest;
import org.example.com.CSVDataHandling.BasicProblems.ReadACSVFileAndPrintData.ReadCSVFileAndPrintData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReadCSVFileAndPrintDataTest {

    @Test
    public void testReadCSV() {
        //CSV filePath
        String filePath = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\BasicProblems\\ReadACSVFileAndPrintData\\StudentDetails.csv";

        //expected header
        String[] expected = {"ID", "Name", "Age", "Marks"};

        //read CSV file
        List<String[]> csvData = ReadCSVFileAndPrintData.readCSV(filePath);

        //ensure the file is not empty
        Assertions.assertFalse(csvData.isEmpty(), "CSV file is empty");

        //get actual header and trim spaces
        String[] actualHeader = csvData.get(0);
        for (int i = 0; i < actualHeader.length; i++) {
            actualHeader[i] = actualHeader[i].trim();
        }

        //checks first row matches the expected header
        Assertions.assertArrayEquals(expected, actualHeader, "CSV header does not match");
    }
}





