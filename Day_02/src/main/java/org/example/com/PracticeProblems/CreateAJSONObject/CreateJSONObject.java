package org.example.com.PracticeProblems.CreateAJSONObject;
import org.json.JSONObject;
import org.json.JSONArray;
public class CreateJSONObject {

    //main method
    public static void main(String[] args) {

        //JSONArray object
        JSONArray jsonArray = new JSONArray();
        //Putting elements in jsonArray object
        jsonArray.put("Physics");
        jsonArray.put("Chemistry");
        jsonArray.put("Maths");

        //JSONObject object
        JSONObject jsonObject = new JSONObject();
        //Putting elements in jsonObject
        jsonObject.put("Name", "Subhashree");
        jsonObject.put("Age", 21);
        jsonObject.put("Subjects", jsonArray);

        //Display result
        System.out.println(jsonObject.toString());

    }
}
