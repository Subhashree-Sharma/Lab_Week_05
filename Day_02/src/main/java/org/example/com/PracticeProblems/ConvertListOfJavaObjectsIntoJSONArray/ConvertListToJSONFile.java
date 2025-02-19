package org.example.com.PracticeProblems.ConvertListOfJavaObjectsIntoJSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Arrays;
import java.util.List;

//main class
public class ConvertListToJSONFile {
    public static void main(String[] args) {
        try {
            //create a list of Car objects
            List<Car> carList = Arrays.asList(
                    new Car("Toyota", "Camry", 2020),
                    new Car("Honda", "Civic", 2019),
                    new Car("Ford", "Mustang", 2022)
            );

            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            //convert & save JSON array to a file
            File file = new File("C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_02\\src\\main\\java\\org\\example\\com\\PracticeProblems\\ConvertListOfJavaObjectsIntoJSONArray\\cars.json");
            objectMapper.writeValue(file, carList);

            System.out.println("JSON saved to file-> " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
