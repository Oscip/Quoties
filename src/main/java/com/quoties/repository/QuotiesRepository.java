package com.quoties.repository;

import com.quoties.model.Quoties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotiesRepository extends JpaRepository<Quoties, Long> {

    List<Quoties> findByWord(String word);

    List<Quoties> findByQuoteContaining(String quote);

    List<Quoties> findByDefinition(String definition);

    List<Quoties> findByDefinitionTranslated(String definitionTranslated);

    List<Quoties> findByWordAndDefinition(String word, String definition);
}
