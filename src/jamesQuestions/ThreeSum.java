package jamesQuestions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
    private Set<Integer> used = new HashSet<>();
    private HashMap<Integer, Integer> frequencyMap = new HashMap<>();

    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Set<List<Integer>> solutions = new HashSet<>();
        for (int num : nums) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, (frequencyMap.get(num) + 1));
            } else {
                frequencyMap.put(num, 1);
            }
        }
        for (int num : nums) {
            List<List<Integer>> solution = twoSum(num, (target - num));
            if (solution != null) {
                for (List<Integer> s : solution) {
                    s.add(num);
                    s.sort(Comparator.naturalOrder());
                    solutions.add(s);
                }
            }
        }
        return new ArrayList<>(solutions);
    }

    private List<List<Integer>> twoSum(int skipNumber, int target) {
        if(used.contains(skipNumber)) return null;
        List<List<Integer>> solutions = new ArrayList<>();
        used.add(skipNumber);
        frequencyMap.put(skipNumber, frequencyMap.get(skipNumber) - 1);
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            Integer k = entry.getKey();
            if(target == k*2 && frequencyMap.get(k) > 1) {
                List<Integer> solution = new ArrayList<>();
                solution.add(k);
                solution.add(k);
                solutions.add(solution);
            }
            else if(target != k*2 && frequencyMap.containsKey(target - k) && frequencyMap.get(target - k) > 0 && frequencyMap.get(k) > 0) {
                List<Integer> solution = new ArrayList<>();
                solution.add(k);
                solution.add(target - k);
                solutions.add(solution);
            }
        }
        frequencyMap.put(skipNumber, frequencyMap.get(skipNumber) + 1);
        return solutions;
    }

}


