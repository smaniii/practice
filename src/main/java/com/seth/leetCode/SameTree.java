package com.seth.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return p == q;
        Queue<TreeNode> queueP = new LinkedList<>();
        queueP.add(p);
        Queue<TreeNode> queueQ = new LinkedList<>();
        queueQ.add(q);
        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode pollP = queueP.poll();
            TreeNode pollQ = queueQ.poll();
            if(pollP == null || pollQ == null) {
                if(pollP == null && pollQ == null) {
                    continue;
                }
                return false;
            }
            if(pollP.val != pollQ.val) return false;
            queueP.add(pollP.left);
            queueP.add(pollP.right);
            queueQ.add(pollQ.left);
            queueQ.add(pollQ.right);
        }
        return queueP.isEmpty() && queueQ.isEmpty();
    }
}
