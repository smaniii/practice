package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class InorderTraversalCartesianTree {
    public static TreeNode buildTree(ArrayList<Integer> A) {
        if(A == null || A.isEmpty()) return null;
        A.sort(Comparator.reverseOrder());
        TreeNode treeNode = new TreeNode(A.get(0));
        TreeNode treeNodeNext = null;
        A.remove(0);
        for (Integer integer : A) {
            TreeNode node = new TreeNode(integer);
            if(treeNodeNext == null){
                treeNodeNext = node;
                treeNode.left = treeNodeNext;
            }
            else {
                treeNodeNext.left = node;
                treeNodeNext = node;
            }
        }
        return treeNode;
    }
}
