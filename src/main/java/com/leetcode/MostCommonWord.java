package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem https://leetcode.com/problems/most-common-word/description/
 *
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not
 * case sensitive.  The answer is in lowercase.
 *
 */
public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.replaceAll("[!?',;.]", "").split(" ");

        if (words.length == 1) {
            return words[0].toLowerCase();
        }

        Set<String> bannedSet = new HashSet<>();
        for (String b : banned) {
            bannedSet.add(b.toLowerCase());
        }

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            String lowerWord = word.toLowerCase();
            if (!bannedSet.contains(lowerWord)) {

                if (map.containsKey(lowerWord)) {
                    map.put(lowerWord, map.get(lowerWord) + 1);
                } else {
                    map.put(lowerWord, 1);
                }
            }
        }

        int maxOccur = Integer.MIN_VALUE;
        String maxOccurWord = "";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxOccur) {
                maxOccur=entry.getValue();
                maxOccurWord=entry.getKey();
            }
        }

        return maxOccurWord;
    }

}
