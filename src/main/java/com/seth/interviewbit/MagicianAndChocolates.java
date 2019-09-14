package com.seth.interviewbit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

public class MagicianAndChocolates {
    public static int nchoc(int A, ArrayList<Integer> B) {
        double totalNum = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());
        for (Integer integer : B) {
            if(treeMap.containsKey(integer)){
                treeMap.put(integer, (treeMap.get(integer) + 1));
            }
            else {
                treeMap.put(integer, 1);
            }
        }
        for(int i=0; i<A;i++){
            int key = treeMap.firstKey();
            totalNum = totalNum + key;
            if(treeMap.get(key) == 1){
                treeMap.remove(key);
            }
            else {
                treeMap.put(key, treeMap.get(key) - 1);
            }
            int newKey = key /2;
            if(treeMap.containsKey(newKey)){
                treeMap.put(newKey, treeMap.get(newKey) + 1);
            }
            else {
                treeMap.put(newKey, 1);
            }
        }
        return (int) (totalNum % (Math.pow(10, 9)+7));
    }
}
