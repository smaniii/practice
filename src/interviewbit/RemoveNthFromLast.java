package interviewbit;

public class RemoveNthFromLast
{
    public static ListNode removeNthFromEnd(ListNode A, int B) {
        int size = 0;
        ListNode listNodeB = A;

        while(listNodeB != null)
        {
            listNodeB = listNodeB.next;
            size++;
        }
        if(size <= B){
            A = A.next;
            return A;
        }

        listNodeB = A;

        int positionToRemove = size - B;
        int start = 0;
        while (start < positionToRemove)
        {
            if(start == positionToRemove-1)
            {
                if(listNodeB.next != null){
                    listNodeB.next = listNodeB.next.next;
                }
                else {
                    listNodeB.next = null;
                }
            }
            listNodeB = listNodeB.next;
            start++;
        }

        return A;
    }
}
