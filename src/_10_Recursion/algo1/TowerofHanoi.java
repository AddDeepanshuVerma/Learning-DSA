package _10_Recursion.algo1;

public class TowerofHanoi {
    static long count = 0;
    public static void main(String[] args) {
        final String s = "source";
        final String h = "helper";
        final String d = "destsn";
        int num = 30;
        TOH(num, s, d, h);
    }


    private static void TOH(int num, String s, String d, String h) {
        if (num == 1) {
            System.out.printf("%s -> %s", s, d +"\n");
            return;
        }
        TOH(num - 1, s, h, d);
        System.out.printf("%s -> %s", s, d +"\n");
        TOH(num - 1, h, d, s);
    }
}
