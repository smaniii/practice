package com.seth.leetCode

object BinaryTreePaths {
    var paths = mutableListOf<String>()
    var currentPath = ""
    fun binaryTreePaths(root: TreeNode?): List<String> {
        if(root == null) return paths
        if(root.left == null && root.right == null) {
            val addToPath = root.`val`.toString()
            currentPath += addToPath
            paths.add(currentPath)
            currentPath = currentPath.removeRange(currentPath.length - addToPath.length, currentPath.length)
            return paths;
        }
        if(root.left != null) {
            val addToPath = root.`val`.toString().plus("->")
            currentPath += addToPath
            binaryTreePaths(root.left)
            currentPath = currentPath.removeRange(currentPath.length - addToPath.length, currentPath.length)
        }
        if(root.right != null) {
            val addToPath = root.`val`.toString().plus("->")
            currentPath += addToPath
            binaryTreePaths(root.right)
            currentPath = currentPath.removeRange(currentPath.length - addToPath.length, currentPath.length)
        }
        return paths
    }
}