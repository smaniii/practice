package com.seth.interviewbit;

import java.util.HashSet;
import java.util.Set;

public class DetectCycleList {
    public ListNode detectCycle(ListNode a) {
        Set<ListNode> listNodeSet = new HashSet<>();
        while (a != null) {
            if (listNodeSet.contains(a)) return a;
            listNodeSet.add(a);
            a = a.next;
        }
        return null;
    }
}
