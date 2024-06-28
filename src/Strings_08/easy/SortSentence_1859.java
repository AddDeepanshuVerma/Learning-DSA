package Strings_08.easy;

import java.util.Arrays;
import java.util.stream.Collectors;

class SortSentence_1859 {
    public static void main(String[] args) {
        String st = "is2 sentence4 This1 a3";
        String[] str = st.split(" ");
        System.out.println(Arrays.toString(str));
        System.out.println(sortSentence2(st));
    }
    public static String sortSentence(String s) {
        String[] st = s.split(" ");
        Arrays.sort(st, (a, b) -> (int) a.charAt(a.length() - 1) - (int) b.charAt(b.length() - 1));
        return Arrays.stream(st).map(str -> str.substring(0, str.length() - 1))
                                .collect(Collectors.joining(" "));
    }

    public static String sortSentence2(String input) {
        String[] str = input.split(" ");
        Arrays.sort(str, (a, b) -> (int) a.charAt(a.length() - 1) - (int) b.charAt(b.length() - 1));
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s, 0, s.length() - 1);
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

}