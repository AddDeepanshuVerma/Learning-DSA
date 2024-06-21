package DailyCodeChallenge.Binary_Search_on_answers;

import java.util.Arrays;

class MinimumTime_2187 {
    public static void main(String[] args) {
        int[] arr = {10000000};
        long num = Integer.MAX_VALUE;
        System.out.println(minimumTime(arr, 10000000 ));
//        System.out.println(Integer.MAX_VALUE);
    }
    public static long minimumTime(int[] time, int totalTrips) {
        long start = 1;
//        long end = (long) 1E18;
        long end = Long.MAX_VALUE;
        long ans = -1;
        int count =0;
        while (start <= end) {
            long mid = (start + end) >>> 1;
            count++;
            if (isValid(time, mid, totalTrips)) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        System.out.println(count);
        return ans;
    }
    private static boolean isValid(int[] time, long mid, long totalTrips) {
        long count = 0;
        for (int num : time) {
            count += mid / num;
            if(count >= totalTrips)
                return true;
        }
        return false;
    }

    private static boolean isValid2(int[] time, long mid, long totalTrips) {
        long count = 0;
        for (int num : time) {
            count += mid / num;
        }
        return count >= totalTrips;
    }
}