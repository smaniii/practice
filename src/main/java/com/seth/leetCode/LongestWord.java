package com.seth.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestWord {
    String longest = "";
    class Trie {
        Map<Character, Trie> children = new HashMap<>();
    }

    public String longestWord(String[] words) {
        Arrays.sort(words);
        Trie reference = new Trie();
        for (String word : words) {
            Trie traverse = reference;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if (!traverse.children.containsKey(c) && i == word.length() - 1) {
                    traverse.children.put(c, new Trie());
                    if (longest.length() < word.length()) longest = word;
                }
                else if (!traverse.children.containsKey(c)) {
                    break;
                }
                traverse = traverse.children.get(c);
            }
        }
        return longest;
    }

}
