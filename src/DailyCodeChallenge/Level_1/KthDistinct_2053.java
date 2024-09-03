package DailyCodeChallenge.Level_1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class KthDistinct_2053 {
    public String kthDistinct3(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr)
            map.put(s, map.getOrDefault(s, 0) + 1);
        for (String s : arr)
            if (map.get(s) == 1 && --k == 0) return s;
        return "";
    }

    public String kthDistinct2(String[] arr, int k) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (String s : arr) map.put(s, map.getOrDefault(s, 0) + 1);

        String ans = "";
        int count = 0;
        System.out.println(map);
        for (Map.Entry<String, Integer> mp : map.entrySet()) {
            if (mp.getValue() == 1) {
                count++;
                if (count == k) {
                    ans = mp.getKey();
                    break;
                }
            }
        }
        return ans;
    }

    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) map.put(s, map.getOrDefault(s, 0) + 1);

        String ans = "";
        int count = 0;
        for (String s : arr) {
            if (map.get(s) == 1) {
                count++;
            }
            if (count == k) {
                ans = s;
                break;
            }
        }
        return ans;
    }
}