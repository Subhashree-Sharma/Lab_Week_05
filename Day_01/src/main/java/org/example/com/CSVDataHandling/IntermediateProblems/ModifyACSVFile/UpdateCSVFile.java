package org.example.com.CSVDataHandling.IntermediateProblems.ModifyACSVFile;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.List;

public class UpdateCSVFile {
    public static void updateSalary(String inputFile, String outputFile) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            //read all lines from CSV
            List<String[]> data = reader.readAll();
            if (data.isEmpty()) {
                System.out.println("CSV file is empty!");
                return;
            }

            //start from 1 to skip header
            for (int i = 1; i < data.size(); i++) {
                String[] row = data.get(i);
                //check department
                if (row.length > 3 && row[2].trim().equalsIgnoreCase("IT")) {
                    try {
                        double salary = Double.parseDouble(row[3].trim());
                        //increase by 10%
                        salary *= 1.10;
                        //format salary
                        row[3] = String.format("%.2f", salary);
                        //debugging output
                        System.out.println("Updated salary for " + row[1] + "-> " + row[3]);
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid salary data for-> " + row[1]);
                    }
                }
            }

            //write updated data to CSV
            writer.writeAll(data);
            System.out.println("Salaries updated and saved to-> " + outputFile);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    //main method
    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\IntermediateProblems\\ModifyACSVFile\\InputFile.csv";
        String outputFile = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\IntermediateProblems\\ModifyACSVFile\\OutputFile.csv";

        updateSalary(inputFile, outputFile);
    }
}
