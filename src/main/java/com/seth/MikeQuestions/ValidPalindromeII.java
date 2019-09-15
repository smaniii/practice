package com.seth.MikeQuestions;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)
                    && (s.charAt(i) != s.charAt(s.length() - 2 -i) && s.charAt(i + 1) != s.charAt(s.length() - 1 - i))) {
                return false;
            }
            else if(s.charAt(i) != s.charAt(s.length() -1 -i)) {
                int indexToRemove = s.length() -1 -i;
                char[] test = new char[s.length() - 1];
                int testIndex = 0;
                for (int j = 0; j < s.length(); j++) {
                    if(indexToRemove != j) {
                        test[testIndex] = s.charAt(j);
                        testIndex++;
                    }
                }
                char[] test2 = new char[s.length() - 1];
                int testIndex2 = 0;
                for (int j = 0; j < s.length(); j++) {
                    if(i != j) {
                        test2[testIndex2] = s.charAt(j);
                        testIndex2++;
                    }
                }
                return isPalindrome(test) || isPalindrome(test2);
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            if(s[i] != s[s.length - 1 - i]) return false;
        }
        return true;
    }

}
