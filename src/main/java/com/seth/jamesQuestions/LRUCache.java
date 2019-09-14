package com.seth.jamesQuestions;

import java.util.LinkedHashMap;

public class LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    private int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    public int get(int key) {
        Integer value = this.map.get(key);
        if (value == null) {
            value = -1;
        } else {
            this.map.remove(key);
            map.put(key, value);
        }
        return value;
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            this.map.remove(key);
        } else if (this.map.size() == this.capacity) {
            Integer removeKey = null;
            for (Integer mapKey : map.keySet()) {
                removeKey = mapKey;
                break;
            }
            map.remove(removeKey);
        }
        map.put(key, value);
    }
}