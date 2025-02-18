package org.example.com.CSVDataHandling.BasicProblems.ReadACSVFileAndPrintData;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVFileAndPrintData {

    //Using method to read csv file
    public static List<String[]> readCSV(String filePath) {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                //split each line into an array & add to list
                data.add(line.split(","));
            }
        }
        //handling exception
        catch (FileNotFoundException e) {
            System.out.println("CSV file is not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error in reading file: " + e.getMessage());
        }

        return data;
    }

    //Main method
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\BasicProblems\\ReadACSVFileAndPrintData\\StudentDetails.csv";

        //read and print data
        List<String[]> csvData = readCSV(filePath);

        for (String[] row : csvData) {
            //print in structured format
            System.out.println(String.join(" ", row));
        }
    }
}

