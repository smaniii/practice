package com.seth.leetCode

object ToLowerCase {
    fun toLowerCase(str: String): String {
        val stringBuilder = StringBuilder()
        str.forEach { stringBuilder.append(it.toLowerCase()) }
        return stringBuilder.toString()
    }
}