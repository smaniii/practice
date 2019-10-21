package com.seth.leetCode

object MinDiffInBST {
    var nodes = mutableListOf<Int>()
    fun minDiffInBSTNlogN(root: TreeNode?): Int {
        addNodesToList(root)
        nodes.sort()
        var minDiff = Integer.MAX_VALUE
        for ( i in 1 until nodes.size) {
            val diff = nodes[i] - nodes[i - 1]
            if (diff < minDiff) minDiff = diff
        }
        return minDiff;
    }
    fun addNodesToList(root: TreeNode?) {
        if (root == null) return
        nodes.add(root.`val`)
        addNodesToList(root.left)
        addNodesToList(root.right)
    }
}