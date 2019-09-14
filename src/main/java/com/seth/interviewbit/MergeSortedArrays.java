package com.seth.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArrays {
    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> merged = new ArrayList<>();
        merge(a, b, merged, 0, 0);
        a.clear();
        a.addAll(merged);
    }

    private static void merge(List<Integer> a, List<Integer> b, List<Integer> merged, int indexA, int indexB){

        if(a.size() == indexA  && b.size() == indexB){
            return;
        }
        else if(a.size() == indexA){
            merged.add(b.get(indexB));
            merge(a, b, merged, indexA, indexB + 1);
        }
        else if(b.size() == indexB){
            merged.add(a.get(indexA));
            merge(a, b, merged, indexA + 1, indexB);
        }
        else if(a.get(indexA) <= b.get(indexB)){
            merged.add(a.get(indexA));
            merge(a, b, merged, indexA + 1, indexB);
        }
        else if(a.get(indexA) > b.get(indexB)){
            merged.add(b.get(indexB));
            merge(a, b, merged, indexA, indexB + 1);
        }
    }

}
