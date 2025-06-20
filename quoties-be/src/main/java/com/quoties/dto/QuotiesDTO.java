package com.quoties.dto;

public class QuotiesDTO {
    public String quote;
    public String quoteTranslated;
    public String word;
    public String wordTranslated;
    public String definition;
    public String definitionTranslated;

    public QuotiesDTO() {}

    public QuotiesDTO(String quote, String quoteTranslated, String word, String wordTranslated, String definition, String definitionTranslated) {
        this.quote = quote;
        this.quoteTranslated = quoteTranslated;
        this.word = word;
        this.wordTranslated = wordTranslated;
        this.definition = definition;
        this.definitionTranslated = definitionTranslated;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getQuoteTranslated() {
        return quoteTranslated;
    }

    public void setQuoteTranslated(String quoteTranslated) {
        this.quoteTranslated = quoteTranslated;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWordTranslated() {
        return wordTranslated;
    }

    public void setWordTranslated(String wordTranslated) {
        this.wordTranslated = wordTranslated;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDefinitionTranslated() {
        return definitionTranslated;
    }

    public void setDefinitionTranslated(String definitionTranslated) {
        this.definitionTranslated = definitionTranslated;
    }
}