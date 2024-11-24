package POTD_LEETCODE.Array;

import java.util.*;

class ArrayRankTransform_1331 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 40};
        int[] temp = ArrayRankTransform_1331.arrayRankTransform2(arr);
        System.out.println(Arrays.toString(temp));
    }

    /*@Description("Works, if array elements are non-negative")
    public int[] arrayRankTransform2(int[] arr) {
        int[] dp = new int[10001];
        for (int num : arr) dp[num] = 1;

        int prefix = 1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 1) {
                dp[i] = prefix;
                prefix++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = dp[arr[i]];
        }
        return arr;
    }*/

    public static int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();// [40,10,20,30]
        Arrays.sort(temp);// [10,20,30,40]

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : temp) {
            map.put(num, map.getOrDefault(num, map.size() + 1));
        }
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = map.get(arr[i]);
//        }
        Arrays.setAll(arr, i -> map.get(arr[i]));
        return arr;
    }

    public static int[] arrayRankTransform2(int[] arr) {
        int[] temp = arr.clone();// [40,10,20,30]
        Arrays.sort(temp);// [10,20,30,40]

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : temp) {
            if (!map.containsKey(num)) map.put(num, map.size() + 1);
        }
        Arrays.setAll(arr, i -> map.get(arr[i]));
        return arr;
    }

}