package org.example.com.CSVDataHandling.AdvancedProblems.ConvertJSONtoCSVandViceVersa;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.*;

public class JsonCsvConverter {

    // Convert JSON to CSV
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try (Reader reader = new FileReader(jsonFile);
             Writer writer = new FileWriter(csvFile);
             CSVWriter csvWriter = new CSVWriter(writer)) {

            // Read JSON file
            StringBuilder jsonText = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                jsonText.append((char) i);
            }
            JSONArray jsonArray = new JSONArray(jsonText.toString());

            // Extract headers
            if (jsonArray.length() > 0) {
                JSONObject firstObj = jsonArray.getJSONObject(0);
                String[] headers = firstObj.keySet().toArray(new String[0]);
                csvWriter.writeNext(headers);

                // Write data rows
                for (int j = 0; j < jsonArray.length(); j++) {
                    JSONObject obj = jsonArray.getJSONObject(j);
                    String[] row = Arrays.stream(headers).map(obj::getString).toArray(String[]::new);
                    csvWriter.writeNext(row);
                }
            }
            System.out.println("✅ JSON converted to CSV: " + csvFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Convert CSV to JSON
    public static void csvToJson(String csvFile, String jsonFile) {
        try (Reader reader = new FileReader(csvFile);
             CSVReader csvReader = new CSVReader(reader);
             Writer writer = new FileWriter(jsonFile)) {

            List<String[]> records = csvReader.readAll();
            JSONArray jsonArray = new JSONArray();

            if (!records.isEmpty()) {
                String[] headers = records.get(0);
                for (int i = 1; i < records.size(); i++) {
                    JSONObject obj = new JSONObject();
                    for (int j = 0; j < headers.length; j++) {
                        obj.put(headers[j], records.get(i)[j]);
                    }
                    jsonArray.put(obj);
                }
            }

            writer.write(jsonArray.toString(4));
            System.out.println(" CSV converted to JSON: " + jsonFile);

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String jsonFile = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\AdvancedProblems\\ConvertJSONtoCSVandViceVersa\\students.json";
        String csvFile = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\AdvancedProblems\\ConvertJSONtoCSVandViceVersa\\students.csv";
        String outputJsonFile = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\AdvancedProblems\\ConvertJSONtoCSVandViceVersa\\converted_students.json";

        jsonToCsv(jsonFile, csvFile);  // Convert JSON to CSV
        csvToJson(csvFile, outputJsonFile);  // Convert CSV back to JSON
    }
}
