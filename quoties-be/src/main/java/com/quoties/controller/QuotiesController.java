package com.quoties.controller;

import com.quoties.model.Quoties;
import com.quoties.external.RandomWordClient;
import com.quoties.repository.QuotiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api")
public class QuotiesController {

    @Autowired
    private QuotiesRepository quotiesRepository;

    @Autowired
    private RandomWordClient randomWordClient;

    // Holt sich ein Wort
    @GetMapping("/word/random")
    public String getRandomWord() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode root = objectMapper.createObjectNode();
            String word = randomWordClient.fetchRandomWord();
            root.put("word", word);
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching word: " + e.getMessage();
        }
    }

    // Holt sich ein Wort auf die angefragte Menge
    @GetMapping("/words/{number}")
    public String getRandomWords(@PathVariable int number) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode arrayNode = objectMapper.createArrayNode();

            for (int i = 0; i < number; i++) {
                String word = randomWordClient.fetchRandomWord();
                arrayNode.add(word);
            }

            ObjectNode root = objectMapper.createObjectNode();
            root.set("words", arrayNode);
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);


            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching words: " + e.getMessage();
        }

    }


    @GetMapping("/quotes")
    public String createNewQuote() {
        ObjectMapper objectMapper = new ObjectMapper();

        while (true) {
            // Holt sich Daten von den APIs
            String word = randomWordClient.fetchRandomWord();
            String wordTranslated = randomWordClient.fetchTranslatedWord(word);
            String definition = randomWordClient.fetchDefinition(word);
            String definitionTranslated = randomWordClient.fetchTranslatedDefinition(definition);
            String quote = randomWordClient.fetchQuote(word);

            // Überprüfung der Gültigkeit der Daten
            boolean isQuoteInvalid = (
                    quote == null ||
                            quote.trim().isEmpty() ||
                            quote.toLowerCase().contains("no quotes found")
            );

            boolean isDefinitionInvalid = (
                    definition == null ||
                            definition.trim().isEmpty() ||
                            definition.toLowerCase().contains("no definition available")
            );

            if (isQuoteInvalid || isDefinitionInvalid) {
                continue;
            }

            String quoteTranslated = randomWordClient.fetchTranslatedQuote(quote);

            try {
                // Erstellt ein JSON-Objekt
                ObjectNode root = objectMapper.createObjectNode();
                root.put("word", word);
                root.put("wordTranslated", wordTranslated);
                root.put("definition", definition);
                root.put("definitionTranslated", definitionTranslated);
                root.put("quote", quote);
                root.put("quoteTranslated", quoteTranslated);
                String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
                System.out.println(jsonString);

                // Speichert  die Daten in der Datenbank
                Quoties quoties = new Quoties();
                quoties.setWord(word);
                quoties.setWordTranslated(wordTranslated);
                quoties.setDefinition(definition);
                quoties.setDefinitionTranslated(definitionTranslated);
                quoties.setQuote(quote);
                quoties.setQuoteTranslated(quoteTranslated);
                quotiesRepository.save(quoties);

                return jsonString;
            } catch (Exception e) {
                e.printStackTrace();
                return "Error creating new quote: " + e.getMessage();
            }
        }
    }
}