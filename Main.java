import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        try {
            // This step is written to read the json file
            String content = new String(Files.readAllBytes(Paths.get("input.json")));
            JSONObject jsonObject = new JSONObject(content);

            // Extract first_name and roll_number from the "Student" array
            JSONArray students = jsonObject.getJSONArray("Student");
            JSONObject student = students.getJSONObject(0); // Get the first student

            String firstName = student.getString("first_name").toLowerCase().replaceAll("\\s", "");
           String concatenatedString = firstName + rollNumber;

            // The below lines of code generate MD5 hash
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] hashBytes = md.digest(concatenatedString.getBytes());
            StringBuilder hashString = new StringBuilder();
            //run the loop 
            hashString.append(java.util.Arrays.stream(hashBytes)
                .mapToObj(b -> String.format("%02x", b))
                .collect(Collectors.joining()));


            // Below line of code writes the hash to the output file
            FileWriter writer = new FileWriter(new File("output.txt"));
            writer.write(hashString.toString());
            writer.close();
        }
        catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
