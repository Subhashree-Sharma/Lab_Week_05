package org.example.com.HandsOn_PracticeProblems.JavaObjectsIntoJSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.com.HandsOn_PracticeProblems.JavaObjectsIntoJSONArray.*;

import java.util.Arrays;
import java.util.List;
//ListToJson-->Converts List of java objects into json
public class ListToJson {
    public static void main(String[] args) throws Exception {
        List<User> users = Arrays.asList(new User("Subha", 21), new User("Priya", 21));

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);

        System.out.println(jsonArray);
    }
}