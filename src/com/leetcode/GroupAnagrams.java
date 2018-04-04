package com.leetcode;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 *
 * [
 *   ["ate", "eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * Note: All inputs will be in lower-case.
 *
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] input) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        String word;
        
        if (input.length > 0) {
            for (int i = 0; i < input.length; i++) {
                word = input[i];
                
                char[] wordChars = word.toCharArray();
                Arrays.sort(wordChars);
                String key = String.valueOf(wordChars);
                
                if (anagramMap.containsKey(key)) {
                    anagramMap.get(key).add(word);
                } else {
                    List<String> values = new ArrayList<>();
                    values.add(word);
                    anagramMap.put(key, values);
                }
            }
        }
        
        return new ArrayList<>(anagramMap.values());
    }

    // For testing
    public static void main(String[] args) {
        String[] input = {"paw","dad","bog","day","day","mig","len","rat"};
        
        List<List<String>> output = groupAnagrams(input);
        
        System.out.println("[");
        for (List<String> anagrams : output) {
            if (anagrams.size() > 0) {
                System.out.print("[");
                System.out.print(anagrams.stream().collect(Collectors.joining(", ")));
                System.out.print("]\n");
            }
        }
        System.out.println("]");
        
        // Expected
        // [["rat"],["mig"],["paw"],["dad"],["len"],["bog"],["day","day"]]
    }

}
