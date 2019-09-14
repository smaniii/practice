package com.seth.interviewbit;

public class MinDepthBinaryTree {
    private int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode A) {
        if(A == null) return 0;
        int currentDepth = 1;
        minDepth(A, currentDepth);
        return min;
    }

    private int minDepth(TreeNode a, int i) {
        if(a.left == null && a.right == null){
            min = Math.min(i, min);
        }
        if(a.left != null){
            minDepth(a.left, i + 1);
        }
        if(a.right != null){
            minDepth(a.right, i + 1);
        }
        return i;
    }
}
