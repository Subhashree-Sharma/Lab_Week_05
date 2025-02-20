package org.example.com.PracticeProblems.ParseJSONAndFilterRecords;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JSONFilter {
    public static void main(String[] args) {
        try {
            //read JSON file content
            String filePath = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_02\\src\\main\\java\\org\\example\\com\\PracticeProblems\\ParseJSONAndFilterRecords\\people.json";
            String jsonContent = Files.readString(Paths.get(filePath));

            //parse JSON into a JsonNode array
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode peopleArray = objectMapper.readTree(jsonContent);

            //list to store filtered records
            List<JsonNode> filteredPeople = new ArrayList<>();

            //loop through JSON array and filter age > 25
            for (JsonNode person : peopleArray) {
                if (person.get("age").asInt() > 25) {
                    filteredPeople.add(person);
                }
            }

            //convert filtered list back to JSON and print
            String filteredJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredPeople);
            System.out.println(filteredJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
