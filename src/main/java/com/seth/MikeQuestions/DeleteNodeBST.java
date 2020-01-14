package com.seth.MikeQuestions;

import com.seth.leetCode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class DeleteNodeBST {
    //O(ln) solution in average case o(n) in worst
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode removedNode = removeNode(root, key);
        TreeNode createNodeToInsert = createNodeToInsert(removedNode);
        if (root == null || root.val == key) return createNodeToInsert;
        insertNode(root, createNodeToInsert);
        return root;
    }

    //return the node removed
    private TreeNode removeNode(TreeNode root, int key) {
        Queue<TreeNode> pq = new LinkedList<>();
        if (root == null || root.val == key) return root;
        pq.add(root);
        while (!pq.isEmpty()) {
            TreeNode node = pq.poll();
            if (node.left != null) {
                if (node.left.val == key) {
                    TreeNode temp = node.left;
                    node.left = null;
                    return temp;
                }
                else {
                    pq.add(node.left);
                }
            }
            if (node.right != null) {
                if (node.right.val == key) {
                    TreeNode temp = node.right;
                    node.right = null;
                    return temp;
                }
                else {
                    pq.add(node.right);
                }
            }
        }
        return null;
    }

    //return back node to be inserted from the removed node
    private TreeNode createNodeToInsert(TreeNode removeNode) {
        if (removeNode == null || (removeNode.left == null && removeNode.right == null)) return null;
        else if (removeNode.left != null && removeNode.right == null) return removeNode.left;
        else if (removeNode.right != null && removeNode.left == null) return removeNode.right;
        else {
            TreeNode lowestRightSubTree = removeNode.right;
            while (lowestRightSubTree.left != null) {
                lowestRightSubTree = lowestRightSubTree.left;
            }
            lowestRightSubTree.left = removeNode.left;
            return removeNode.right;
        }
    }

    //return the root node after inserted node is added
    private void insertNode(TreeNode root, TreeNode insert) {
        if (root == null || insert == null) return;
        else if (insert.val > root.val) {
            if (root.right == null) {
                root.right = insert;
                return;
            }
            else {
                insertNode(root.right, insert);
            }
        }
        else {
            if (root.left == null) {
                root.left = insert;
                return;
            }
            else {
                insertNode(root.left, insert);
            }
        }
    }
}