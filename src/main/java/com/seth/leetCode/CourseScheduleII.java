package com.seth.leetCode;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, RequiredClass> requiredClassMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            RequiredClass requiredClass = new RequiredClass(new ArrayList<>(), i);
            requiredClassMap.put(i, requiredClass);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int thisClass = prerequisites[i][0];
            int classNeeds = prerequisites[i][1];
            RequiredClass requiredClass = requiredClassMap.get(thisClass);
            requiredClass.requiredClassList.add(requiredClassMap.get(classNeeds));
        }
        List<Integer> list = new ArrayList<>();
        int[] track = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!dfs(requiredClassMap, i, list, track)) {
                return new int[0];
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    private boolean dfs(Map<Integer, RequiredClass> requiredClassMap, int start, List<Integer> list, int[] track) {
        if(track[start]==2) return true;
        if(track[start]==1) return false;

        track[start] = 1;

        for(int i=0; i<requiredClassMap.get(start).requiredClassList.size(); i++){
            if(!dfs(requiredClassMap, requiredClassMap.get(start).requiredClassList.get(i).thisClassNumber, list, track)) {
                return false;
            }
        }
        track[start] = 2;
        list.add(start);
        return true;
    }

    private class RequiredClass {
        List<RequiredClass> requiredClassList;
        int thisClassNumber;

        public RequiredClass(List<RequiredClass> requiredClassList, int thisClassNumber) {
            this.requiredClassList = requiredClassList;
            this.thisClassNumber = thisClassNumber;
        }

        @Override
        public String toString() {
            return "RequiredClass{" +
                    "requiredClassList=" + requiredClassList +
                    ", thisClassNumber=" + thisClassNumber +
                    '}';
        }
    }
}
