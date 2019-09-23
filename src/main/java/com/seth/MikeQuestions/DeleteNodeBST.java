package com.seth.MikeQuestions;

import com.seth.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodeBST {
    //nlogn solution
    List<Integer> nodeValues = new ArrayList<>();
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        getValues(root, key);
        if(nodeValues.isEmpty()) return null;
        TreeNode head = new TreeNode(nodeValues.get(0));
        nodeValues.remove(0);
        makeNewTree(head);
        return head;
    }

    private void makeNewTree(TreeNode head) {
        TreeNode tempHead = head;
        while (!nodeValues.isEmpty()) {
            TreeNode nodeToInsert = new TreeNode(nodeValues.get(0));
            if(tempHead.val > nodeToInsert.val && tempHead.left == null) {
                tempHead.left = nodeToInsert;
                tempHead = head;
                nodeValues.remove(0);
            }
            else if(tempHead.val > nodeToInsert.val && tempHead.left != null) {
                tempHead = tempHead.left;
            }
            else if(tempHead.val < nodeToInsert.val && tempHead.right == null) {
                tempHead.right = nodeToInsert;
                tempHead = head;
                nodeValues.remove(0);
            }
            else if(tempHead.val < nodeToInsert.val && tempHead.right != null) {
                tempHead = tempHead.right;
            }
        }
    }

    private void getValues(TreeNode root, int key) {
        if(root == null) return;
        if(root.val != key) nodeValues.add(root.val);
        if(root.left != null) getValues(root.left, key);
        if(root.right != null) getValues(root.right, key);
    }

    //logn solution
    public TreeNode deleteNodeOrderLogN(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
            if(root.left == null) root = root.right;
            else if (root.right == null) root = root.left;
            else {
                root.val = getMin(root.right);
                root.right = deleteNodeOrderLogN(root.right, root.val);
            }
        }
        else if(root.val < key) {
            root.right = deleteNodeOrderLogN(root.right, key);
        }
        else {
            root.left =  deleteNodeOrderLogN(root.left, key);
        }
        return root;
    }

    private int getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}