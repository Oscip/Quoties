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
        String wordTranslated = randomWordClient.fetchTranslatedWord(word);
        String definition = randomWordClient.fetchDefinition(word);
        String definitionTranslated = randomWordClient.fetchTranslatedDefinition(definition);
        String quote = randomWordClient.fetchQuote(word);
        String quoteTranslated = randomWordClient.fetchTranslatedQuote(quote);


        Quoties quoties = new Quoties();
        quoties.setWord(word);
        quoties.setWordTranslated(wordTranslated);
        quoties.setDefinition(definition);
        quoties.setDefinitionTranslated(definitionTranslated);
        quoties.setQuote(quote);
        quoties.setQuoteTranslated(quoteTranslated);
        quotiesRepository.save(quoties);

        return word + definition + quote + wordTranslated + definitionTranslated + quoteTranslated;
    }

}