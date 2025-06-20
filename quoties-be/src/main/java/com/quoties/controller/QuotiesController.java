package com.quoties.controller;

import com.quoties.model.Quoties;
import com.quoties.external.RandomWordClient;
import com.quoties.repository.QuotiesRepository;
import com.quoties.dto.QuotiesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class QuotiesController {

    @Autowired
    private QuotiesRepository quotiesRepository;

    @Autowired
    private RandomWordClient randomWordClient;

    @GetMapping("/word/random")
    public ResponseEntity<ObjectNode> getRandomWord() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode root = objectMapper.createObjectNode();
            String word = randomWordClient.fetchRandomWord();
            root.put("word", word);

            return ResponseEntity.ok(root);
        } catch (Exception e) {
            e.printStackTrace();
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode error = objectMapper.createObjectNode();
            error.put("error", "Error fetching word: " + e.getMessage());
            return ResponseEntity.status(500).body(error);
        }
    }

    @GetMapping("/words/{number}")
    public ResponseEntity<ObjectNode> getRandomWords(@PathVariable int number) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode arrayNode = objectMapper.createArrayNode();

            for (int i = 0; i < number; i++) {
                String word = randomWordClient.fetchRandomWord();
                arrayNode.add(word);
            }

            ObjectNode root = objectMapper.createObjectNode();
            root.set("words", arrayNode);
            return ResponseEntity.ok(root);
        } catch (Exception e) {
            e.printStackTrace();
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode error = objectMapper.createObjectNode();
            error.put("error", "Error fetching words: " + e.getMessage());
            return ResponseEntity.status(500).body(error);
        }

    }


    @GetMapping("/quotes/new")
    public ResponseEntity<QuotiesDTO> createNewQuote() {
        ObjectMapper objectMapper = new ObjectMapper();

        while (true) {
            // Daten holen von den APIs
            String word = randomWordClient.fetchRandomWord();
            String wordTranslated = randomWordClient.fetchTranslatedWord(word);
            String definition = randomWordClient.fetchDefinition(word);
            String definitionTranslated = randomWordClient.fetchTranslatedDefinition(definition);
            String quote = randomWordClient.fetchQuote(word);

            System.out.println("quote: " + quote);
            // Quote Wert überprüfen
            if (quote == null || quote.trim().toLowerCase().matches(".*no\\s+quotes\\s+found.*")) {
                continue;
            }


            String quoteTranslated = randomWordClient.fetchTranslatedQuote(quote);

            try {
                // Speichert in der Datenbank
                Quoties quoties = new Quoties(quote, quoteTranslated, word, wordTranslated, definition, definitionTranslated);
                quotiesRepository.save(quoties);

                // JSON Antwort erstellen
                QuotiesDTO dto = new QuotiesDTO(quote, quoteTranslated, word, wordTranslated, definition, definitionTranslated);
                return ResponseEntity.ok(dto);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(500).build();
            }
        }
    }
}

