package POTD_LEETCODE.sliding_window;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class CountOfSubstrings_3306_2 {
    //using count variable to maintain how many diff vowels so far
    //using TreeSet's function map.higherKey(num) to get the next index
    public static long countOfSubstrings(String word, int k) {
        HashMap<Character, Integer> vowels = new HashMap<>(Map.of('a', 0, 'e', 0, 'i', 0, 'o', 0, 'u', 0));

        // need to store the index of
        char[] arr = word.toCharArray();
        int n = arr.length;

        TreeSet<Integer> cnsnts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (!vowels.containsKey((arr[i]))) {
                cnsnts.add(i);
            }
        }
        cnsnts.add(n); // to always get a valid answer

        int i = 0, cCount = 0, vCount = 0;
        long ans = 0;
        for (int j = 0; j < n; j++) {
            if (vowels.containsKey(arr[j])) {
                int val = vowels.merge(arr[j], 1, Integer::sum);
                if (val == 1) { // a new vowel was achieved
                    vCount++;
                }
            } else cCount++;

            while (cCount > k) {
                if (vowels.containsKey(arr[i])) {
                    int val = vowels.merge(arr[i], -1, Integer::sum);
                    if (val == 0) { // a vowel got dissolved
                        vCount--;
                    }
                } else cCount--;
                i++;
            }

            while (cCount == k && vCount == 5) {
                int nextCnsnt = cnsnts.higher(j);// answer should be greater than j or (n)
                ans += (nextCnsnt - j);

                if (vowels.containsKey(arr[i])) {
                    int val = vowels.merge(arr[i], -1, Integer::sum);
                    if (val == 0) { // a vowel got dissolved
                        vCount--;
                    }
                } else cCount--;
                i++;
            }
        }
        return ans;
    }

}