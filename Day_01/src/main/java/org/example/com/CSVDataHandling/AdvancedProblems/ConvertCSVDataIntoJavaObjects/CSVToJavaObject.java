package org.example.com.CSVDataHandling.AdvancedProblems.ConvertCSVDataIntoJavaObjects;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVToJavaObject {

    public static List<Student> readCSVAndConvertToObjects(String filePath) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                // Skip header row
                if (lineNumber == 1) continue;

                // Split CSV row into columns
                String[] columns = line.split(",");

                // Convert columns into a Student object
                int id = Integer.parseInt(columns[0]);
                String name = columns[1];
                int age = Integer.parseInt(columns[2]);
                int marks = Integer.parseInt(columns[3]);

                // Create a new Student object and add it to the list
                students.add(new Student(id, name, age, marks));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return students;
    }

    public static void main(String[] args) {
        // Specify your file path here
        String filePath = "students.csv";

        // Get the list of students
        List<Student> students = readCSVAndConvertToObjects(filePath);

        // Print the students
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
