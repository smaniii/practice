package com.seth.interviewbit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestConsecutive {
    public static int longestConsecutive(final List<Integer> A) {
        Set<Integer> setA = new HashSet<>(A);
        Map<Integer, Integer> memoizationDown = new HashMap<>();
        int result = 0;
        for (Integer integer: setA) {
            int countDown = 1;
            int down = integer - 1;
            boolean breakDown = false;
            while (setA.contains(down) && !breakDown){
                if(memoizationDown.containsKey(down)){
                    breakDown = true;
                    countDown = countDown + memoizationDown.get(down);
                }
                else {
                    down--;
                    countDown++;
                }
            }
            memoizationDown.put(integer, countDown);
            result = Math.max(result, (countDown));
        }
        return result;
    }
    public static int longestConsecutive(final List<Integer> A, int n) {
        return 0;
    }
}
