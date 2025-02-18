package org.example.com.CSVDataHandling.AdvancedProblems.DetectDuplicatesInCSVFile;
import java.io.*;
import java.util.*;

public class DetectDuplicates {

    //using method to detect & print duplicates based on the ID column
    public static void detectDuplicates(String filePath) {
        Set<String> seenIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            //skip the header
            reader.readLine();

            //read the CSV file line by line
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                //check if ID already exists in the set
                //If add returns false, it means the ID already exists
                if (!seenIds.add(columns[0])) {
                    duplicates.add(line);
                }
            }

            //print duplicate records if any
            if (!duplicates.isEmpty()) {
                System.out.println("Duplicate records found->");
                for (String duplicate : duplicates) {
                    System.out.println(duplicate);
                }
            } else {
                System.out.println("No duplicates found");
            }

        } catch (IOException e) {
            System.err.println("Error reading the file-> " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\AdvancedProblems\\DetectDuplicatesInCSVFile\\Details.csv";
        //call method
        detectDuplicates(filePath);
    }
}

