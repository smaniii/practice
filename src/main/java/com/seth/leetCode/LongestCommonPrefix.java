package com.seth.leetCode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String minString = null;
        for (int i = 0; i < strs.length; i++) {
            if(minString == null || strs[i].length() < minString.length()) {
                minString = strs[i];
            }
        }

        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < minString.length(); j++) {
                if(minString.charAt(j) != strs[i].charAt(j)) {
                    minString = minString.substring(0, j);
                }
            }
        }
        return minString;
    }
}
