package org.example.com.HandsOn_PracticeProblems.ConvertCSVdataintoJSON;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class ConvertCsvToJson{
    public static void main(String[] args) {
        try {
            //read CSV file and define schema (header auto-detection)
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader();

            //read CSV and convert to a List of Maps
            MappingIterator<Map<String, String>> it = csvMapper.readerFor(Map.class)
                    .with(schema)
                    .readValues(Paths.get("C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_02\\src\\main\\java\\org\\example\\com\\HandsOn_PracticeProblems\\ConvertCSVdataintoJSON\\Data.json").toFile());

            List<Map<String, String>> data = it.readAll();

            // Convert to JSON
            ObjectMapper jsonMapper = new ObjectMapper();
            String json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);

            // Print JSON output
            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
