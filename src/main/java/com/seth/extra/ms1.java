package com.seth.extra;

import java.util.HashSet;
import java.util.Set;

public class ms1 {
    public void solution2(int N) {
        int enable_print = 0;
        while (N > 0) {
            if (N % 10 != 0) {
                enable_print = 1;
            }
            if (enable_print == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }

    //10
    public void solution(int N) {
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print == 0 && (N / 10) % 10 != 0) {
                enable_print = 1;
            } else if (enable_print != 0) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }

    //43
    public boolean solution(int[] A) {
        Set<Integer> a = new HashSet<>();
        for (Integer integer : A) {
            a.add(integer);
        }
        for (Integer integer : a) {
            if (hasPair(a, integer)) return true;
        }
        return false;
    }

    private boolean hasPair(Set<Integer> a, int val) {
        return a.contains(val + 1) || a.contains(val - 1);
    }

}
