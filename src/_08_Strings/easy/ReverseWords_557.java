package _08_Strings.easy;

class ReverseWords_557 {
    public static void main(String[] args) {
        String s = "Mr Ding";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            split[i] = reversed(split[i]);
        }
        return String.join(" ", split);
    }

    private static String reversed(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}