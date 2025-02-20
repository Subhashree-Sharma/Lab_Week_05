package org.example.com.PracticeProblems.ValidateJSONStructureUsingJackson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ValidateJSON{
    //main method
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_02\\src\\main\\java\\org\\example\\com\\PracticeProblems\\ValidateJSONStructureUsingJackson\\Data.json";

        if (isValidJSON(filePath)) {
            System.out.println("JSON is valid");
        } else {
            System.out.println("Invalid JSON.");
        }
    }

    //checking valid or not
    public static boolean isValidJSON(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            //read JSON file
            String jsonContent = Files.readString(Paths.get(filePath));
            //parse JSON
            objectMapper.readTree(jsonContent);
            //no error means JSON is valid
            return true;
        } catch (Exception e) {
            //JSON is invalid
            return false;
        }
    }
}
