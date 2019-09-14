package interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PostOrderTraversal {
    public ArrayList<Integer> postOrderTraversal(TreeNode A) {
        ArrayList<Integer> postOrder = new ArrayList<>();
        postOrder(A, postOrder);
        return postOrder;
    }

    private void postOrder(TreeNode a, ArrayList<Integer> postOrder) {
        if(a.left != null){
            postOrder(a.left, postOrder);
        }
        if(a.right != null){
            postOrder(a.right, postOrder);
        }
        postOrder.add(a.val);
    }
}
