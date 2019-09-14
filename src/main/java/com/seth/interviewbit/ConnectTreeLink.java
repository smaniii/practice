package com.seth.interviewbit;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectTreeLink {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeLinkNode treeLinkNode = queue.remove();
            if(treeLinkNode.left != null){
                queue.add(treeLinkNode.left);
                if(treeLinkNode.right != null){
                    treeLinkNode.left.next = treeLinkNode.right;
                }
                else {
                    treeLinkNode.left.next = findNext(treeLinkNode);
                }
            }
            if(treeLinkNode.right != null){
                queue.add(treeLinkNode.right);
                treeLinkNode.right.next = findNext(treeLinkNode);
            }
        }
    }

    private TreeLinkNode findNext(TreeLinkNode treeLinkNode) {
        TreeLinkNode treeLinkNodeNext = treeLinkNode.next;
        while (treeLinkNodeNext != null){
            if(treeLinkNodeNext.left != null){
                return treeLinkNodeNext.left;
            }
            else if(treeLinkNodeNext.right != null)
            {
                return treeLinkNodeNext.right;
            }
            treeLinkNodeNext = treeLinkNodeNext.next;
        }
        return null;
    }
}
