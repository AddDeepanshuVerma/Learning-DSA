package POTD_LEETCODE.Level_1;

public class ScoreOfString {
    public static void main(String[] args) {
        System.out.println(scoreOfString("hello"));

    }

    public static int scoreOfString(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int temp = s.charAt(i) - s.charAt(i + 1);
            sum += Math.abs(temp);
        }
        return sum;
    }
}
