package interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;

public class ClosestSmallestOnTheStack {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        int smallest = Integer.MAX_VALUE;
        LinkedList<Integer> prevNodes = new LinkedList<>();
        ArrayList<Integer> prevSmaller = new ArrayList<>();
        for (Integer integer : A) {
            if (integer < smallest) {
                smallest = integer;
                prevNodes.addFirst(integer);
                prevSmaller.add(-1);
                continue;
            }
            boolean foundSmaller = false;
            for (Integer prevNode : prevNodes) {
                if (prevNode < integer) {
                    foundSmaller = true;
                    prevSmaller.add(prevNode);
                    prevNodes.addFirst(integer);
                    break;
                }
            }
            if (!foundSmaller) {
                prevNodes.addFirst(integer);
                prevSmaller.add(-1);
            }
        }
        return prevSmaller;
    }
}
