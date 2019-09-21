package com.seth.leetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubarrayTest {

    @Test
    void maxSubArray() {
        int[] nums = {-2,-1,-2};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int maxSubArray = maximumSubarray.maxSubArray(nums);
        System.out.println(maxSubArray);
        assertEquals(-1, maxSubArray);
    }
}