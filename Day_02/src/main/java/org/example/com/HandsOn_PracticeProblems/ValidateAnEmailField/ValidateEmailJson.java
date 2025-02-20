package org.example.com.HandsOn_PracticeProblems.ValidateAnEmailField;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.regex.Pattern;

//ValidateEmailJson-->Validates correct email from a json file
public class ValidateEmailJson {
    //Define a regex pattern for email validation
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static void main(String[] args) {
        try {
            // Initialize ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file into JsonNode
            JsonNode rootNode = objectMapper.readTree(new File("C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_02\\src\\main\\java\\org\\example\\com\\HandsOn_PracticeProblems\\ValidateAnEmailField\\data.json"));

            //Iterate through each JSON object
            for (JsonNode node : rootNode) {
                String email = node.get("email").asText();

                //Validate email using regex
                if (EMAIL_PATTERN.matcher(email).matches()) {
                    System.out.println("Valid Email: " + email);
                } else {
                    System.out.println("Invalid Email: " + email);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
