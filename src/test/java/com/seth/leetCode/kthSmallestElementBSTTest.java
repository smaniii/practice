package com.seth.leetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class kthSmallestElementBSTTest {

    @Test
    void kthSmallest() {
        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        node.left = node1;
        node1.left = node2;
        node2.left = node3;
        System.out.println(new kthSmallestElementBST().kthSmallest(node, 3));
    }
}