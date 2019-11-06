package com.seth.mikeQuestions

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ShortestTimeBetweenTimesTest {

    private val shortestTimeBetweenTimes = ShortestTimeBetweenTimes

    @Test
    fun `two times are the same`() {
        val times = mutableListOf("00::00", "00::00", "00::02")
        assertEquals(0, shortestTimeBetweenTimes.ShortestTimeBetweenTimes(times))
    }

    @Test
    fun `get shortest`() {
        val times = mutableListOf("00::05", "03::00", "10::02", "01::03")
        assertEquals(58, shortestTimeBetweenTimes.ShortestTimeBetweenTimes(times))
    }

    @Test
    fun `get shortest is wrapped`() {
        val times = mutableListOf("00::05", "03::00", "10::02", "01::03", "23::59")
        assertEquals(6, shortestTimeBetweenTimes.ShortestTimeBetweenTimes(times))
    }

}