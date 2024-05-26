package Searching_06;

import java.util.Arrays;
// not passing all test cases
public class MaxFrequency_1838_2 {
    public static void main(String[] args) {
        int[] nums = {3,9,6}; //expected 8
        System.out.println(maxFrequency(nums, 2));
    }

    public static int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        int start = 0,
                end = arr.length-1,
                mid = 0,
                ans = -1;
        while (start <= end) {
            mid = (start+end)>>1;
            if (arr[mid] * (mid + 1) <= sum(arr,mid) + k) {
                ans = mid;
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }
        return ans+1;
    }

    private static int sum(int[] arr, int mid) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i <= mid) {
                sum += arr[i];
            } else break;
        }
        return sum;
    }

}
