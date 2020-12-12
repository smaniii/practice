package com.seth.extra;

import java.util.HashSet;
import java.util.Set;

public class LowestPossibleInt
{
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> a = new HashSet<>();
        for (int i : A)
        {
            a.add(i);
        }
        int i = 1;
        while(i > 0)
        {
            if (!a.contains(i)) break;
            i++;
        }
        return i;
    }
}
