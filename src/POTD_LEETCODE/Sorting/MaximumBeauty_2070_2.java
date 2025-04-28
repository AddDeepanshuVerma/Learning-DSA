package POTD_LEETCODE.Sorting;

import java.util.Arrays;

class MaximumBeauty_2070_2 {
    public static void main(String[] args) {
        int[][] items = {{193, 732}, {781, 962}, {864, 954}, {749, 627}, {136, 746}, {478, 548}, {640, 908}, {210, 799}, {567, 715}, {914, 388}, {487, 853},
                {533, 554}, {247, 919}, {958, 150}, {193, 523}, {176, 656}, {395, 469}, {763, 821}, {542, 946}, {701, 676}};

        int[] queries = {885, 1445, 1580, 1309, 205, 1788, 1214, 1404, 572, 1170, 989, 265, 153, 151, 1479, 1180, 875, 276, 1584};

        System.out.println(Arrays.toString(maximumBeauty(items, queries)));
    }

    public static int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = findValue(items, queries[i]);
        }
        return ans;
    }

    private static int findValue(int[][] items, int atMost) {
        for (int[] item : items) {
            if (item[0] <= atMost) {
                return item[1];
            }
        }
        return 0;
    }
}