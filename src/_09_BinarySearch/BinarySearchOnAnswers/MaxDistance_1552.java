package _09_BinarySearch.BinarySearchOnAnswers;

import java.util.Arrays;

class MaxDistance_1552 {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,1000000000};
        System.out.println(maxDistance(arr, 2));
    }
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start = 1;
        int end = position[position.length - 1] - position[0];

        int ans = -1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (allowed_with_this_Distance(position, m, mid)) {
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }

    private static boolean allowed_with_this_Distance(int[] arr, int balls, int distance) {
        int prev_Index_value = -distance;
        int noOfBalls = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - prev_Index_value >= distance) {
                prev_Index_value = arr[i];
                noOfBalls++;
                if (noOfBalls >= balls) {
                    return true;
                }
            }
        }
        return false;
    }

}