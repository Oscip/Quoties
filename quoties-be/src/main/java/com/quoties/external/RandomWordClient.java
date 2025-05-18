package com.quoties.external;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RandomWordClient {

    public String fetchRandomWord() {
        try {
            URL url = new URL("https://random-word-api.vercel.app/api?words=1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            String response = reader.readLine();
            reader.close();

            return response.replaceAll("[\\[\\]\"]", "").trim();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch random word", e);
        }
    }

    public String fetchDefinition(String word) {
        try {
            URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en/" + word);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != 200) {
                return "No definition available";
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {

                JsonNode root = new ObjectMapper().readTree(reader);

                if (root.isArray() && root.size() > 0) {
                    JsonNode firstDefinition = root.get(0)
                            .path("meanings").get(0)
                            .path("definitions").get(0)
                            .path("definition");

                    return firstDefinition.asText("No definition found");
                }
                return "No definitions available";
            }
        } catch (Exception e) {
            return "Error fetching definition: " + e.getMessage();
        }
    }
}