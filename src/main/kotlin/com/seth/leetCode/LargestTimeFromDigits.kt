package com.seth.leetCode

object LargestTimeFromDigits {
    var tried = HashSet<Int>()
    fun largestTimeFromDigits(A: IntArray): String {
        val firstDigitIndex = largestFirstDigitIndex(A)
        if (firstDigitIndex == -1) return String()
        val secondDigitIndex = largestSecondDigitIndex(A, firstDigitIndex)
        if (secondDigitIndex == -1) {
            tried.add(firstDigitIndex)
            return largestTimeFromDigits(A)
        }
        val thirdDigitIndex = largestThirdDigitIndex(A, firstDigitIndex, secondDigitIndex)
        if (thirdDigitIndex == -1) {
            tried.add(firstDigitIndex)
            return largestTimeFromDigits(A)
        }
        return A[firstDigitIndex].toString() + A[secondDigitIndex].toString() + ":" + A[thirdDigitIndex].toString() + A[fourthDigitIndex(A, firstDigitIndex, secondDigitIndex, thirdDigitIndex)]
    }
    private fun largestFirstDigitIndex(A: IntArray): Int {
        val max = 2
        var currentMaxIndex = -1
        for (i in A.indices) {
            if (tried.contains(i)) continue
            if (A[i] == max) return i
            if (A[i] < max && currentMaxIndex == -1) currentMaxIndex = i
            else if (A[i] < max && A[i] > A[currentMaxIndex]) currentMaxIndex = i
        }
        return currentMaxIndex
    }

    private fun largestSecondDigitIndex(A: IntArray, firstDigitIndex:Int): Int {
        var max = 9
        if (A[firstDigitIndex] == 2) max = 3
        var currentMaxIndex = -1
        for (i in A.indices) {
            if (i == firstDigitIndex) continue
            if (A[i] == max) return i
            if (A[i] < max && currentMaxIndex == -1) currentMaxIndex = i
            else if (A[i] < max && A[i] > A[currentMaxIndex]) currentMaxIndex = i
        }
        return currentMaxIndex
    }

    private fun largestThirdDigitIndex(A: IntArray, firstDigitIndex:Int, secondDigitIndex: Int): Int {
        val max = 5
        var currentMaxIndex = -1
        for (i in A.indices) {
            if (i == firstDigitIndex || i == secondDigitIndex) continue
            if (A[i] == max) return i
            if (A[i] < max && currentMaxIndex == -1) currentMaxIndex = i
            else if (A[i] < max && A[i] > A[currentMaxIndex]) currentMaxIndex = i
        }
        return currentMaxIndex
    }

    private fun fourthDigitIndex(A: IntArray, firstDigitIndex:Int, secondDigitIndex: Int, thirdDigitIndex: Int): Int {
        for (i in A.indices) {
            if (i == firstDigitIndex || i == secondDigitIndex || i == thirdDigitIndex) continue
            return i
        }
        return -1
    }
}