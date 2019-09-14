package com.seth.interviewbit;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode A) {
        TreeNode temp = A.right;
        A.right = A.left;
        A.left = temp;
        if(A.left != null) invertTree(A.left);
        if(A.right != null) invertTree(A.right);
        return A;
    }
}
