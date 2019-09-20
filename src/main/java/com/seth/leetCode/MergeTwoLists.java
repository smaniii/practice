package com.seth.leetCode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        ListNode mergedList;
        if(l1.val >= l2.val) {
            mergedList = new ListNode(l2.val);
            l2 = l2.next;
        }
        else {
            mergedList = new ListNode(l1.val);
            l1 = l1.next;
        }
        ListNode iterator = mergedList;
        while (l1 != null || l2 != null) {
            if(l1 == null) {
                iterator.next = l2;
                return mergedList;
            }
            else if(l2 == null) {
                iterator.next = l1;
                return mergedList;
            }
            else if(l1.val >= l2.val) {
                iterator.next = new ListNode(l2.val);
                l2 = l2.next;
                iterator = iterator.next;
            }
            else {
                iterator.next = new ListNode(l1.val);
                l1 = l1.next;
                iterator = iterator.next;
            }
        }
        return mergedList;
    }
}
