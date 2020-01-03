package com.seth.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MaxPathSum {
    private List<TreeNode> treeNodeList;
    private int maxPath;
    private Map<TreeNode, Integer> memo;

    int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        treeNodeList = new ArrayList<>();
        addNodesToList(root);
        memo = new HashMap<>();

        maxPath = Integer.MIN_VALUE;
        for (TreeNode node: treeNodeList) {
            int nodePath = Math.max(0, maxPath(node.left)) + Math.max(0, maxPath(node.right)) + node.val;
            if (nodePath > maxPath) maxPath = nodePath;
        }

        return maxPath;
    }

    private int maxPath(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int maxPath =  Math.max(Math.max(maxPath(root.left), maxPath(root.right)), 0) + root.val;
        memo.put(root, maxPath);
        return maxPath;
    }

    private void addNodesToList(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            treeNodeList.add(node);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

}
