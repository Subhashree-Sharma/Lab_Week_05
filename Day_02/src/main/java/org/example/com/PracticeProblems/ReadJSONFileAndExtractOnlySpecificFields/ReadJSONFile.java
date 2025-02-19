package org.example.com.PracticeProblems.ReadJSONFileAndExtractOnlySpecificFields;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJSONFile {
    public static void main(String[] args) {
        try {
            //JSON file path & reads entire file into a byte[] array
            String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_02\\src\\main\\java\\org\\example\\com\\PracticeProblems\\ReadJSONFileAndExtractOnlySpecificFields\\DetailsFile.json")));

            //convert String to JSON object
            JSONObject jsonObject = new JSONObject(content);

            //extract specific fields
            String name = jsonObject.getString("name");
            String email = jsonObject.getString("email");

            //print extracted values
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
