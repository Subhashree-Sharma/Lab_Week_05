package org.example.com.CSVDataHandling.BasicProblems.WriteDataToACSVFile;
import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataToCSVFile {

    //using method to write data in csv file
    public static void writeEmployeeDataToCSV(String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            //header row
            String[] head = {"ID", "Name", "Department", "Salary"};
            //other employee rows
            String[] employee1 = {"123", "Subhashree", "CSE", "60000"};
            String[] employee2 = {"124", "Udit", "IT", "50000"};
            String[] employee3 = {"125", "Vinay", "AIML", "40000"};
            String[] employee4 = {"126", "Riya", "EC", "20000"};
            String[] employee5 = {"127", "Priya", "Mechanical", "10000"};

            //write data in csv file
            writer.writeNext(head);
            writer.writeNext(employee1);
            writer.writeNext(employee2);
            writer.writeNext(employee3);
            writer.writeNext(employee4);
            writer.writeNext(employee5);

        } catch (FileNotFoundException e) {
            System.out.println("CSV File is not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error in writing to file " + e.getMessage());
        }
    }

    //main method
    public static void main(String[] args) {
        //filePath
        String filePath = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\BasicProblems\\WriteDataToACSVFile\\EmployeeDetails.csv";

        //call method to write data
        writeEmployeeDataToCSV(filePath);
    }
}
