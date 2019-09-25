package com.seth.leetCode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, sum, 0);
    }

    private boolean hasPathSum(TreeNode root, int sum, int runningSum) {
        if(root == null) return false;
        else if(isLeaf(root) && runningSum + root.val == sum) return true;
        else {
            return hasPathSum(root.left, sum, root.val + runningSum) || hasPathSum(root.right, sum, root.val + runningSum);
        }
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
