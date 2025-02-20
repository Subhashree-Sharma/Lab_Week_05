package org.example.com.PracticeProblems.MergeTwoJSONObjectsIntoOne;
import org.json.JSONObject;

public class MergeJSONObjects {
    public static void main(String[] args) {

        //first JSON object
        JSONObject json1 = new JSONObject();
        json1.put("name", "Riya");
        json1.put("email", "subha@gmail.com");

        //second JSON object
        JSONObject json2 = new JSONObject();
        json2.put("name", "Subhashree");
        json2.put("city", "Bhopal");

        //merge both JSON objects
        //copy json1
        JSONObject mergedJson = new JSONObject(json1, JSONObject.getNames(json1));
        for (String key : JSONObject.getNames(json2)) {
            //add json2 data
            mergedJson.put(key, json2.get(key));
        }

        //print merged JSON
        System.out.println(mergedJson.toString(4));
    }
}
