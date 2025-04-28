package _08_Strings.easy;

class LengthOfLastWord_58 {
    public static void main(String[] args) {
        String str = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(str));
    }

    public static int lengthOfLastWord(String s) {
        String trim = s.trim();
        int index = trim.lastIndexOf(" ");
        return trim.length() - 1 - index;
    }
    public static int lengthOfLastWord2(String s) {
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }

}