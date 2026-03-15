package com.aman.urlshortner.service;

import com.aman.urlshortner.model.UrlMapping;
import com.aman.urlshortner.repository.UrlRepository;
import com.aman.urlshortner.util.ShortCodeGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String shortenUrl(String originalUrl) {

        String shortCode;

        do {
            shortCode = ShortCodeGenerator.generateShortCode();
        } while (urlRepository.findByShortCode(shortCode).isPresent());

        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setOriginalUrl(originalUrl);
        urlMapping.setShortCode(shortCode);
        urlMapping.setCreatedAt(LocalDateTime.now());

        urlRepository.save(urlMapping);

        return shortCode;
    }

    public String getOriginalUrl(String shortCode) {

        return urlRepository.findByShortCode(shortCode)
                .map(UrlMapping::getOriginalUrl)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));
    }
}