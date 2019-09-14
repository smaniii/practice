package interviewbit;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode listNode = null;
        ListNode secondPointer = null;
        int numberOfRuns = 0;
        while (A != null || B != null){
            if(A == null){
                listNode.next = B;
                return listNode;
            }
            else if(B == null){
                listNode.next = A;
                return listNode;
            }
            if(A.val >= B.val){
                if(numberOfRuns == 0){
                    listNode = new ListNode(B.val);
                    numberOfRuns = numberOfRuns + 1;
                    B = B.next;
                    secondPointer = listNode;
                    continue;
                }
                secondPointer.next = new ListNode(B.val);
                secondPointer = secondPointer.next;
                B = B.next;
            }
            else if(A.val < B.val){
                if(numberOfRuns == 0){
                    listNode = new ListNode(A.val);
                    numberOfRuns = numberOfRuns + 1;
                    A = A.next;
                    secondPointer = listNode;
                    continue;
                }
                secondPointer.next = new ListNode(A.val);
                secondPointer = secondPointer.next;
                A = A.next;
            }
        }
        return listNode;
    }
}
