package _18_SegmentTree.hard;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CountSmaller_315 {
    @Description("Brute force approach")
    public List<Integer> countSmaller_tle(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) count++;
            }
            ans.add(count);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 1};
        System.out.println(countSmaller(arr));
    }

    public static List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int num : nums) arr.add(num);
        Collections.sort(arr);

        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            int index = binarySearch(arr, num);
            ans.add(index);
            arr.remove(index);
        }

        return ans;
    }

    public static int binarySearch(ArrayList<Integer> arr, int target) {
        int start = 0, end = arr.size() - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            int curr = arr.get(mid);
            if (curr > target) {
                end = mid - 1;
            } else if (curr < target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
}