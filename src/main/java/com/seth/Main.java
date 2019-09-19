package com.seth;

import com.seth.leetCode.LowestCommonAncestor;
import com.seth.leetCode.TreeNode;

public class Main {

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNodeLeft = new TreeNode(2);
        TreeNode treeNodeRight = new TreeNode(3);
        treeNode.left = treeNodeLeft;
        treeNode.right = treeNodeRight;
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(treeNode, treeNodeLeft, treeNodeRight));
    }
}
