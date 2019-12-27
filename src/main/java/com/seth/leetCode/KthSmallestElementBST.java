package com.seth.leetCode;

import java.util.*;

public class KthSmallestElementBST {

    //order n solution
    List<Integer> ints = new ArrayList<>();
    int k = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        kthSmallest(root);
        return ints.get(k - 1);
    }

    private void kthSmallest(TreeNode root) {
        if (root.left != null) {
            kthSmallest(root.left);
        }
        ints.add(root.val);
        if (ints.size() == k) return;
        if (root.right != null) {
            kthSmallest(root.right);
        }
    }

    public int kthSmallestNlogNSolution(TreeNode root, int k) {
        PriorityQueue<Integer> minHeap = minHeap(root);
        int kThSmallest = 0;
        for (int i = 0; i < k; i++) {
            if (minHeap.isEmpty()) throw new RuntimeException("Kth smallest not in tree");
            kThSmallest = minHeap.poll();
        }
        return kThSmallest;
    }

    private PriorityQueue<Integer> minHeap(TreeNode root) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        minHeap(root, priorityQueue);
        return priorityQueue;
    }

    private void minHeap(TreeNode root, PriorityQueue<Integer> priorityQueue) {
        if (root != null) {
            priorityQueue.add(root.val);
            minHeap(root.left, priorityQueue);
            minHeap(root.right, priorityQueue);
        }
    }
}
