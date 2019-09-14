package interviewbit;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxDepthOfBinaryTree {
    private int max = 0;
    public int maxDepth(TreeNode A) {
        if(A == null) return 0;
        int currentDepth = 1;
        maxDepth(A, currentDepth);
        return max;
    }

    private int maxDepth(TreeNode a, int i) {
        max = Math.max(i, max);
        if(a.left != null){
            maxDepth(a.left, i + 1);
        }
        if(a.right != null){
            maxDepth(a.right, i + 1);
        }
        return i;
    }
}
