package com.seth.leetCode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreePathsTest {

    private val binaryTreePaths = BinaryTreePaths;

    @Test
    fun binaryTreePaths() {
        val treeNode = TreeNode(1)
        val treeNode2 = TreeNode(2)
        val treeNode3 = TreeNode(3)
        val treeNode4 = TreeNode(5)
        treeNode2.right = treeNode4;
        treeNode.left = treeNode2;
        treeNode.right = treeNode3

        val expectedList = listOf<String>("1->2->5", "1->3")
        assertEquals(expectedList, binaryTreePaths.binaryTreePaths(treeNode))
    }

}
