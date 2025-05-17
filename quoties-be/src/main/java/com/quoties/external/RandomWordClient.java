package com.quoties.external;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
}