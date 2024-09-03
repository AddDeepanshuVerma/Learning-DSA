package DailyCodeChallenge.Level_1;

public class AppendCharacters_2486 {
    public static void main(String[] args) {
        System.out.println(appendCharacters2("coaching", "coding"));
    }

    public static int appendCharacters(String s, String t) {
        int count = t.length();
        for (int i = 0, j = 0; i < s.length() && j < t.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) {
                count--;
                j++;
            }
        }
        return count;
    }

    public static int appendCharacters2(String s, String t) {
        int count  = t.length();
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            int found = s.indexOf(t.charAt(i), index);
            if (found != -1) {
                count--;
                index = found+1;
            } else if (found == -1) {
                return count;
            }
        }
        return count;
    }
}
