package com.seth.leetCode

import kotlin.math.max

object LongestUnivaluePath {
    var answer = 0
    fun longestUnivaluePath(root: TreeNode?): Int {
        recursive(root)
        return answer
    }

    fun recursive (root: TreeNode?): Int {
        if (root == null) return 0;
        val left = recursive(root.left)
        val right = recursive(root.right)
        var arrowRight = 0
        var arrowLeft = 0
        if (root.right != null && root.right.`val` == root.`val`) {
            arrowRight += (right + 1)
        }
        if (root.left != null && root.left.`val` == root.`val`) {
            arrowLeft += (left + 1)
        }
        answer = max(answer, arrowLeft + arrowRight);
        return max(arrowLeft, arrowRight);
    }
}