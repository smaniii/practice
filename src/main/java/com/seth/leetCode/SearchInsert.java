package com.seth.leetCode;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int lower = 0;
        int higher = nums.length - 1;
        while (lower <= higher) {
            if(nums[lower] == target) return lower;
            else if(nums[higher] == target) return higher;
            else {
                if(nums[lower] < target) {
                    lower = (higher + lower) / 2 + 1;
                }
                else {
                    higher = lower - 1;
                    lower = lower / 2;
                }
            }
        }
        return lower;
    }
}
