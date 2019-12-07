package com.seth.fireCode;

public class RotateCounterClockWise {
    public static void rotateSquareImageCCW(int[][] matrix) {
        makeFlipMatrix(matrix);
        makePivot(matrix);
    }

    private static void makeFlipMatrix(int[][] matrix) {
        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j -1];
                matrix[i][matrix.length - j -1] = temp;
            }
        }
    }

    private static void makePivot(int[][] matrix) {
        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix.length; j++) {
                if (i < j) continue;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
