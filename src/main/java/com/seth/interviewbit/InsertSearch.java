package com.seth.interviewbit;

import java.util.ArrayList;

public class InsertSearch {

    public static int searchInsert(ArrayList<Integer> a, int b) {
        int lower = 0;
        int higher = a.size() - 1;
        while (lower <= higher) {
            if(a.get(lower) == b) return lower;
            if(a.get(higher) == b) return higher;
            int mid = (higher + lower) / 2;
            if(a.get(mid) == b) return mid;
            if(a.get(mid) < b) {
                lower = mid + 1;
            }
            else if(a.get(mid) > b) {
                higher = mid - 1;
            }
        }
        if(a.get((lower + higher) / 2) < b) return (lower + higher) / 2 + 1;
        return (lower + higher) / 2;

    }

}
