package com.aman.urlshortner.controller;

import com.aman.urlshortner.dto.ShortenRequest;
import com.aman.urlshortner.dto.ShortenResponse;
import com.aman.urlshortner.service.UrlService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public ShortenResponse shortenUrl(@Valid @RequestBody ShortenRequest request) {

        String shortCode = urlService.shortenUrl(request.getUrl());

        String shortUrl = "http://localhost:8080/" + shortCode;

        return new ShortenResponse(shortUrl);
    }
}