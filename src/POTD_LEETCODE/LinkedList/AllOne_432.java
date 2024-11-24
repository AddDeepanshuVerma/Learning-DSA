package POTD_LEETCODE.LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

class AllOne_432 {
    HashMap<String, Integer> map;
    TreeMap<Integer, HashSet<String>> treeMap;


    public AllOne_432() {
        map = new HashMap<>();
        treeMap = new TreeMap<>();
    }

    public void inc(String key) {
        int updatedValue = map.merge(key, 1, Integer::sum);
//        updateTreeMapBucket(key, updatedValue, true);// correct treeMap bucket
        removeFromOldBucket(key, updatedValue - 1);
        addToNewBucket(key, updatedValue);

    }

    public void dec(String key) {
        int updatedValue = map.merge(key, -1, Integer::sum);
        if (updatedValue == 0) map.remove(key);

//        updateTreeMapBucket(key, updatedValue, false);// correct treeMap bucket
        removeFromOldBucket(key, updatedValue + 1);
        addToNewBucket(key, updatedValue);
    }

    private void addToNewBucket(String key, int value) {
        if (value >= 1) {
            treeMap.computeIfAbsent(value, k -> new HashSet<>()).add(key);
        }
    }

    private void removeFromOldBucket(String key, int value) {
        if (value >= 1) {
            Set<String> set = treeMap.get(value);
            set.remove(key);
            if (set.isEmpty()) treeMap.remove(value);
        }
    }

    public String getMaxKey() {
        return treeMap.isEmpty() ? "" : treeMap.lastEntry().getValue().iterator().next();
    }

    public String getMinKey() {
        return treeMap.isEmpty() ? "" : treeMap.firstEntry().getValue().iterator().next();
    }

    private void updateTreeMapBucket(String key, int value, boolean incremented) {
        int preValue = incremented ? (value - 1) : (value + 1);
        // remove from bucket
        if (preValue >= 1) {
            Set<String> oldBucket = treeMap.get(preValue);
            if (oldBucket.size() == 1) {
                treeMap.remove(preValue);
            } else {
                oldBucket.remove(key);
            }
        }
        // add to bucket
        int newVal = !incremented ? (value - 1) : (value + 1);
        if (newVal >= 1) {
            treeMap.computeIfAbsent(newVal, k -> new HashSet<>()).add(key);
        }
    }
}
