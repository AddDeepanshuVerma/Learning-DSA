package DailyCodeChallenge.level_3;

import java.util.Arrays;

class CountConsistentStrings_1684 {
    public static void main(String[] args) {
        String[] words = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        CountConsistentStrings_1684 obj = new CountConsistentStrings_1684();
        System.out.println(obj.countConsistentStrings2("cadz", words));
    }

    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for (String word : words) {
            int temp = 0;
            for (char c : word.toCharArray()) {
                if (allowed.contains(c + "")) {
                    temp++;
                }
            }
            if (temp == word.length()) {
                count++;
            }
        }
        return count;
    }

    public int countConsistentStrings2(String allowed, String[] words) {
        int count = 0;
        int[] arr = new int[26];
        for (char c : allowed.toCharArray()) arr[c - 'a']++;

        for (String word : words) {
            int temp = 0;
            for (char c : word.toCharArray()) {
                if (arr[c - 'a'] > 0) temp++;
            }
            if (temp == word.length()) {
                count++;
            }
        }
        return count;
    }

    public int countConsistentStrings3(String allowed, String[] words) {
        int count = 0;
        boolean[] arr = new boolean[26];
        for (char c : allowed.toCharArray()) arr[c - 'a'] = true;
        System.out.println("arr = " + Arrays.toString(arr));

        for (String word : words) {
            if (isValid(arr, word)) count++;
        }
        return count;
    }

    private boolean isValid(boolean[] arr, String word) {
        for (char c : word.toCharArray())
            if (!arr[c - 'a']) return false;
        return true;
    }

    //using bit Manipulation
    public int countConsistentStrings4(String allowed, String[] words) {
        int freq = 0;
        for (char c : allowed.toCharArray()) {
            freq |= 1 << (c - 'a');
        }
        int count = words.length;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if ((freq & 1 << (c - 'a')) == 0) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}