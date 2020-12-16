package com.seth.interviewbit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InorderTraversalIterativeTest {

    InorderTraversalIterative inorderTraversalIterative = new InorderTraversalIterative();
    @Test
    void inorderTraversal() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        inorderTraversalIterative.inorderTraversal(treeNode);
    }
}