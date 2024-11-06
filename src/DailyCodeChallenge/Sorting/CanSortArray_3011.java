package DailyCodeChallenge.Sorting;

import java.util.Arrays;
import java.util.HashMap;

class CanSortArray_3011 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        System.out.println(canSortArray(nums));
    }

    public static boolean canSortArray(int[] nums) {
        // apply bubble sort
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    if (Integer.bitCount(nums[j]) != Integer.bitCount(nums[j - 1])) {
                        return false;
                    }
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return true;
    }

    //Optimized bubble sort but did not affect on questions testcases.
    public static boolean canSortArray2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, Integer.bitCount(num));
            }
        }

        // now apply bubble sort
        outer:
        for (int i = 0; i < nums.length; i++) {
            boolean swapped = false;
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    if (map.get(nums[j]).intValue() != map.get(nums[j - 1]).intValue()) {
                        return false;
                    }
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) break outer;
        }
        return true;
    }

    //simple bubble sort algo
    public static boolean canSortArray3(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, Integer.bitCount(num));
            }
        }

        // now apply bubble sort
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    if (map.get(nums[j]).intValue() != map.get(nums[j - 1]).intValue()) {
                        return false;
                    }
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return true;
    }
}