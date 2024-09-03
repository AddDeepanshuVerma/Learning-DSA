package DailyCodeChallenge.Level_1;

import java.util.Arrays;
import java.util.List;


class ReplaceWords_648 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","c");
        String st = "aadsfasf absbs bbab cadsfafs";
        String s = replaceWords(list, st);
        System.out.println(s);
    }
    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] st = sentence.split(" ");
        System.out.println(Arrays.toString(st));
        for (int j = 0; j < dictionary.size(); j++) {
            String s = dictionary.get(j);
            for (int i = 0; i < st.length; i++) {
                String matchedString = compare(s, st[i], dictionary);
                if (!matchedString.isEmpty()) {
                    st[i] = matchedString;
                }
            }
        }
        String join = String.join(" ", st);
        return join;
    }

    private static String compare(String s1, String s2,List<String> dictionary) {
        if (s1.length() > s2.length()) {
            return "";
        }
        if (s2.contains(s1) && s2.startsWith(s1.charAt(0)+"")) {
            return s1;
        }
        if(s2.contains(s1)){
            int index = s2.indexOf(s1.charAt(0) + "");
            //check if it is the lowest index; if yes, return true else false
            String updatedString = findIndex(s2, dictionary, index, s1);
            if (!updatedString.isEmpty()) {
                return updatedString;
            } else {
                return "";
            }

        }
        return "";
    }

    private static String findIndex(String st, List<String> dictionary, int cindex, String cString) {
        int lowestIndex = 0;
        String stringAtLowestIndex = "";
        for (int k = 0; k < st.length(); k++) {
            for (int i = 0; i < dictionary.size(); i++) {
                String str = dictionary.get(i);
                if(str.contains(st.charAt(k)+"")){
                    int index = str.indexOf(st);
                    if (index < lowestIndex) {
                        lowestIndex = index;
                        stringAtLowestIndex = str;
                    }
                }
            }
        }

        return stringAtLowestIndex.isEmpty() ? cString : stringAtLowestIndex;
        /*if (cString.equals(stringAtLowestIndex)) {
            return true;
        }else {
            return false;
        }*/
    }
}















