package com.mariem.quoteapp.service;


import com.mariem.quoteapp.entity.Quote;
import com.mariem.quoteapp.repository.QuoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuoteService implements IQuoteService {

    QuoteRepository quoteRepository;


    @Override
    public Page<Quote> getAllQuotes(Pageable pageable) {
        return quoteRepository.findAll(pageable);
    }

    @Override
    public Page<Quote> findQuotesByText(String text, Pageable pageable) {
        return quoteRepository.findByText(text, pageable);
    }

}