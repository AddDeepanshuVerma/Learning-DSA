package DailyCodeChallenge.LinkedList;

import java.util.*;

class AllOne {
    private final Map<String, Integer> stringCount;
    private final TreeMap<Integer, Set<String>> bucketMap;

    public AllOne() {
        stringCount = new HashMap<>();
        bucketMap = new TreeMap<>();
    }

    public void inc(String key) {
        int newCount = stringCount.merge(key, 1, Integer::sum);
        removeFromOldBucket(key, newCount - 1);
        addToNewBucket(key, newCount);
    }

    public void dec(String key) {
        int newCount = stringCount.merge(key, -1, Integer::sum);
        if (newCount == 0) {
            stringCount.remove(key);
        }
        removeFromOldBucket(key, newCount + 1);
        addToNewBucket(key, newCount);
    }

    private void removeFromOldBucket(String key, int val) {
        if (val > 0) {
            Set<String> oldBucket = bucketMap.get(val);
            if (oldBucket.size() == 1) {
                oldBucket.clear();
                bucketMap.remove(val);
            } else {
                oldBucket.remove(key);
            }
        }
    }

    private void addToNewBucket(String key, int bucketKey) {
        if (bucketKey > 0) {
            bucketMap.computeIfAbsent(bucketKey, k -> new HashSet<>()).add(key);
        }
    }

    public String getMaxKey() {
        return bucketMap.isEmpty() ? "" : bucketMap.lastEntry().getValue().iterator().next();
    }

    public String getMinKey() {
        return bucketMap.isEmpty() ? "" : bucketMap.firstEntry().getValue().iterator().next();
    }
}