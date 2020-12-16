package com.seth.interviewbit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class InorderTraversalIterative {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        if (A == null) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Set<TreeNode> seen = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(A);
        while (!stack.empty()) {
            TreeNode treeNode = stack.pop();
            if (treeNode.right != null && !seen.contains(treeNode)) {
                stack.add(treeNode.right);
            }
            if (treeNode.left != null && !seen.contains(treeNode)) {
                stack.add(treeNode);
                stack.add(treeNode.left);
            }
            else {
                ans.add(treeNode.val);
            }
            seen.add(treeNode);
        }
        return ans;
    }
}
