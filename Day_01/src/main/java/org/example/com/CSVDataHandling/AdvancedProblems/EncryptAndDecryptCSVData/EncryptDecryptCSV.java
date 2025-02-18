package org.example.com.CSVDataHandling.AdvancedProblems.EncryptAndDecryptCSVData;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Key;
import java.util.Base64;
import java.util.List;

public class EncryptDecryptCSV {

    //16-char key for AES
    private static final String SECRET_KEY = "MySecretKey12345";

    //encrypt data using AES
    public static String encrypt(String data) throws Exception {
        Key key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    //decrypt data using AES
    public static String decrypt(String encryptedData) throws Exception {
        Key key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
    }

    //Convert JSON to Encrypted CSV
    public static void jsonToEncryptedCsv(String jsonFile, String csvFile) {
        try (Reader reader = new FileReader(jsonFile);
             Writer writer = new FileWriter(csvFile);
             CSVWriter csvWriter = new CSVWriter(writer)) {

            StringBuilder jsonText = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                jsonText.append((char) i);
            }
            org.json.JSONArray jsonArray = new org.json.JSONArray(jsonText.toString());

            //extract headers
            if (jsonArray.length() > 0) {
                org.json.JSONObject firstObj = jsonArray.getJSONObject(0);
                String[] headers = firstObj.keySet().toArray(new String[0]);
                csvWriter.writeNext(headers);

                //write encrypted data rows
                for (int j = 0; j < jsonArray.length(); j++) {
                    org.json.JSONObject obj = jsonArray.getJSONObject(j);
                    String[] row = new String[headers.length];

                    for (int k = 0; k < headers.length; k++) {
                        String value = obj.getString(headers[k]);

                        //encrypt only sensitive fields
                        if (headers[k].equalsIgnoreCase("Salary") || headers[k].equalsIgnoreCase("Email")) {
                            value = encrypt(value);
                        }
                        row[k] = value;
                    }
                    csvWriter.writeNext(row);
                }
            }
            System.out.println("JSON converted to ENCRYPTED CSV-> " + csvFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //decrypt and Convert CSV back to JSON
    public static void encryptedCsvToJson(String csvFile, String jsonFile) {
        try (Reader reader = new FileReader(csvFile);
             CSVReader csvReader = new CSVReader(reader);
             Writer writer = new FileWriter(jsonFile)) {

            List<String[]> records = csvReader.readAll();
            org.json.JSONArray jsonArray = new org.json.JSONArray();

            if (!records.isEmpty()) {
                String[] headers = records.get(0);
                for (int i = 1; i < records.size(); i++) {
                    org.json.JSONObject obj = new org.json.JSONObject();
                    for (int j = 0; j < headers.length; j++) {
                        String value = records.get(i)[j];

                        // Decrypt only sensitive fields
                        if (headers[j].equalsIgnoreCase("Salary") || headers[j].equalsIgnoreCase("Email")) {
                            value = decrypt(value);
                        }
                        obj.put(headers[j], value);
                    }
                    jsonArray.put(obj);
                }
            }

            writer.write(jsonArray.toString(4));
            System.out.println("ENCRYPTED CSV converted back to JSON-> " + jsonFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //main method
    public static void main(String[] args) {
        String jsonFile = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\AdvancedProblems\\EncryptAndDecryptCSVData\\students.json";
        String encryptedCsvFile = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\AdvancedProblems\\EncryptAndDecryptCSVData\\students_encrypted.csv";
        String outputJsonFile = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\AdvancedProblems\\EncryptAndDecryptCSVData\\students_decrypted.json";

        //Convert JSON to Encrypted CSV
        jsonToEncryptedCsv(jsonFile, encryptedCsvFile);
        //Convert Encrypted CSV back to JSON
        encryptedCsvToJson(encryptedCsvFile, outputJsonFile);
    }
}

