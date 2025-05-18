package com.quoties.service;

import com.quoties.model.Quoties;
import com.quoties.repository.QuotiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotiesService {

    @Autowired
    private QuotiesRepository quotiesRepository;

    public List<Quoties> getQuotesByWord(String word) {
        return quotiesRepository.findByWord(word);
    }

    public List<Quoties> getQuotesContainingQuote(String quote) {
        return quotiesRepository.findByQuoteContaining(quote);
    }

    public List<Quoties> getQuotesByDefinition(String definition) {
        return quotiesRepository.findByDefinition(definition);
    }

    public List<Quoties> getQuotesByDefinitionTranslated(String definitionTranslated) {
        return quotiesRepository.findByDefinitionTranslated(definitionTranslated);
    }

    public List<Quoties> getQuotesByWordAndDefinition(String word, String definition) {
        return quotiesRepository.findByWordAndDefinition(word, definition);
    }
}
