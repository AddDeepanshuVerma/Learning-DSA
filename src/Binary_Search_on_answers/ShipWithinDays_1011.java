package Binary_Search_on_answers;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

class ShipWithinDays_1011 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 4, 1, 4};
        System.out.println(shipWithinDays(arr, 3));
//        System.out.println(daysSpent(arr, 4));
    }
    public static int shipWithinDays(int[] weights, int days) {
        IntSummaryStatistics sum = Arrays.stream(weights).summaryStatistics();
        int start = sum.getMax();
        int end = (int) sum.getSum();
        int ans = -1;
        while (start <= end) {
            int capacity = (start + end) >>> 1;
            if (getDays(weights, capacity) <= days) {
                ans = capacity;
                end = capacity - 1;
            } else start = capacity + 1;
        }
        return ans;
    }

    private static int daysSpent(int[] weights, int capacity) {
        int days = 1;
        int load = 0;
        for (int weight : weights) {
            if (load + weight <= capacity) {
                load += weight;
            } else {
                days++;
                load = weight;
            }
        }
        return days;
    }

    public static int getDays(int[] arr, int weight) {
        int countDays = 1;
        int load = 0;
        for (int i = 0; i < arr.length; i++) {
            if(load + arr[i] > weight){
                countDays++;
                load = arr[i];
            }else{
                load += arr[i];
            }
        }
        return countDays;
    }
}