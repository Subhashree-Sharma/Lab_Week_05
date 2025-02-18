package org.example.com.CSVDataHandling.AdvancedProblems.MergeTwoCSVFiles;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.util.*;

public class MergeCSVFiles {

    public static void mergeCSVFiles(String file1, String file2, String outputFile) throws IOException {
        //read the first CSV file (students1.csv)
        Map<String, String[]> studentsData = new HashMap<>();
        try (CSVReader reader1 = new CSVReader(new FileReader(file1))) {
            //read header
            String[] header1 = reader1.readNext();
            if (header1 == null) {
                throw new IOException("File " + file1 + " has no header or is empty.");
            }
            String[] nextLine;
            while ((nextLine = reader1.readNext()) != null) {
                if (nextLine.length > 0) {
                    //Map by ID (nextLine[0] is ID)
                    studentsData.put(nextLine[0], nextLine);
                }
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        //write the merged data to the output file ->merged.csv
        try (CSVReader reader2 = new CSVReader(new FileReader(file2));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            //read header of the second file (students2.csv)
            String[] header2 = reader2.readNext();
            if (header2 == null) {
                throw new IOException("File " + file2 + " has no header or is empty.");
            }

            // Create the header for the merged file
            String[] mergedHeader = new String[]{"ID", "Name", "Age", "Marks", "Grade"};
            writer.writeNext(mergedHeader);

            String[] nextLine;
            while ((nextLine = reader2.readNext()) != null) {
                if (nextLine.length > 0) {
                    // ID from students2.csv -should match students1.csv
                    String id = nextLine[0];

                    //if the ID exists in students1, merge the data
                    if (studentsData.containsKey(id)) {

                        //get corresponding student data from students1.csv
                        String[] student1 = studentsData.get(id);
                        // Merge data: ID, Name, Age, Marks, Grade
                        String[] mergedRecord = new String[]{
                                id,
                                student1[1],
                                student1[2],
                                nextLine[1],
                                nextLine[2]
                        };
                        //write the merged record to output file
                        writer.writeNext(mergedRecord);
                    }
                }
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // File paths
        String file1 = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\AdvancedProblems\\MergeTwoCSVFiles\\students1.csv";
        String file2 = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\AdvancedProblems\\MergeTwoCSVFiles\\students2.csv";
        String outputFile = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\AdvancedProblems\\MergeTwoCSVFiles\\merged.csv";

        try {
            //call method to merge the CSV files
            mergeCSVFiles(file1, file2, outputFile);
            System.out.println("CSV files merged successfully into: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
