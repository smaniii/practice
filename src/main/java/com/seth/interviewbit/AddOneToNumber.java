package com.seth.interviewbit;

public class AddOneToNumber {
    public int[] plusOne(int[] A) {
        if (A.length == 1 && A[0] != 9) {
            A[0] = A[0] + 1;
            return A;
        }
        boolean all9 = true;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != 9) all9 = false;
        }
        int[] B = new int[all9 ? A.length + 1 : A.length];
        boolean addOne = true;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 9 && addOne) {
                B[i] = 0;
            }
            else if(addOne) {
                B[i] = A[i] + 1;
                addOne = false;
            }
            else {
                B[i] = A[i];
            }
        }
        if (addOne) B[0] = 1;
        boolean frontZeroMet = false;
        int front0 = 0;
        for (int i = 0; i < B.length; i++) {
            if (!frontZeroMet && B[i] == 0) {
                front0++;
            }
            else {
                frontZeroMet = true;
            }
        }
        int[] C = new int[B.length - front0];
        for (int i = 0; i < C.length; i++) {
            C[i] = B[i + front0];
        }
        return C;
    }
}
