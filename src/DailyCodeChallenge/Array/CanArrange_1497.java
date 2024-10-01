package DailyCodeChallenge.Array;

import java.util.HashMap;

class CanArrange_1497 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        boolean x = CanArrange_1497.canArrange(arr, 5);
        System.out.println(x);
    }

    public static boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int n = arr.length;
        for (int num : arr) {
            int val = ((num % k) + k) % k;
            int find = (k - val) % k;
            if (!map.isEmpty() && map.containsKey(find)) {
                int merged = map.merge(find, -1, Integer::sum);
                if (merged == 0) map.remove(find);
                ans++;
            } else {
                map.merge(val, 1, Integer::sum);
            }
        }
        return ans == (n >> 1);
    }

    public static boolean canArrange2(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int n = arr.length;
        for (int j : arr) {
            int val = ((j % k) + k) % k;
            if (!map.isEmpty() && map.containsKey(val)) {
                int merged = map.merge(val, -1, Integer::sum);
                if (merged == 0) map.remove(val);
                ans++;
            } else {
                map.merge((k - val) % k, 1, Integer::sum);
            }
        }
        return ans == (n >> 1);
    }
}