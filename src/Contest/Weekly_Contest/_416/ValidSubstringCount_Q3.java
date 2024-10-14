package Contest.Weekly_Contest._416;

import java.util.HashMap;

class ValidSubstringCount_Q3 {
    public static void main(String[] args) {
        ValidSubstringCount_Q3 obj = new ValidSubstringCount_Q3();
        System.out.println(obj.validSubstringCount("dddddededddeeeddd", "eee"));
    }

    public long validSubstringCount(String word1, String word2) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < word2.length(); i++) {
            mp.put(word2.charAt(i), mp.getOrDefault(word2.charAt(i), 0) + 1);
        }

        int i = 0, j = 0;
        long ans = 0;

        while (j < word1.length()) {
            if (mp.containsKey(word1.charAt(j))) {
                mp.put(word1.charAt(j), mp.get(word1.charAt(j)) - 1);
            }

            while (i <= j && isValid(mp)) {
//                System.out.println("j = " + j);
                ans += (word1.length() - j);

                if (mp.containsKey(word1.charAt(i))) {
                    mp.put(word1.charAt(i), mp.get(word1.charAt(i)) + 1);
                }
                i++;
            }
            j++;
        }

        return ans;
    }

    private boolean isValid(HashMap<Character, Integer> mp) {
        for (char key : mp.keySet()) {
            if (mp.get(key) > 0) return false;
        }
        return true;
    }
}