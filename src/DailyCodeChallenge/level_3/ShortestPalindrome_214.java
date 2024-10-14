package DailyCodeChallenge.level_3;

class ShortestPalindrome_214 {
    public static void main(String[] args) {
        ShortestPalindrome_214 pbj = new ShortestPalindrome_214();
        System.out.println(pbj.shortestPalindrome("abcd"));
    }
    public String shortestPalindrome(String s) {
        int n = s.length();
        int removeIndex = 0;
        String str = s;
        while (true) {
            str = str.substring(0, n - removeIndex);
            if (isPalindrome(str.toCharArray())) {
                break;
            } else {
                removeIndex++;
            }
        }
        StringBuilder sb = new StringBuilder(s.substring(n - removeIndex));
        sb.reverse();
        return sb.toString() + s;
    }

    private boolean isPalindrome(char[] charArray) {
        int start = 0;
        int end = charArray.length - 1;
        while (start < end) {
            if (charArray[start++] != charArray[end--]) {
                return false;
            }
        }
        return true;
    }
}