package org.example.com.CSVDataHandling.AdvancedProblems.GenerateACSVReportFromDatabase;
import java.sql.*;
import java.io.FileWriter;
import java.io.IOException;

public class DatabaseToCSV {
    public static void main(String[] args) {
        //In-memory DB
        String url = "jdbc:h2:mem:testdb";
        String csvFile = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\AdvancedProblems\\GenerateACSVReportFromDatabase\\employees.csv";

        try (Connection conn = DriverManager.getConnection(url, "sa", "");
             Statement stmt = conn.createStatement()) {

            //Create Table
            stmt.execute("CREATE TABLE employees (ID INT, Name VARCHAR(50), Salary DOUBLE)");

            //insert Sample Data
            stmt.execute("INSERT INTO employees VALUES (1, 'John Doe', 50000)");
            stmt.execute("INSERT INTO employees VALUES (2, 'Jane Doe', 60000)");

            //write to CSV
            try (FileWriter writer = new FileWriter(csvFile);
                 ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

                //CSV Header
                writer.write("ID,Name,Salary\n");
                while (rs.next()) {
                    writer.write(rs.getInt("ID") + "," + rs.getString("Name") + "," + rs.getDouble("Salary") + "\n");
                }
                System.out.println("CSV file created: " + csvFile);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

