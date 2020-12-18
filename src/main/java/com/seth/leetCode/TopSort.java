package com.seth.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopSort {
    public List<String> findTaskOrder(List<String> stringList, String[][] preReq) {
        Map<String, Task>  buildTaskGraph = buildTaskGraph(stringList, preReq);
        Map<String, Integer> track = track(stringList);
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            if(!dfs(buildTaskGraph, solution, stringList.get(i), track)) return new ArrayList<>();
        }
        return solution;
    }

    private boolean dfs(Map<String, Task> buildTaskGraph, List<String> solution, String start, Map<String, Integer> track) {
        if (track.get(start) == 1) return false;
        else if (track.get(start) == 2) return true;

        track.put(start, 1);

        Task currentTask = buildTaskGraph.get(start);
        for(int i = 0; i < currentTask.requiredTaskList.size(); i++) {
            if(!dfs(buildTaskGraph, solution, currentTask.requiredTaskList.get(i).Task, track)) return false;
        }
        track.put(start, 2);
        solution.add(currentTask.Task);
        return true;
    }

    private Map<String, Integer> track(List<String> stringList) {
        Map<String, Integer> track = new HashMap<>();
        for (String s : stringList) {
            track.put(s, 0);
        }
        return track;
    }

    private Map<String, Task>  buildTaskGraph(List<String> stringList, String[][] preReq) {
        Map<String, Task>  buildTaskGraph = new HashMap<>();
        for (String s : stringList) {
            Task task = new Task(s);
            buildTaskGraph.put(s, task);
        }
        for (int i = 0; i < preReq.length; i++) {
            String thisString = preReq[i][0];
            String requiresString = preReq[i][1];
            buildTaskGraph.get(thisString).requiredTaskList.add(buildTaskGraph.get(requiresString));
        }
        return buildTaskGraph;
    }
    
    private class Task {
        String Task;
        List<Task> requiredTaskList;

        public Task(String task) {
            Task = task;
            requiredTaskList = new ArrayList<>();
        }
    }
}
