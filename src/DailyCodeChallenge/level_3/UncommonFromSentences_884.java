package DailyCodeChallenge.level_3;

import java.util.*;

class UncommonFromSentences_884 {
    public static void main(String[] args) {

        List<Integer> result2 = new ArrayList<>();
        String[] array = (String[]) result2.<String>toArray();


        UncommonFromSentences_884 obj = new UncommonFromSentences_884();
        String[] strings = obj.uncommonFromSentences("this apple is sweet", "this apple is sour");
        System.out.println("strings = " + Arrays.toString(strings));
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        s1 = s1 + " " + s2;
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : s1.split(" ")) {
            map.merge(s, 1, Integer::sum);
        }
        System.out.println("map = " + map);

        int count = (int) map.values().stream().filter(n -> n == 1).count();
        String[] ans = new String[count];
        int i = 0;
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            if (item.getValue() == 1) {
                ans[i++] = item.getKey();
            }
        }
        return ans;
    }

    public String[] uncommonFromSentences2(String s1, String s2) {
        s1 = s1 + " " + s2;
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : s1.split(" ")) {
            map.merge(s, 1, Integer::sum);
        }

        int count = 0;
        for (Integer value : map.values()) {
            if (value == 1) count++;
        }

        String[] ans = new String[count];
        int i = 0;
        for (String s : map.keySet()) {
            if (map.get(s) == 1) ans[i++] = s;
        }
        return ans;
    }

    public String[] uncommonFromSentences3(String s1, String s2) {
        s1 = s1 + " " + s2;
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : s1.split(" ")) {
            map.merge(s, 1, Integer::sum);
        }

        List<String> result = new ArrayList<>();
        for (String word : map.keySet()) {
            if (map.get(word) == 1) result.add(word);
        }
        return result.<String>toArray(new String[0]);
    }

}