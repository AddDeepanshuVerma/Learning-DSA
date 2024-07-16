package _06_Searching;

import java.util.Arrays;
import java.util.HashSet;

public class FindDuplicate_287 {
    public static void main(String[] args) {
        int[] nums = {7,9,7,4,2,8,7,7,1,5}; //expected 8
        System.out.println(findDuplicate4(nums));
    }
    public static int findDuplicate4(int[] arr) {
        int n = arr.length;
        int expectedSumOfElements = (n * (n+1))/2;
        int givenSum = 0;
        for (int i : arr) {
            givenSum += i;
        }
        if(givenSum == expectedSumOfElements) return arr[0];
        return givenSum + n - expectedSumOfElements ;
    }
    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int s = 0, e = nums.length - 1, mid = 0, ans = -1;
        while (s <= e) {
            mid = (s + e) >> 1;
            if (nums[mid] <= mid) {
                e = mid - 1;
            } else {
                ans = mid;
                s = mid + 1;
            }
        }
        return nums[ans];
    }

    public static int findDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)) return num;
            else set.add(num);
        }
        return -1;
    }
    public static int findDuplicate3(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]){
                return arr[i];
            }
        }
        return -1;
    }

}
