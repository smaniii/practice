package com.seth.leetCode

object TrappingRainWater {
    fun trap(height: IntArray): Int {
        var leftPointer = 0;
        var rightPointer = height.size - 1
        var maxHieghtLeft = 0
        var maxHieghtRight = 0
        var totalWater = 0
        while (leftPointer < rightPointer) {
            if (height[leftPointer] > height[rightPointer]) {
                if (height[rightPointer] > maxHieghtRight) {
                    maxHieghtRight = height[rightPointer]
                }
                else {
                    totalWater += maxHieghtRight - height[rightPointer]
                }
                rightPointer--
            }
            else {
                if (height[leftPointer] > maxHieghtLeft) {
                    maxHieghtLeft = height[leftPointer]
                }
                else {
                    totalWater += maxHieghtLeft - height[leftPointer]
                }
                leftPointer++
            }
        }
        return totalWater
    }
}