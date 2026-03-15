package com.aman.urlshortner.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class UrlMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalUrl;

    @Column(unique = true)
    private String shortCode;

    private LocalDateTime createdAt;
}