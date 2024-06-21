package Sorting_07.Ques.Medium;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// dp : good ques
class merge_56 {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(merge(arr)));
    }
    @Description("passed all testcases + optimal solution")
    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start, end});
        // dp : convert list of 1d array to array of array
        return res.toArray(int[][]::new);
//        return res.toArray(new int[res.size()][]);
    }

    @Description("doesn't work as expected")
    public static int[][] merge2(int[][] intervals) {
        int max = -1;
        for (int[] interval : intervals) {
            for (int i : interval) {
                max = Math.max(max, i);
            }
        }
        int[] combined = new int[max + 1];
        for (int[] interval : intervals) {
            putValues(combined, interval);
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < combined.length; i++) {
            if (combined[i] > 0) {
                int first = i;
                while (i < combined.length && combined[i] > 0) {
                    i++;
                }
                int second = i - 1;
                list.add(new int[]{first, second});
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private static void putValues(int[] combined, int[] interval) {
        for (int i = interval[0]; i <= interval[1]; i++) {
            combined[i]++;
        }
    }
}