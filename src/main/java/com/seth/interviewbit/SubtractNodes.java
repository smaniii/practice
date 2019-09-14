package com.seth.interviewbit;

import java.util.LinkedList;

public class SubtractNodes
{
    public static ListNode subtract(ListNode A)
    {
        if(A == null || A.next == null)
            return A;

        ListNode b = A;
        ListNode c = A;

        int sizeOfArray = 0;

        while (b != null)
        {
            sizeOfArray++;
            b = b.next;
        }

        ListNode midway = A;

        for (int i = 0; i < sizeOfArray/2; i++) {
            midway = midway.next;
        }

        LinkedList<Integer> cachedValues = new LinkedList<>();

        while (midway != null){
            cachedValues.addLast(midway.val);
            midway = midway.next;
        }

        for (int i = 0; i < sizeOfArray/2 ; i++)
        {
            c.val = cachedValues.get(cachedValues.size() - 1 - i) - c.val;
            c = c.next;
        }

        return A;
    }
}
