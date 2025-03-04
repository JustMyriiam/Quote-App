package com.mariem.quoteapp.service;

import com.mariem.quoteapp.entity.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuoteService {

    Page<Quote> getAllQuotes(Pageable pageable);

    Page<Quote> findQuotesByText(String text, Pageable pageable);
}
