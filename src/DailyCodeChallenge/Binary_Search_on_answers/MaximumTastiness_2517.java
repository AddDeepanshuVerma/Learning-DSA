package DailyCodeChallenge.Binary_Search_on_answers;

import java.util.Arrays;

class MaximumTastiness_2517 {
    public static void main(String[] args) {
        int[] arr = {13,5,1,8,21,2};
        System.out.println(maximumTastiness(arr, 3));

    }
    public static int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int sum = Arrays.stream(price).sum();
        int n = price.length;
        int start = 1;
        int end = price[n - 1] - price[0];
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (isValid(price, mid, k)) {
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }

    private static boolean isValid(int[] arr, int mid, int k) {
        int count = 1;
        int preValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - preValue >= mid) {
                count++;
                preValue = arr[i];
            }
        }
        return count >= k;
    }
}