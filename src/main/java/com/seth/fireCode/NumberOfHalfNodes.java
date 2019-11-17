package com.seth.fireCode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfHalfNodes {
    public int numberOfHalfNodes(TreeNode root) {
        int numberOfHalfNodes = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return numberOfHalfNodes;
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null && node.right != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
            else if (node.left != null) {
                numberOfHalfNodes++;
                queue.add(node.left);
            }
            else if (node.right != null) {
                numberOfHalfNodes++;
                queue.add(node.right);
            }
        }
        return numberOfHalfNodes;
    }
}
