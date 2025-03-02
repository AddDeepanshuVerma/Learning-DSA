package POTD_LEETCODE.Array;

import java.util.*;

class MergeArrays_2570 {
    public static void main(String[] args) {
        int[][] num1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] num2 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] ans = mergeArrays2(num1, num2);
        for (int[] an : ans) {
            System.out.println("ans = " + Arrays.toString(an));
        }
    }

    private static int[][] mergeArrays2(int[][] n1, int[][] n2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] arr : n1) {
            map.merge(arr[0], arr[1], Integer::sum);
        }
        for (int[] arr : n2) {
            map.merge(arr[0], arr[1], Integer::sum);
        }

        int[][] ans = new int[map.size()][2];
        int i = 0;
        for (var item : map.entrySet()) {
            ans[i] = new int[]{item.getKey(), item.getValue()};
            i++;
        }
        return ans;
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;

        List<int[]> list = new ArrayList<>();

        while (i < n && j < m) {
            if (nums1[i][0] == nums2[j][0]) {
                list.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                list.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            } else {
                list.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            }
        }

        while (i < n) {
            list.add(new int[]{nums1[i][0], nums1[i][1]});
            i++;
        }
        while (j < m) {
            list.add(new int[]{nums2[j][0], nums2[j][1]});
            j++;
        }

        int[][] array = list.toArray(int[][]::new);

        int[][] res = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}