package Contest.Weekly_Contest._416;

import java.util.HashMap;

class ValidSubstringCount_Q4 {
    public static void main(String[] args) {
        ValidSubstringCount_Q4 obj = new ValidSubstringCount_Q4();
        System.out.println(obj.validSubstringCount("dddddededddeeeddd", "eee"));
    }

    public long validSubstringCount(String word1, String word2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : word2.toCharArray()) map.merge(ch, 1, Integer::sum);

        char[] arr = word1.toCharArray();
        int i = 0;
        long count = map.size(), ans = 0;

        for (int j = 0; j < arr.length; j++) {
            if (map.containsKey(arr[j])) {
                map.put(arr[j], map.get(arr[j]) - 1);
                if (map.get(arr[j]) == 0) count--;
            }

            while (count == 0) {
                ans += (arr.length - j);
                if (map.containsKey(arr[i])) {
                    map.put(arr[i], map.get(arr[i]) + 1);
                    if (map.get(arr[i]) == 1) count++;
                }
                i++;
            }
        }
        return ans;
    }
}