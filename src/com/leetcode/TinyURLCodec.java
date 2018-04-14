package com.leetcode;

/*
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
*/

import java.util.HashMap;
import java.util.Map;

public class TinyURLCodec {
    private Map<Integer,String> encodedUrls = new HashMap<>();
    private String host = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int key = longUrl.hashCode();
        encodedUrls.put(key, longUrl);
        return host + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        Integer key = Integer.valueOf(shortUrl.replace(host,""));
        return encodedUrls.get(key);
    }
}

// Your Codec object will be instantiated and called as such:
// codec.decode(codec.encode(url));// Codec codec = new Codec();

