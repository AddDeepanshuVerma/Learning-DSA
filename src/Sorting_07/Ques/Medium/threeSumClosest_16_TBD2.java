package Sorting_07.Ques.Medium;

import java.util.Arrays;

class threeSumClosest_16_TBD2 {
    public static void main(String[] args) {
        int[] arr = {0,0,0};
        System.out.println(threeSumClosest2(arr, 1));
    }

    public static int threeSumClosest2(int[] arr, int target) {
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int tempTarget = target - arr[i] - arr[j];
                int sum = binarySearchClosestElement(arr, j + 1, tempTarget) + arr[i] + arr[j];
                if(ans > Math.abs(target - sum)){
                    ans = Math.abs(target - sum);
                    res = sum;
                }
            }
        }
        return res;
    }

    private static int binarySearchClosestElement(int[] arr, int leftMost, int target) {
        int start = leftMost;
        int end = arr.length - 1, mid = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (arr[mid] == target) {
                return arr[mid];
            } else if (target < arr[mid]) {
                end = mid -1;
            }else {
                start = mid + 1;
            }
        }
        int left = end < leftMost ? Integer.MAX_VALUE/2: arr[end];
        int right = start > arr.length - 1 ? Integer.MAX_VALUE/2 : arr[start];
        if(Math.abs(left - target) < Math.abs(right - target)){
            return left;
        }else {
            return right;
        }
    }

    public static int threeSumClosest(int[] arr, int target) {
        int ans = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(ans > Math.abs(target - sum)){
                        ans = Math.abs(target - sum);
                        res = sum;
                    }
                }
            }
        }
        return res;
    }

}