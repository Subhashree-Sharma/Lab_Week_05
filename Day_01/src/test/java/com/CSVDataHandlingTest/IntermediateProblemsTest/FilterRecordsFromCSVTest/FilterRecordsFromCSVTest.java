package com.CSVDataHandlingTest.IntermediateProblemsTest.FilterRecordsFromCSVTest;
import org.example.com.CSVDataHandling.IntermediateProblems.FilterRecordsFromCSV.FilterCSVRecords;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
public class FilterRecordsFromCSVTest {

        @Test
        public void testFilterStudents() {
            //CSV filePath
            String filePath = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\IntermediateProblems\\FilterRecordsFromCSV\\StudentFile.csv";

            //get filtered list of students
            List<String[]> filteredStudents = FilterCSVRecords.filterStudents(filePath);

            //ensure filtered list is not empty
            Assertions.assertFalse(filteredStudents.isEmpty(), "No students found with marks > 80");

            //check that each student has marks greater than 80
            for (String[] student : filteredStudents) {
                int marks = Integer.parseInt(student[3].trim());
                Assertions.assertTrue(marks > 80, "Student with marks ≤ 80 found in the filtered list");
            }
        }
    }
