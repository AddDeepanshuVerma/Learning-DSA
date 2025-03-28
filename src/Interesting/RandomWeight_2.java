package Interesting;

import jdk.jfr.Description;

import java.util.Random;
import java.util.TreeMap;

@Description("528. Random Pick with Weight")
class RandomWeight_2 {
    private final TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    private final Random random = new Random();
    int total = 0;


    public RandomWeight_2(int[] w) {
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            map.put(total, i);
        }
    }

    public int pickIndex() {
        //if we choose to get higher key then there would never be a null value returned
        // as total is exclusive in nextInt call and we have total in treeMap
        return map.get(map.higherKey(random.nextInt(total)));
    }
}