package com.quoties.controller;

import com.quoties.model.Quoties;
import com.quoties.external.RandomWordClient;
import com.quoties.repository.QuotiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class QuotiesController {

    @Autowired
    private QuotiesRepository quotiesRepository;

    @Autowired
    private RandomWordClient randomWordClient;

    @GetMapping("/quote")
    public Quoties getQuote() {
        // You might want to implement this properly
        return quotiesRepository.findAll().stream().findFirst().orElse(null);
    }

    @GetMapping("/test/word")
    public String getRandomWord() {
        return randomWordClient.fetchRandomWord();
    }

    @GetMapping("/quotes/new")
    public String createNewQuote() {
        String word = randomWordClient.fetchRandomWord();
        String definition = randomWordClient.fetchDefinition(word);
        String fetchedQuote  = randomWordClient.fetchQuote(word);

        Quoties quote = new Quoties();
        quote.setWord(word);
        quote.setDefinition(definition);
        quote.setQuote(fetchedQuote);
        quote.setDefinitionTranslated("Beispiel für " + word);
        quotiesRepository.save(quote);

        return word + definition + quote;
    }

}