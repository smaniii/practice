package com.seth.interviewbit;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> preOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            preOrder.add(treeNode.val);
            if(treeNode.right != null){
                stack.push(treeNode.right);
            }
            if(treeNode.left != null){
                stack.push(treeNode.left);
            }
        }
        return preOrder;
    }
}
