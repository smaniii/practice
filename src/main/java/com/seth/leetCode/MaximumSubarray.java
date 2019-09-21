package com.seth.leetCode;

import java.util.HashSet;
import java.util.Set;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        Set<Integer> potentialMax = new HashSet<>();
        int maxSubArray = nums[0];
        potentialMax.add(maxSubArray);
        if(nums.length == 1) return maxSubArray;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i] + maxSubArray) {
                maxSubArray = nums[i];
                potentialMax.add(maxSubArray);
            }
            else {
                potentialMax.add(maxSubArray);
                maxSubArray = maxSubArray + nums[i];
            }
        }
        for (Integer integer : potentialMax) {
            if(integer > maxSubArray) maxSubArray = integer;
        }
        return maxSubArray;
    }
}
