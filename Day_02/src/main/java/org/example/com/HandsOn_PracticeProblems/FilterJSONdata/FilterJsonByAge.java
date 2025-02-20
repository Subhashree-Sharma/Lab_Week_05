package org.example.com.HandsOn_PracticeProblems.FilterJSONdata;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

    public class FilterJsonByAge {
        public static void main(String[] args) {
            try {
                //read JSON file
                String json = Files.readString(Paths.get("C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_02\\src\\main\\java\\org\\example\\com\\HandsOn_PracticeProblems\\FilterJSONdata\\Data.json"));

                //parse JSON into a JsonNode array
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode usersArray = objectMapper.readTree(json);

                //list to store filtered users
                List<JsonNode> filteredUsers = new ArrayList<>();

                //loop through JSON array and filter users where age > 25
                for (JsonNode user : usersArray) {
                    if (user.get("age").asInt() > 25) {
                        filteredUsers.add(user);
                    }
                }

                //print the filtered users
                System.out.println("Users older than 25:");
                for (JsonNode user : filteredUsers) {
                    System.out.println(user);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
