package Contest.Weekly_Contest._417;

import java.util.HashMap;

class countOfSubstrings_2 {
    public int countOfSubstrings(String word, int k) {
        char[] arr = word.toCharArray();
        int i = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        int mapCount = 0;
        int conso = 0;

        int ans = 0;
        for (int j = 0; j < arr.length; j++) {
            char ch = arr[j];
            if (map.containsKey(ch)) {
                if (map.get(ch) == 0) {
                    mapCount++;
                }
                map.merge(ch, 1, Integer::sum);
            } else {
                conso++;
            }
            if (map.size() == mapCount && conso == 1) {
                ans++;
            }
            while (conso > 1) {
                if (map.containsKey(arr[i])) {
                    int val = map.get(arr[i]);
                    if (val == 1) mapCount--;
                    map.put(arr[i], val - 1);
                } else {
                    conso--;
                }
                i++;
            }

        }
        return ans;
    }

}