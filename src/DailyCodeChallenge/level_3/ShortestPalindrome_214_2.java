package DailyCodeChallenge.level_3;

class ShortestPalindrome_214_2 {
    public static void main(String[] args) {
        ShortestPalindrome_214_2 pbj = new ShortestPalindrome_214_2();
        System.out.println(pbj.shortestPalindrome2("abcd"));
    }

    public String shortestPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        int i = start, j = end;
        char[] arr = s.toCharArray();
        while (i < j) {
            if (arr[i++] == arr[j--]) {
            } else {
                i = start;
                j = --end;
            }
        }
        StringBuilder sb = new StringBuilder(s.substring(end + 1)).reverse();
        return sb.toString() + s;
    }

    public String shortestPalindrome2(String s) {
        final String t = new StringBuilder(s).reverse().toString();

        for (int i = 0; i < t.length(); ++i)
            if (s.startsWith(t.substring(i)))
                return t.substring(0, i) + s;

        return t + s;
    }


}