package _08_Strings.medium;

import java.util.ArrayList;
import java.util.List;

class PrintVertically_1324 {
    public static void main(String[] args) {
        System.out.println(new PrintVertically_1324().printVertically("CONTEST IS COMING"));
    }

    public List<String> printVertically(String s) {
        String[] split = s.split(" ");
        int maxLength = 0;
        for (String string : split) {
            maxLength = Math.max(maxLength, string.length());
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            String str = getString(split, i).stripTrailing();
            list.add(str);
        }
        return list;
    }

    private String getString(String[] split, int i) {
        StringBuilder sb = new StringBuilder();
        for (String string : split) {
            sb.append(i < string.length() ? string.charAt(i) : " ");
        }
        return sb.toString();
    }
}