package com.nt.arrayString;

import java.util.*;

class Codec {
    // Base URL for tiny links
    private static final String BASE_URL = "http://tinyurl.com/";
    // Counter for unique keys
    private int counter = 1;
    // Maps for encoding/decoding
    private Map<String, String> shortToLong = new HashMap<>();
    private Map<String, String> longToShort = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return longToShort.get(longUrl);
        }
        String shortUrl = BASE_URL + counter++;
        longToShort.put(longUrl, shortUrl);
        shortToLong.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl);
    }
}

public class EncodeAndDecodeTinyUrl {
	public static void main(String[] args) {
        Codec obj = new Codec();
        String url = "https://leetcode.com/problems/design-tinyurl";
        
        String tiny = obj.encode(url);
        System.out.println("Encoded: " + tiny);
        
        String ans = obj.decode(tiny);
        System.out.println("Decoded: " + ans);
    }
}
