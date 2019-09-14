package interviewbit;

import java.util.LinkedList;
import java.util.List;

public class DeleteDuplicates {
    LinkedList<Integer> integerList = new LinkedList<>();
    public static class ListNode {
        public int val;
        public ListNode next;

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        public ListNode(int x) { val = x; next = null; }

    }
    public static ListNode deleteDuplicates(ListNode A) {
        ListNode B = A;
        while (B != null && B.next != null){
            if(B.val == B.next.val){
                B.next = B.next.next;
            }
            else {
                B = B.next;
            }
        }
        return A;
    }

    LinkedList<Integer> minIntegers = new LinkedList<>();
    public void push(int x) {
        integerList.addFirst(x);
        if(minIntegers.isEmpty() || minIntegers.getFirst() > x){
            minIntegers.addFirst(x);
        }
    }

    public void pop() {
        if(integerList == null || integerList.isEmpty()){
            return;
        }
        Integer removed = integerList.removeFirst();
        if(!minIntegers.isEmpty() && removed.equals(minIntegers.getFirst())){
            minIntegers.removeFirst();
        }
    }

    public int top() {
        if(integerList == null || integerList.isEmpty()){
            return - 1;
        }
        return integerList.getFirst();
    }

    public int getMin() {
        if(minIntegers == null || minIntegers.isEmpty()){
            return - 1;
        }
        return minIntegers.getFirst();
    }

}
