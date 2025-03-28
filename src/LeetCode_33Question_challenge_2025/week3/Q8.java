package LeetCode_33Question_challenge_2025.week3;

import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class Q8 {
    private final TreeMap<Integer, Integer> treeMap;
    Random random = new Random();
    int totalSum;

    public Q8(int[] w) {
        treeMap = new TreeMap<>();
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            treeMap.put(sum, i);
            sum += w[i];
        }
        totalSum = sum;
    }

    public int pickIndex() {
        int randomWeight = random.nextInt(totalSum);
        return treeMap.floorEntry(randomWeight).getValue();
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Q8 obj = new Q8(nums);
        int i = obj.pickIndex();
    }
}
