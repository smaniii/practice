package com.seth.leetCode

object RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var size = 0
        for (i in nums.indices) {
            if (nums[i] != `val`) {
                size++
            }
            else {
                val indexToSwitch = indexSwitch(nums, `val`, i)
                size = switchIndex(nums, i, indexToSwitch, size)
            }
        }
        return size;
    }


    private fun indexSwitch(nums: IntArray, `val`: Int, startIndex: Int) : Int {
        for (i in startIndex until nums.size) {
            if (nums[i] != `val`) return i
        }
        return -1
    }

    private fun switchIndex(nums: IntArray, currentIndex: Int, indexToSwitch: Int, size: Int) : Int {
        if (indexToSwitch == -1) return size
        val temp = nums[currentIndex]
        nums[currentIndex] = nums[indexToSwitch]
        nums[indexToSwitch] = temp
        return size + 1
    }

}