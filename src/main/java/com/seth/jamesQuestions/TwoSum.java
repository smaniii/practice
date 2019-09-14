package com.seth.jamesQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    private HashMap<Integer, Integer> hashMap = new HashMap<>();
    private List<Integer> integerList = new ArrayList<>();
    public int[] twoSum(int[] nums, int target) {
        createTheHashMap(nums);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer integer = entry.getKey();
            Integer integer2 = entry.getValue();
            if(target == (integer*2) && integer2 == 1) return new int[] {};
            else if(target == (integer*2) && integer2 > 1) return new int[]{integerList.indexOf(integer), integerList.lastIndexOf((integer))};
            else if(hashMap.containsKey((target - integer))) return new int[] {integerList.indexOf(integer), integerList.indexOf(Integer.valueOf(target - integer))};
        }
        return new int[] {};
    }

    private void createTheHashMap(int [] nums) {
        for (int num : nums) {
            integerList.add(num);
            if (hashMap.containsKey(num)) {
                hashMap.put(num, (hashMap.get(num) + 1));
            } else {
                hashMap.put(num, 1);
            }
        }
    }

}
