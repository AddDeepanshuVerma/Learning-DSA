package POTD_LEETCODE.HashMap;

import java.util.Arrays;
import java.util.HashMap;

class NumEquivDominoPairs_1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int[] domino : dominoes) {
            Arrays.sort(domino);
            map.merge(domino[0] + "" + domino[1], 1, Integer::sum);
        }

        int count = 0;
        for (Integer v : map.values()) {
            count += (v * (v - 1)) >> 1;
        }
        return count;
    }

    public int numEquivDominoPairs2(int[][] dominoes) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] domino : dominoes) {
            Arrays.sort(domino);
            map.merge((domino[0] * 10) + domino[1], 1, Integer::sum);
        }

        int count = 0;
        for (Integer v : map.values()) {
            count += (v * (v - 1)) >> 1;
        }
        return count;
    }

    public int numEquivDominoPairs3(int[][] dominoes) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] domino : dominoes) {
            int min = Math.min(domino[0], domino[1]);
            int max = Math.max(domino[0], domino[1]);

            map.merge((min * 10) + max, 1, Integer::sum);
        }

        int count = 0;
        for (Integer v : map.values()) {
            count += (v * (v - 1)) >> 1;
        }
        return count;
    }
}