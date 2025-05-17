package com.quoties.controller;

import com.quoties.model.Quoties;
import com.quoties.external.RandomWordClient;
import com.quoties.service.QuotiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuotiesController {

    @Autowired
    private QuotiesService quotiesService;

    @Autowired
    private RandomWordClient randomWordClient;

    @GetMapping("/quote")
    public Quoties getQuote() {
        List<Quoties> quoties = quotiesService.getQuotesContainingQuote("love");
        if (!quoties.isEmpty()) {
            return quoties.get(0);
        }
        return null;
    }

    @GetMapping("/test/word")
    public String getrandomWord() {
        return randomWordClient.fetchRandomWord();
    }
}
