package POTD_LEETCODE.sliding_window;

import java.util.*;

class CountOfSubstrings_3306_1 {
    //using count variable to maintain how many diff vowels so far
    //using BinarySearch on all consonants to get next consonant index
    public static long countOfSubstrings(String word, int k) {
        HashMap<Character, Integer> vowels = new HashMap<>(Map.of('a', 0, 'e', 0, 'i', 0, 'o', 0, 'u', 0));

        // need to store the index of
        char[] arr = word.toCharArray();
        int n = arr.length;

        List<Integer> cnsnts = new ArrayList<>();
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
                int nextCnsnt = getNextConsonantIndex(j, n, cnsnts);
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

    private static int getNextConsonantIndex(int val, int n, List<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;
        int index = -1; // default value

        while (start <= end) {
            int mid = (start + end) >> 1;
            if (arr.get(mid) > val) {
                index = arr.get(mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return index;
    }

}