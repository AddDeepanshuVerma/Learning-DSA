package POTD_LEETCODE.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CountOfSubstrings_3306 {

    public static void main(String[] args) {
        System.out.println(countOfSubstrings("ieaouqqieaouqq", 1));
    }

    //Traversing HashMap to count all vowels present
    //using BinarySearch on all consonants to get next consonant index
    public static long countOfSubstrings(String word, int k) {
        HashMap<Character, Integer> vowels = new HashMap<>(Map.of('a', 0, 'e', 0, 'i', 0, 'o', 0, 'u', 0));

        // need to store the index of
        char[] arr = word.toCharArray();
        int n = arr.length;

        List<Integer> consonantIndexes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vowels.containsKey((arr[i]))) {
                consonantIndexes.add(i);
            }
        }

        int i = 0, consonantCount = 0;
        long ans = 0;
        for (int j = 0; j < n; j++) {
            if (vowels.containsKey(arr[j])) vowels.merge(arr[j], 1, Integer::sum);
            else consonantCount++;

            while (consonantCount > k) {
                if (vowels.containsKey(arr[i])) vowels.merge(arr[i], -1, Integer::sum);
                else consonantCount--;
                i++;
            }

            while (consonantCount == k && allVowelPresent(vowels)) {
                int next = getNextConsonantIndex(j, n, consonantIndexes); // answer should be greater than j or (n)
                ans += (next - j);

                if (vowels.containsKey(arr[i])) vowels.merge(arr[i], -1, Integer::sum);
                else consonantCount--;
                i++;
            }
        }
        return ans;
    }

    private static int getNextConsonantIndex(int val, int n, List<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;
        int index = n; // default value

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

    private static boolean allVowelPresent(HashMap<Character, Integer> vowels) {
        for (Integer value : vowels.values()) {
            if (value < 1) return false;
        }
        return true;
    }

}