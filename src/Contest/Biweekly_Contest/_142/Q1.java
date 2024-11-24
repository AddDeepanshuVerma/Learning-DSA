package Contest.Biweekly_Contest._142;

import java.util.HashMap;

public class Q1 {
    public static void main(String[] args) {
        int[] arr = {};
        Q1 obj = new Q1();

    }

    public int possibleStringCount(String word) {
        int count = 0;
        char[] arr = word.toCharArray();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            }
        }
        return count;
    }

    public int possibleStringCount2(String word) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char vh : word.toCharArray()) {
            map.merge(vh, 1, Integer::sum);
        }
        int count = 0;

        for (Integer value : map.values()) {
            if (value > 1) {
                count += value - 1;
            }
        }

        return count + 1;
    }
}
