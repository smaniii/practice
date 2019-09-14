package com.seth.MikeQuestions;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode pre = null;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head.next = pre;
        return head;
    }
}
