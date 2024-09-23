package _17_SlidingWindow.easy_medium.VariableSize;

import java.util.HashMap;

class TotalFruit_90 {
    public int totalFruit(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, count = 0;
        for (int j = 0; j < arr.length; j++) {
            map.merge(arr[j], 1, Integer::sum);

            while (map.size() > 2) {
                int temp = map.get(arr[i]);
                if (temp == 1) map.remove(arr[i]);
                else map.put(arr[i], temp - 1);
                i++;
            }

            if (map.size() == 2) {
                count = Math.max(count, j - i + 1);
            }
        }
        return count;
    }
}