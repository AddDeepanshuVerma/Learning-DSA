package _07_Sorting.Ques.Medium;

import jdk.jfr.Description;

import java.util.*;


class threeSum_15 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(arr);
        for (List<Integer> set : lists) {
            System.out.println(set);
        }
        System.out.println(lists.size());
    }

    @Description("passed all testcases + optimal solution")
    public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i + 2 < arr.length; ++i) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int l = i + 1;
            int r = arr.length - 1;
            while (l < r) {
                final int sum = arr[i] + arr[l] + arr[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(arr[i], arr[l++], arr[r--]));
                    while (l < r && arr[l] == arr[l - 1]) ++l;
                    while (l < r && arr[r] == arr[r + 1]) --r;
                } else if (sum < 0) {
                    ++l;
                } else {
                    --r;
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum2(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, target = 0;
        Set<List<Integer>> hashSets = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            target = target - arr[i];
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int sum = arr[start] + arr[end];
                if (sum == target) {
                    hashSets.add(Arrays.asList(arr[i], arr[start++], arr[end--]));
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
            target = 0;
        }
        return new ArrayList<>(hashSets);
    }

    private static List<List<Integer>> threeSum2TBD(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, target = 0;
        List<List<Integer>> hashSets = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            target = target - arr[i];
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int sum = arr[start] + arr[end];
                if (sum == target) {
                    hashSets.add(Arrays.asList(arr[i], arr[start++], arr[end--]));
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
            target = 0;
        }
        return hashSets;
    }
}