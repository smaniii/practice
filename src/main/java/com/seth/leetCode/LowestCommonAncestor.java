package com.seth.leetCode;

import java.util.LinkedHashSet;
import java.util.Set;

public class LowestCommonAncestor {
    private boolean foundNodeOne = false;
    private Set<TreeNode>  nodeOneAncestors = new LinkedHashSet<>();
    private boolean foundNodeTwo = false;
    private Set<TreeNode> nodeTwoAncestors = new LinkedHashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorOne(root, p);
        lowestCommonAncestorTwo(root, q);
        for (TreeNode node : nodeOneAncestors) {
            if(nodeTwoAncestors.contains(node)) return node;
        }
        return null;
    }
    private void lowestCommonAncestorOne(TreeNode root, TreeNode p) {
        if(foundNodeOne || root.val ==  p.val) {
            foundNodeOne = true;
            nodeOneAncestors.add(root);
        }
        else {
            if(root.left != null) {
                lowestCommonAncestorOne(root.left, p);
            }
            if(foundNodeOne) {
                nodeOneAncestors.add(root);
            }
            else if(root.right != null) {
                lowestCommonAncestorOne(root.right, p);
            }
        }
        if(foundNodeOne) {
            nodeOneAncestors.add(root);
        }
    }
    private void lowestCommonAncestorTwo(TreeNode root, TreeNode q) {
        if(foundNodeTwo || root.val ==  q.val) {
            foundNodeTwo = true;
            nodeTwoAncestors.add(root);
        }
        else {
            if(root.left != null) {
                lowestCommonAncestorTwo(root.left, q);
            }
            if(foundNodeTwo) {
                nodeTwoAncestors.add(root);
            }
            else if(root.right != null) {
                lowestCommonAncestorTwo(root.right, q);
            }
        }
        if(foundNodeTwo) {
            nodeTwoAncestors.add(root);
        }
    }
}
