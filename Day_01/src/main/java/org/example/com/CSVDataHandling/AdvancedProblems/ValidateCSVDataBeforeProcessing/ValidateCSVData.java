package org.example.com.CSVDataHandling.AdvancedProblems.ValidateCSVDataBeforeProcessing;
import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {

    //regex for validating email
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

    //validate if the phone number has exactly 10 digits
    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{10}");
    }

    //method to validate email
    private static boolean isValidEmail(String email) {
        return emailPattern.matcher(email).matches();
    }

    public static void validateCSV(String inputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;

        //skip the header line
        reader.readLine();

        //read each row in the CSV file
        while ((line = reader.readLine()) != null) {
            String[] columns = line.split(",");

            //assuming email is in the 3rd column
            String email = columns[2].trim();
            //assuming phone number is in the 4th column
            String phone = columns[3].trim();

            boolean isEmailValid = isValidEmail(email);
            boolean isPhoneValid = isValidPhoneNumber(phone);

            if (!isEmailValid) {
                System.out.println("Invalid email-> " + email + " in row-> " + line);
            }

            if (!isPhoneValid) {
                System.out.println("Invalid phone number-> " + phone + " in row-> " + line);
            }
        }
    }

    //main method
    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_01\\src\\main\\java\\org\\example\\com\\CSVDataHandling\\AdvancedProblems\\ValidateCSVDataBeforeProcessing\\Details.csv";
        validateCSV(inputFile);
    }
}
