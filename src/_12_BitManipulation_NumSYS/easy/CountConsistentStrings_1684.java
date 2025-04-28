package _12_BitManipulation_NumSYS.easy;

import java.util.HashSet;
import java.util.Set;

class CountConsistentStrings_1684 {
    public static void main(String[] args) {
        String[] words = {"ad","bd","aaab","baa","badab"};
        System.out.println(countConsistentStrings2("ab", words));
    }

    private static int countConsistentStrings2(String allowed, String[] words) {
        char[] arr = allowed.toCharArray();
        int allowedBit = 0;
        for (char c : arr) {
            allowedBit = allowedBit | (1 << (c - 'a'));
        }
        int count = words.length;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if ((allowedBit & (1 << (c - 'a'))) == 0) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        HashSet<String> set = new HashSet<>(Set.of(allowed.split("")));
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (isValid(words[i], set)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isValid(String word, HashSet<String> set) {
        for (int i = 0; i < word.length(); i++) {
            if (!set.contains(word.charAt(i)+"")) {
                return false;
            }
        }
        return true;
    }
}