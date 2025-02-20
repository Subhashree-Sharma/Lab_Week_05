package org.example.com.HandsOn_PracticeProblems.GenerateaJSONReport;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        //replace with your DB name
        String url = "jdbc:mysql://localhost:3306/your_database";
        //replace with your DB username
        String user = "root";
        //replace with your DB password
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, age, email FROM users")) {

            List<Map<String, Object>> records = new ArrayList<>();

            //Fetch data from ResultSet and store in List
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("id", rs.getInt("id"));
                row.put("name", rs.getString("name"));
                row.put("age", rs.getInt("age"));
                row.put("email", rs.getString("email"));
                records.add(row);
            }

            //Convert List to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonReport = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(records);

            //Print JSON report
            System.out.println(jsonReport);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
