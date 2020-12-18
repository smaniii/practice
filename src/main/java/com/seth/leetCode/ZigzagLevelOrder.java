package com.seth.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> solution = new ArrayList<>();
        if (root == null) return solution;
        LinkedList<TreeNode> outerQueue = new LinkedList<>();
        outerQueue.add(root);
        boolean inOrder = true;
        while (!outerQueue.isEmpty()) {
            List<Integer> innerSolution = new ArrayList<>();
            LinkedList<TreeNode> innerQueueInOrder = new LinkedList<>();
            LinkedList<TreeNode> innerQueueReverseOrder = new LinkedList<>();
            while (!outerQueue.isEmpty()) {
                TreeNode treeNode = outerQueue.poll();
                innerQueueInOrder.add(treeNode);
                innerQueueReverseOrder.addFirst(treeNode);
            }
            while (!innerQueueInOrder.isEmpty()) {
                if (inOrder) {
                    TreeNode first = innerQueueInOrder.removeFirst();
                    TreeNode last = innerQueueReverseOrder.removeFirst();
                    innerSolution.add(first.val);
                    addToQueue(outerQueue, last.right);
                    addToQueue(outerQueue, last.left);
                }
                else {
                    TreeNode first = innerQueueInOrder.removeFirst();
                    TreeNode last = innerQueueReverseOrder.removeFirst();
                    innerSolution.add(first.val);
                    addToQueue(outerQueue, last.left);
                    addToQueue(outerQueue, last.right);
                }
            }
            inOrder = !inOrder;
            solution.add(innerSolution);
        }
        return solution;
    }

    private void addToQueue(Queue<TreeNode> treeNodeQueue, TreeNode node) {
        if (node != null) {
            treeNodeQueue.add(node);
        }
    }
}
