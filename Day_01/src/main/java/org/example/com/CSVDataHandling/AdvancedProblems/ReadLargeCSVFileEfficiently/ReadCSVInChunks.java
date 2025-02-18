package org.example.com.CSVDataHandling.AdvancedProblems.ReadLargeCSVFileEfficiently;
import java.io.*;
import java.util.*;

public class ReadCSVInChunks {

    //method to process CSV in chunks
    public static void readCSVInChunks(String filePath, int chunkSize) {
        int totalRecordsProcessed = 0;
        int currentChunkCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            List<String> chunk = new ArrayList<>();

            //read the file line by line &Skip header
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                chunk.add(line);
                currentChunkCount++;

                //process chunk if we've reached the chunk size
                if (currentChunkCount == chunkSize) {
                    processChunk(chunk);
                    totalRecordsProcessed += chunk.size();
                    //clear the chunk for next data
                    chunk.clear();
                    currentChunkCount = 0;
                }
            }

            //process any remaining records if they're less than the chunk size
            if (!chunk.isEmpty()) {
                processChunk(chunk);
                totalRecordsProcessed += chunk.size();
            }

            System.out.println("Total records processed: " + totalRecordsProcessed);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    //method to process each chunk (just print the records here)
    public static void processChunk(List<String> chunk) {
        for (String line : chunk) {
            //print the current chunk of records
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        //Path to the CSV file
        String filePath = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\AdvancedProblems\\ReadLargeCSVFileEfficiently\\Details.csv";
        int chunkSize = 2;
        readCSVInChunks(filePath, chunkSize);
    }
}

