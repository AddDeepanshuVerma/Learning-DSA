package DailyCodeChallenge;

import java.util.Arrays;

class AverageWaitingTime_1701 {
    public static void main(String[] args) {
        int[][] arr1 = {
                {1, 2},
                {2, 5},
                {4, 3}
        };
        int[][] arr = {
                {5,2},
                {5,4},
                {10,3},
                {5,2},
                {20,1}
        };
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(arr));
//        System.out.println(averageWaitingTime(arr));
    }

    public static double averageWaitingTime(int[][] arr) {

        int timeSpent = 0;
        double avgTime = 0.0;
        for (int i = 0; i < arr.length; i++) {
            timeSpent = Math.max(timeSpent, arr[i][0]);
            timeSpent += arr[i][1];
            avgTime += timeSpent - arr[i][0];
        }
        return avgTime / arr.length;
    }
}