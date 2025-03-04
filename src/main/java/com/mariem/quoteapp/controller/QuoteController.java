package com.mariem.quoteapp.controller;

import com.mariem.quoteapp.entity.Quote;
import com.mariem.quoteapp.service.QuoteService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class QuoteController {

    QuoteService QuoteService;

    @RequestMapping("/listQuotes.html")
    public String getAllQuotes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Quote> quotesPage = QuoteService.getAllQuotes(pageable);
        model.addAttribute("quotes", quotesPage);
        return "listQuotes";
    }

    @GetMapping("search")
    public String getQuotesByText(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String text,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Quote> quotesPage;

        if (text == null) {
            quotesPage = QuoteService.getAllQuotes(pageable);
        } else {
            quotesPage = QuoteService.findQuotesByText(text, pageable);
        }
        model.addAttribute("quotes", quotesPage);
        return "listQuotes";
    }

}

