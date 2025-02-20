package org.example.com.HandsOn_PracticeProblems.ConvertJSONtoXMLFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

//ConvertJsonToXml-->Converts json object to XML
public class ConvertJsonToXml {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        //Read JSON file
        JsonNode jsonNode = objectMapper.readTree(new File("C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_02\\src\\main\\java\\org\\example\\com\\HandsOn_PracticeProblems\\ConvertJSONtoXMLFormat\\Data2.json"));

        //If the JSON is an array, wrap it inside a root element
        if (jsonNode.isArray()) {
            ObjectNode rootNode = objectMapper.createObjectNode();
            // Wrap in a single root element
            rootNode.set("Users", jsonNode);
            jsonNode = rootNode;
        }

        //convert JSON to XML
        String xmlOutput = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        // Print XML
        System.out.println(xmlOutput);
    }
}
