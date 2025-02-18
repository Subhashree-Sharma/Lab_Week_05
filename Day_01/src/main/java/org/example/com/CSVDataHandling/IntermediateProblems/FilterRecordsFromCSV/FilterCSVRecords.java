package org.example.com.CSVDataHandling.IntermediateProblems.FilterRecordsFromCSV;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    public class FilterCSVRecords {

        //Using method to read & filter students
        public static List<String[]> filterStudents(String filePath) {
            List<String[]> qualifiedStudents = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                boolean isHeader = true;

                while ((line = reader.readLine()) != null) {
                    String[] columns = line.split(",");

                    //skip header row
                    if (isHeader) {
                        isHeader = false;
                        continue;
                    }

                    //ensure row has enough columns to avoid index errors
                    if (columns.length >= 4) {
                        try {
                            int marks = Integer.parseInt(columns[3].trim());
                            if (marks > 80) {
                                qualifiedStudents.add(columns);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Skipping invalid marks value -> " + columns[3]);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading the file - " + e.getMessage());
            }

            return qualifiedStudents;
        }

        public static void main(String[] args) {
            //CSV file path
            String filePath = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\IntermediateProblems\\FilterRecordsFromCSV\\StudentFile.csv";

            //get filtered students
            List<String[]> qualifiedStudents = filterStudents(filePath);

            //print qualifying records
            System.out.println("Students with marks greater than 80:");
            for (String[] student : qualifiedStudents) {
                System.out.println(String.join(", ", student));
            }
        }
    }
