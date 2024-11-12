package DailyCodeChallenge.Sorting;

import java.util.*;

class MaximumBeauty_2070 {
    public static void main(String[] args) {
        int[][] items = {{193, 732}, {781, 962}, {864, 954}, {749, 627}, {136, 746}, {478, 548}, {640, 908}, {210, 799}, {567, 715}, {914, 388}, {487, 853},
                {533, 554}, {247, 919}, {958, 150}, {193, 523}, {176, 656}, {395, 469}, {763, 821}, {542, 946}, {701, 676}};

        int[] queries = {885, 1445, 1580, 1309, 205, 1788, 1214, 1404, 572, 1170, 989, 265, 153, 151, 1479, 1180, 875, 276, 1584};

        System.out.println(Arrays.toString(maximumBeauty(items, queries)));
    }

    public static int[] maximumBeauty(int[][] items, int[] queries) {
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for (int[] item : items) {
            map.computeIfAbsent(item[0], q -> new PriorityQueue<>(Collections.reverseOrder())).add(item[1]);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            Integer key = map.floorKey(queries[i]);
            if (key != null) {
                ans[i] = map.get(key).peek();
            }
        }
        return ans;
    }
}