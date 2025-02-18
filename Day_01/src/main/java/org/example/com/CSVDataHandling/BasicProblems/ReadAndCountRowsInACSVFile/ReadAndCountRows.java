package org.example.com.CSVDataHandling.BasicProblems.ReadAndCountRowsInACSVFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRows {

        //Using method to read CSV & count rows
        public static int countRowsInCSV(String filePath) {
            int rowCount = 0;

            try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                //skip header row & read & ignore header row
                reader.readLine();

                //count remaining rows
                while ((line = reader.readLine()) != null) {
                    rowCount++;
                }
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }

            return rowCount;
        }

        public static void main(String[] args) {
            //CSV filepath
            String filePath = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\BasicProblems\\ReadAndCountRowsInACSVFile\\Employeedetails.csv";

            //count rows in CSV
            int rowCount = countRowsInCSV(filePath);

            //output result
            System.out.println("Number of records excluding header -> " + rowCount);
        }
    }
