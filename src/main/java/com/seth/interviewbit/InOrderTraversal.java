package com.seth.interviewbit;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(A);
        while (A != null || stack.size() > 0)
        {

            /* Reach the left most Node of the
            curr Node */
            while (A !=  null)
            {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                stack.push(A);
                A = A.left;
            }

            /* Current must be NULL at this point */
            A = stack.pop();

            inOrder.add(A.val);
            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            A = A.right;
        }
        return inOrder;
    }
}
