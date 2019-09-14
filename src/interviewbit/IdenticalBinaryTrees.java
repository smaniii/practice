package interviewbit;

public class IdenticalBinaryTrees {
    private int isEqual = 1;
    public int isSameTree(TreeNode A, TreeNode B) {
        if((A == null && B != null) || (B == null && A != null)){
            isEqual = 0;
            return isEqual;
        }
        if(A == null){
            return 0;
        }
        if((A.left == null && B.left != null) ||(A.right != null && B.right == null)
    || (B.left == null && A.left != null) ||(B.right != null && A.right == null)){
            isEqual = 0;
            return isEqual;
        }
        if(A.val != B.val){
            isEqual = 0;
            return isEqual;
        }
        if(A.left != null){
            isSameTree(A.left, B.left);
        }
        if(A.right != null){
            isSameTree(A.right, B.right);
        }
        return isEqual;
    }
}
