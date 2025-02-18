package org.example.com.CSVDataHandling.IntermediateProblems.SearchForARecordInCSV;
import java.io.*;

public class SearchForARecord {
        public static String searchEmployee(String filePath, String name) throws IOException {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

                //skip header
                reader.readLine();
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    //check name and compare
                    if (data[1].trim().equalsIgnoreCase(name)) {
                        return "Department-> " + data[2] + ", Salary-> " + data[3];
                    }
                }
            }
            return "Employee is not found";
        }

        //main method
        public static void main(String[] args) throws IOException {

            //Filepath & employee Name
            String filePath = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\IntermediateProblems\\SearchForARecordInCSV\\Employeedetails.csv";
            String employeeName = "Subhashree";

            //display result
            System.out.println(searchEmployee(filePath, employeeName));
        }
    }
