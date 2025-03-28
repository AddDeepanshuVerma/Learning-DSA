package LeetCode_33Question_challenge_2025.week3;

import java.util.Random;
import java.util.TreeMap;

public class Q8_2 {
    private final TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    private final Random random = new Random();
    int total = 0;


    public Q8_2(int[] w) {
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            map.put(total, i);
        }
    }

    public int pickIndex() {
        return map.get(map.higherKey(random.nextInt(total)));
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Q8_2 obj = new Q8_2(nums);
        int i = obj.pickIndex();
    }
}
