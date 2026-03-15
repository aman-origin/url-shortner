package com.aman.urlshortner.util;

import java.util.Random;

public class ShortCodeGenerator {

    private static final String CHARSET =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final int CODE_LENGTH = 6;

    private static final Random random = new Random();

    public static String generateShortCode() {

        StringBuilder shortCode = new StringBuilder();

        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(CHARSET.length());
            shortCode.append(CHARSET.charAt(index));
        }

        return shortCode.toString();
    }
}