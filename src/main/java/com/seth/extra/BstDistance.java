package com.seth.extra;

import java.util.*;
import java.util.stream.Collectors;

public class BstDistance {
    List<Node> ancestors1;
    List<Node> ancestors2;
    public int bstDistance(int num, List<Integer> values,
                           int node1, int node2)
    {
        if (!values.contains(node1) || !values.contains(node2)) return -1;
        else if (node1 == node2) return 0;
        ancestors1 = new ArrayList<>();
        ancestors2 = new ArrayList<>();
        Node head = new Node(values.get(0));
        for (int i = 1; i < values.size(); i++) {
            addToBST(head, values.get(i));
        }
        ancestors(head, node1, ancestors1);
        ancestors(head, node2, ancestors2);
        Node ancestor = findAncestor();
        if (ancestor == null) return -1;
        return findStepsFromAncestor(ancestor, node1) + findStepsFromAncestor(ancestor, node2);
    }

    private Node findAncestor() {
        Set<Node> ancestor2Set = new HashSet<>(ancestors2);
        for (Node node : ancestors1) {
            if (ancestor2Set.contains(node)) return node;
        }
        return null;
    }

    private int findStepsFromAncestor(Node ancestor, int target) {
        if (ancestor.val == target) return 0;
        else if (target > ancestor.val) {
            return findStepsFromAncestor(ancestor.right, target) + 1;
        }
        else{
            return findStepsFromAncestor(ancestor.left, target) + 1;
        }
    }

    private boolean ancestors(Node head, int val, List<Node> ancestors) {
        if (head == null) return false;
        else if (head.val == val) {
            ancestors.add(head);
            return true;
        }
        else if (val > head.val) {
            if (ancestors(head.right, val, ancestors)) {
                ancestors.add(head);
                return true;
            }
            return false;
        }
        else {
            if (ancestors(head.left, val, ancestors)) {
                ancestors.add(head);
                return true;
            }
            return false;
        }
    }

    private void addToBST(Node head, int val) {
        if(val > head.val) {
            if (head.right == null) head.right = new Node(val);
            else addToBST(head.right, val);
        }
        else {
            if (head.left == null) head.left = new Node(val);
            else addToBST(head.left, val);
        }
    }

    private class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}
