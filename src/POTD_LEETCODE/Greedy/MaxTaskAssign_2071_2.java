package POTD_LEETCODE.Greedy;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

class MaxTaskAssign_2071_2 {
    public static int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int worker : workers) map.merge(worker, 1, Integer::sum);

        Arrays.sort(tasks);

        int count = 0;
        int n = tasks.length;

        for (int task : tasks) {
            Map.Entry<Integer, Integer> key = map.higherEntry(task);
            if (key != null && key.getValue() > 0) {
                count++;
                if (key.getValue() == 1) {
                    map.remove(key.getKey());
                } else {
                    map.merge(key.getKey(), -1, Integer::sum);
                }
            } else if (pills > 0) {
                key = map.higherEntry(Math.max(0, task - strength));
                if (key != null && key.getValue() > 0) {
                    count++;
                    pills--;
                    if (key.getValue() == 1) {
                        map.remove(key.getKey());
                    } else {
                        map.merge(key.getKey(), -1, Integer::sum);
                    }
                }
            } else break;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] tasks = {3, 2, 1};
        int[] workers = {0, 3, 3};
        int count = maxTaskAssign(tasks, workers, 1, 1);
        System.out.println("count = " + count);
    }
}