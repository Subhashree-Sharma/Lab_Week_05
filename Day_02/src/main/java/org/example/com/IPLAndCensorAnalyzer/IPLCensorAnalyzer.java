package org.example.com.IPLAndCensorAnalyzer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IPLCensorAnalyzer {
    public static String maskTeamName(String teamName) {
        String[] words = teamName.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            words[i] = "***";
        }
        return String.join(" ", words);
    }

    public static void censorJson(String inputFile, String outputFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File(inputFile));

        for (JsonNode match : root) {
            ((ObjectNode) match).put("team1", maskTeamName(match.get("team1").asText()));
            ((ObjectNode) match).put("team2", maskTeamName(match.get("team2").asText()));
            ((ObjectNode) match).put("winner", maskTeamName(match.get("winner").asText()));
            ((ObjectNode) match).put("player_of_match", "REDACTED");
        }

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), root);
        System.out.println("Censored JSON saved to " + outputFile);
    }

    public static void censorCsv(String inputFile, String outputFile) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get(inputFile));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(lines.get(0));
            writer.newLine();
            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                parts[1] = maskTeamName(parts[1]);
                parts[2] = maskTeamName(parts[2]);
                parts[5] = maskTeamName(parts[5]);
                parts[6] = "REDACTED";
                writer.write(String.join(",", parts));
                writer.newLine();
            }
        }
        System.out.println("Censored CSV saved to " + outputFile);
    }

    public static void main(String[] args) throws Exception {
        censorJson("C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_02\\src\\main\\java\\org\\example\\com\\IPLAndCensorAnalyzer\\ipl_matches.json", "C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_02\\src\\main\\java\\org\\example\\com\\IPLAndCensorAnalyzer\\censor_analyzer.json");
        censorCsv("C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_02\\src\\main\\java\\org\\example\\com\\IPLAndCensorAnalyzer\\ipl_matches.csv","C:\\Users\\ss587\\Downloads\\Capgemini_files2\\Week_05\\Day_02\\src\\main\\java\\org\\example\\com\\IPLAndCensorAnalyzer\\censor_analyzer.csv");
    }
}