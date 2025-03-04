package com.mariem.quoteapp.repository;

import com.mariem.quoteapp.entity.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {

    Page<Quote> findByText(String text, Pageable pageable);
}
