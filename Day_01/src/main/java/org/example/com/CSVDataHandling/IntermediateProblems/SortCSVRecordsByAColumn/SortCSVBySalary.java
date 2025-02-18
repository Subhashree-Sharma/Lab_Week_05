package org.example.com.CSVDataHandling.IntermediateProblems.SortCSVRecordsByAColumn;
import java.io.*;
import java.util.*;

public class SortCSVBySalary {
    public static List<String[]> readAndSortCSV(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                //skip the header row
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                data.add(columns);
            }
        }

        //sort by Salary (index 3) in descending order
        data.sort((row1, row2) -> {
            try {
                return Double.compare(Double.parseDouble(row2[3]), Double.parseDouble(row1[3]));
            } catch (NumberFormatException e) {
                //In case of an invalid salary
                return 0;
            }
        });

        return data;
    }

    public static void printTop5HighestPaidEmployees(String filePath) throws IOException {
        List<String[]> sortedData = readAndSortCSV(filePath);

        // Print top 5 highest-paid employees
        System.out.println("Top 5 Highest Paid Employees:");
        for (int i = 0; i < 5 && i < sortedData.size(); i++) {
            String[] row = sortedData.get(i);
            //print the full record
            System.out.println(String.join(",", row));
        }
    }

    //main method
        public static void main(String[] args) throws IOException {
            String filePath = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\IntermediateProblems\\SortCSVRecordsByAColumn\\Employee.csv";
            printTop5HighestPaidEmployees(filePath);
        }
    }

