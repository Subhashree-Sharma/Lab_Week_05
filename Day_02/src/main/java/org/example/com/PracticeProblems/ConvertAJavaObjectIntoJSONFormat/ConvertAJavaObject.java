package org.example.com.PracticeProblems.ConvertAJavaObjectIntoJSONFormat;
import com.google.gson.Gson;

//Car class
class Car {
    String brand;
    String model;
    int year;

    //constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}

//Main method
public class ConvertAJavaObject {
    public static void main(String[] args) {
        //creating a car object
        Car car = new Car("Tesla", "Pata nhi", 2024);

        Gson gson = new Gson();
        //convert Car object to JSON
        String json = gson.toJson(car);

        //print JSON output
        System.out.println(json);
    }
}
