package Strings.easy;

import java.util.Arrays;
import java.util.HashMap;

class FreqAlphabets_1309 {
    public static void main(String[] args) {
        System.out.println(freqAlphabets("1326#"));

    }

    public static String freqAlphabets(String s) {
        HashMap<String, Character> map = new HashMap<>();
        map.put("0", 'a');
        for (int i = 1; i < 27; i++) map.put(i + "", (char) ('a' + i - 1));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                Character ch = map.get(s.substring(i - 2, i));
                sb.append(ch);
            } else {
                Character ch = map.get(s.charAt(i) + "");
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}