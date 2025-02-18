package com.CSVDataHandlingTest.AdvancedProblemsTest.ConvertCSVDataIntoJavaObjectsTest;
import org.example.com.CSVDataHandling.AdvancedProblems.ConvertCSVDataIntoJavaObjects.CSVToJavaObject;
import org.example.com.CSVDataHandling.AdvancedProblems.ConvertCSVDataIntoJavaObjects.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CSVToJavaObjectTest {

    @Test
    public void testReadCSVAndConvertToObjects() {
        //file path
        String filePath = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\AdvancedProblems\\ConvertCSVDataIntoJavaObjects\\StudentFile.csv";

        //Get the list of students
        List<Student> students = CSVToJavaObject.readCSVAndConvertToObjects(filePath);

        //Test if the list is not empty
        assertFalse(students.isEmpty(), "The list of students should not be empty");

        //Test the number of records
        assertEquals(4, students.size(), "There should be 4 students in the list");

        //Test the first student's data
        Student firstStudent = students.get(0);
        assertEquals(123, firstStudent.getId(), "The first student's ID should be 123");
        assertEquals("Subhashree", firstStudent.getName(), "The first student's name should be Subhashree");
        assertEquals(25, firstStudent.getAge(), "The first student's age should be 25");
        assertEquals(95, firstStudent.getMarks(), "The first student's marks should be 95");

        //Test the last student's data
        Student lastStudent = students.get(students.size() - 1);
        assertEquals(127, lastStudent.getId(), "The last student's ID should be 127");
        assertEquals("Rashmi", lastStudent.getName(), "The last student's name should be Rashmi");
        assertEquals(25, lastStudent.getAge(), "The last student's age should be 25");
        assertEquals(80, lastStudent.getMarks(), "The last student's marks should be 80");
    }
}
