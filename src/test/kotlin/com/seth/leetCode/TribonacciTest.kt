package com.seth.leetCode

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TribonacciTest {

    val trib = Tribonacci
    @Test
    fun `n is 4`() {
        assertEquals(4, trib.tribonacci(4))
    }
}