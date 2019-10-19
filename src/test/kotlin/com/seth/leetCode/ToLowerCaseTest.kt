package com.seth.leetCode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ToLowerCaseTest {

    val toLowerCaseTest = ToLowerCase;

    @Test
    fun `should return empty string when empty string is passed`() {
        assertEquals("", toLowerCaseTest.toLowerCase(""))
    }

    @Test
    fun `should return lower case string when lower case string passed`() {
        assertEquals("abc", toLowerCaseTest.toLowerCase("abc"))
    }

    @Test
    fun `should return lower case string when upper case string passed`() {
        assertEquals("abc", toLowerCaseTest.toLowerCase("ABC"))
    }

    @Test
    fun `should return orginial string when special character string passed`() {
        assertEquals("#$%", toLowerCaseTest.toLowerCase("#$%"))
    }

}
