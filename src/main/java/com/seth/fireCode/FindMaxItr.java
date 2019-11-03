package com.seth.fireCode;

import java.util.LinkedList;
import java.util.Queue;

public class FindMaxItr {
    public int findMaxItr(TreeNode root) {
        int maxValue = 0;
        if (root == null) return maxValue;
        Queue<TreeNode> values = new LinkedList<>();
        values.add(root);
        while (!values.isEmpty()) {
            TreeNode poppedNode = values.poll();
            if (poppedNode.data > maxValue) maxValue = poppedNode.data;
            if (poppedNode.left != null) values.add(poppedNode.left);
            if (poppedNode.right != null) values.add(poppedNode.right);
        }
        return maxValue;
    }
}
