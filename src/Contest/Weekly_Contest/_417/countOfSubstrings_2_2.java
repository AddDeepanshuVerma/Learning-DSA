package Contest.Weekly_Contest._417;

import java.util.HashMap;

class countOfSubstrings_2_2 {
    public static void main(String[] args) {
        System.out.println(countOfSubstrings_2_2.countOfSubstrings("iqeaouqi", 2));
    }
    public static int countOfSubstrings(String word, int k) {
        char[] arr = word.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        int conso = 0;

        int ans = 0;
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            char ch = arr[j];
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                conso++;
            }


            while (i <= j && conso > k) {
                if (map.containsKey(arr[i])) {
                    map.put(arr[i], map.get(arr[i]) - 1);
                } else {
                    conso--;
                }
                i++;
            }

            if (isAllVowelPresent(map) && conso == k) {
                ans++;
            }
        }
        return ans;
    }

    private static boolean isAllVowelPresent(HashMap<Character, Integer> map) {
        for (Integer value : map.values()) {
            if (value == 0) {
                return false;
            }
        }
        return true;
    }


    private static boolean isValid(HashMap<Character, Integer> map) {
        for (Integer value : map.values()) {
            if (value < 1) {
                return false;
            }
        }
        return true;
    }

}