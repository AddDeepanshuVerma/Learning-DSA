package DailyCodeChallenge.Level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Intersect_350 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(Intersect_350.intersect2(nums1, nums2)));
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        int[] result = new int[1001];
        for (int num : nums1) {
            arr[num]++;
        }
        int ctr = 0;
        for (int num : nums2) {
            if (arr[num] > 0) {
                result[ctr++] = num;
                arr[num]--;
            }
        }
        return Arrays.copyOfRange(result, 0, ctr);
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return intersect2(nums2, nums1);
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]); i++; j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            }else {
                j++;
            }
        }
        System.out.println("list = " + list);
        return list.stream().mapToInt(n -> n).toArray();
    }
}