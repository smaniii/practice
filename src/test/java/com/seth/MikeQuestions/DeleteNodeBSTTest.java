package com.seth.MikeQuestions;

import com.seth.leetCode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNodeBSTTest {

    DeleteNodeBST deleteNodeBST = new DeleteNodeBST();

    @Test
    void deleteNode() {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNodeL = new TreeNode(3);
        TreeNode treeNodeR = new TreeNode(6);
        TreeNode treeNodeLL = new TreeNode(2);
        treeNodeL.left = treeNodeLL;
        treeNode.left = treeNodeL;
        treeNode.right = treeNodeR;
        System.out.println(deleteNodeBST.deleteNodeOrderLogN(treeNode, 2));
    }
}