package POTD_LEETCODE.level_3;

import java.util.HashMap;

class FindTheLongestSubstring_1371 {
    public static void main(String[] args) {
        FindTheLongestSubstring_1371 obj = new FindTheLongestSubstring_1371();
        System.out.println(obj.findTheLongestSubstring3("eleetminicoworoep"));
    }

    //    443ms, Beats 5.34%
    public int findTheLongestSubstring(String s) {
        // a e i o u
        int[] vowels = new int[5];
        HashMap<String, Integer> map = new HashMap<>();
        map.put("00000", -1);

        int result = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            switch (c) {
                case 'a' -> vowels[0] = (vowels[0] + 1) % 2;
                case 'e' -> vowels[1] = (vowels[1] + 1) % 2;
                case 'i' -> vowels[2] = (vowels[2] + 1) % 2;
                case 'o' -> vowels[3] = (vowels[3] + 1) % 2;
                case 'u' -> vowels[4] = (vowels[4] + 1) % 2;
            }
            String temp = "";
            for (int vowel : vowels) temp += vowel;
            if (map.containsKey(temp)) {
                result = Math.max(result, i - map.get(temp));
            } else {
                map.put(temp, i);
            }
        }
        return result;
    }

    //    instead of % as we need to store even/odd occurance of alphabet, we can use XOR if even occurance XOR will provide 0 else 1
    public int findTheLongestSubstring2(String s) {
//        a e i o u
        int[] vowels = new int[5];
        HashMap<String, Integer> map = new HashMap<>();
        map.put("00000", -1);

        int result = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            switch (c) {
                case 'a' -> vowels[0] = vowels[0] ^ 1;
                case 'e' -> vowels[1] = vowels[1] ^ 1;
                case 'i' -> vowels[2] = vowels[2] ^ 1;
                case 'o' -> vowels[3] = vowels[3] ^ 1;
                case 'u' -> vowels[4] = vowels[4] ^ 1;
            }
            String temp = "";
            for (int vowel : vowels) temp += vowel;
            if (map.containsKey(temp)) {
                result = Math.max(result, i - map.get(temp));
            } else {
                map.put(temp, i);
            }
        }
        return result;
    }

    //    instead of maintaining a String to store unique patter, we can use bit masking
    public int findTheLongestSubstring3(String s) {
        int mask = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(mask, -1);

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a' -> mask ^= 1;
                case 'e' -> mask ^= 1 << 1;
                case 'i' -> mask ^= 1 << 2;
                case 'o' -> mask ^= 1 << 3;
                case 'u' -> mask ^= 1 << 4;
            }
            map.putIfAbsent(mask, i);
            ans = Math.max(ans, i - map.get(mask));
        }
        return ans;
    }
}