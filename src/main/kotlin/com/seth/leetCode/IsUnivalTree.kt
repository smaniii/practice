package com.seth.leetCode

object IsUnivalTree {
    fun isUnivalTree(root: TreeNode?): Boolean {
        if(root == null) return true;
        if (root.left != null && root.right != null) {
            if (root.left.`val` == root.`val` && root.right.`val` == root.`val`) {
                return isUnivalTree(root.left) && isUnivalTree(root.right)
            }
            return false
        }
        else if (root.left != null) {
            if (root.left.`val` == root.`val`) {
                return isUnivalTree(root.left)
            }
            return false
        }
        else if (root.right != null) {
            if (root.right.`val` == root.`val`) {
                return isUnivalTree(root.right)
            }
            return false
        }
        return true
    }
}