package com.seth.leetCode;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int subSequenceIterator = 0;
        for (int i = 0; i < t.length(); i++) {
            if(subSequenceIterator == s.length()) return true;
            if(s.charAt(subSequenceIterator) == t.charAt(i)) subSequenceIterator++;
        }
        return subSequenceIterator == s.length();
    }
}
