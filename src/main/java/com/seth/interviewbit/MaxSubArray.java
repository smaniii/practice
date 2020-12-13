package com.seth.interviewbit;

import java.util.Arrays;

public class MaxSubArray {
    public int maxSubArray(final int[] A) {
        int maxEndingHere = A[0];
        int maxSoFar = A[0];
        for (int i = 1; i < A.length; i++) {
            maxEndingHere = Math.max(A[i], A[i] + maxEndingHere);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
