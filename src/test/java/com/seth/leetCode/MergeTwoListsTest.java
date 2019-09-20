package com.seth.leetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoListsTest {

    MergeTwoLists mergeTwoLists = new MergeTwoLists();

    @Test
    void mergeTwoLists() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        ListNode listNodeOutput = mergeTwoLists.mergeTwoLists(listNode1, listNode2);
        System.out.println(listNodeOutput);
        int[] expectedValues = {1, 1, 2, 3, 4, 4};
        for (int expectedValue : expectedValues) {
            assertEquals(expectedValue, listNodeOutput.val);
            listNodeOutput = listNodeOutput.next;
        }
    }
}