package DailyCodeChallenge;

import java.sql.Array;
import java.util.*;

public class CommonChars_1002 {
    public static void main(String[] args) {

        String[] arr= {"bella","label","roller"};
        System.out.println(commonChars(arr));
    }
    public static List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();
        int[] base = new int[26];
        String st = words[0];
        for (int i = 0; i < st.length(); i++) {
            base[st.charAt(i) - 'a'] += 1;
        }
//        System.out.println(Arrays.toString(base));
        for (int i = 1; i < words.length; i++) {
            computeArray(base, words[i]);
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < base[i]; j++) {
                char c = (char) (i + 'a');
                list.add(c + "");
            }
        }
        return list;
    }

    private static void computeArray(int[] base, String st) {
        int[] arr = new int[26];
        for (int i = 0; i < st.length(); i++) {
            arr[st.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            base[i] = Math.min(base[i] , arr[i]);
        }
    }


    public static List<String> commonChars4(String[] words) {
        List<List<String>> lst = new ArrayList<>();
        for (String word : words) {
            List<String> list = new ArrayList<>();
            for (char c : word.toCharArray()) {
                list.add(c+"");
            }
            lst.add(list);
        }
        if(words.length == 0) return null;
        if(words.length == 1) return lst.get(0);

        List<String> strings = lst.get(0);
        for (int i = 1; i < lst.size(); i++) {

        }
        return null;
    }


    public static List<String> commonChars3(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        System.out.println(map);

        List<String> list = map.entrySet().stream()
                .filter(entry -> entry.getValue() >= words.length)
                .map(Map.Entry::getKey)
                .map(String::valueOf)
                .toList();
        return list;
    }

    public static List<String> commonChars2(String[] words) {
        Set<String> set = new HashSet<>();
        for (String st : words) {
            for (char c : st.toCharArray()) {
                set.add(c+"");
            }
        }
        return set.stream().toList();
    }
}
