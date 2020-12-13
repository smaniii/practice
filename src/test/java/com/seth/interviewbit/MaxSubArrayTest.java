package com.seth.interviewbit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubArrayTest {
    
    MaxSubArray maxSubArray = new MaxSubArray();

    @Test
    void maxSubArray() {
        int[] nums = new int[] { 7, -1, - 1, 7,-1};
        System.out.println(maxSubArray.maxSubArray(nums));
    }
}