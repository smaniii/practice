package com.seth.leetCode

object Tribonacci {
    val cache = hashMapOf(Pair(0, 0), Pair(1,1), Pair(2, 1))
    fun tribonacci(n: Int): Int {
        if (cache.containsKey(n)) return cache[n]!!
        val tribValue = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3)
        cache[n] = tribValue
        return tribValue;
    }
}