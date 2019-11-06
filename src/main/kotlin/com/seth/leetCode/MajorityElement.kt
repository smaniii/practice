package com.seth.leetCode

object MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        val cache = mutableMapOf<Int, Int?>()
        nums.forEach { it ->
            if (cache.containsKey(it)) cache[it] = cache[it]?.plus(1)
            else cache[it] = 1
        }
        var maxValue = 0
        var num = 0
        cache.forEach{ (k, v) ->
            if (v != null) {
                if (v > maxValue) {
                    maxValue = v
                    num = k
                }
            }
        }
        return num;
    }
}