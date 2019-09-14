package interviewbit;

public class ValidBinarySearchTree {
    private static int isValid = 1; //4 2 5 1 5 -1 -1 -1 -1 -1 -1
    public static int isValidBST(TreeNode A) {
        isValidBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return isValid;
    }
    private static void isValidBST(TreeNode A, int min, int max){
        /* an empty tree is BST */
        if (A == null)
            return;

        /* false if this node violates the min/max constraints */
        if (A.val < min || A.val > max)
            isValid = 0;

        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        isValidBST(A.left, min, A.val-1);
        isValidBST(A.right, A.val+1, max);
    }
}
