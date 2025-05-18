package com.quoties.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quoties")
public class Quoties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String quote;
    private String word;
    private String definition;
    private String definitionTranslated;


    public Quoties() {}

    public Quoties(String quote, String word, String definition, String definitionTranslated) {
        this.quote = quote;
        this.word = word;
        this.definition = definition;
        this.definitionTranslated = definitionTranslated;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
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
