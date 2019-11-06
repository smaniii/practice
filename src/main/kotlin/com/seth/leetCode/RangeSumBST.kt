package com.seth.leetCode

object RangeSumBST {
    fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
        if (root == null) return 0
        if (root.`val` in L..R) {
            return root.`val`.plus(rangeSumBST(root.left, L, R)).plus(rangeSumBST(root.right, L, R))
        }
        return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R)
    }
}