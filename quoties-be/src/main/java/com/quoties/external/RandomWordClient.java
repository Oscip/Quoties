package com.quoties.external;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URLEncoder;

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

    public String fetchQuote(String word) {
        try {
            URL url = new URL("https://favqs.com/api/quotes?filter=" + word);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            connection.setRequestProperty("Authorization", "Token token=91244f7cce1fe0ab8ea0176803185d0a");

            if (connection.getResponseCode() != 200) {
                return "No quote available (HTTP " + connection.getResponseCode() + ")";
            }

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.toString());

            if (root.has("quotes") && root.get("quotes").size() > 0) {
                JsonNode firstQuote = root.get("quotes").get(0);
                String quoteText = firstQuote.path("body").asText();
                String author = firstQuote.path("author").asText();
                return "\"" + quoteText + "\" — " + author;
            }
            return "No quotes found containing: " + word;

        } catch (Exception e) {
            return "Error fetching quote: " + e.getMessage();
        }
    }

    public String fetchTranslatedWord(String word) {
        try {
            URL url = new URL("https://api.mymemory.translated.net/get?q=" + URLEncoder.encode(word, "UTF-8") + "&langpair=en|de");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != 200) {
                return "No translation available (HTTP " + connection.getResponseCode() + ")";
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {

                JsonNode root = new ObjectMapper().readTree(reader);

                if (root.has("responseData")) {
                    JsonNode responseData = root.path("responseData");
                    if (responseData.has("translatedText")) {
                        return responseData.path("translatedText").asText();
                    }
                }
                return "No translation found";
            }
        } catch (Exception e) {
            return "Error fetching translation: " + e.getMessage();
        }
    }

    public String fetchTranslatedQuote(String quote) {
        try {
            URL url = new URL("https://api.mymemory.translated.net/get?q=" + URLEncoder.encode(quote, "UTF-8") + "&langpair=en|de");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != 200) {
                return "No translation available (HTTP " + connection.getResponseCode() + ")";
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {

                JsonNode root = new ObjectMapper().readTree(reader);

                if (root.has("responseData")) {
                    JsonNode responseData = root.path("responseData");
                    if (responseData.has("translatedText")) {
                        return responseData.path("translatedText").asText();
                    }
                }
                return "No translation found";
            }
        } catch (Exception e) {
            return "Error fetching translation: " + e.getMessage();
        }
    }

    public String fetchTranslatedDefinition(String definition) {
        try {
            URL url = new URL("https://api.mymemory.translated.net/get?q=" + URLEncoder.encode(definition, "UTF-8") + "&langpair=en|de");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != 200) {
                return "No translation available (HTTP " + connection.getResponseCode() + ")";
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {

                JsonNode root = new ObjectMapper().readTree(reader);

                if (root.has("responseData")) {
                    JsonNode responseData = root.path("responseData");
                    if (responseData.has("translatedText")) {
                        return responseData.path("translatedText").asText();
                    }
                }
                return "No translation found";
            }
        } catch (Exception e) {
            return "Error fetching translation: " + e.getMessage();
        }
    }

}