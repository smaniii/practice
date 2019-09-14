package com.seth.interviewbit;

public class LengthOfLastWord {

    public static int lengthOfLastWord(final String A) {
        if(A.trim().length() == 0){
            return 0;
        }
        String[] words = A.split(" ");
        String lastWord = words[words.length - 1];
        lastWord = lastWord.trim();
        return lastWord.length();

    }

}
