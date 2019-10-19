package com.seth.leetCode

object LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        val string = s.trim()
        if(string.isEmpty()) return 0
        val words = string.split(' ')
        val lastWordIndex = words.size - 1
        val lastWord = words[lastWordIndex]
        return lastWord.length
    }
}