package com.seth.fireCode;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBSTItr {
    public static boolean validateBSTItr(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.data.left != null) {
                if (node.data.left.data >= node.minValue && node.data.left.data <= node.data.data ) {
                    queue.add(new Node(node.data.left, node.maxValue, node.data.data));
                }
                else return false;
            }
            if (node.data.right != null) {
                if (node.data.right.data <= node.maxValue && node.data.right.data >= node.data.data) {
                    queue.add(new Node(node.data.right, node.data.data, node.minValue));
                }
                else return false;
            }
        }
        return true;
    }
    private static class Node {
        TreeNode data;
        int maxValue;
        int minValue;
        Node(TreeNode data, int maxValue, int minValue) {
            this.data = data;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }
}
