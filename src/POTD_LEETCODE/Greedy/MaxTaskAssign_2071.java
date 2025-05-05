package POTD_LEETCODE.Greedy;

import java.util.Arrays;

class MaxTaskAssign_2071 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int count = 0, i = 0, j = 0;
        int n = tasks.length, m = workers.length;

        while (i < n && j < m) {
            if (workers[j] >= tasks[i]) {
                count++;
                i++;
            } else if (pills > 0 && workers[j] + strength >= tasks[i]) {
                count++;
                i++;
                pills--;
            }
            j++;
        }
        return count;
    }
}