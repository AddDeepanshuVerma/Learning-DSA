package Interesting;

public class Demo {

    public static void main(String[] args) {
        String str = "//\\";
        System.out.println("str2 length= " + str.length());
        char[] arr = str.toCharArray();
        for (char c : arr) {
            System.out.println(c);
        }
    }

    public static void main(String args) {
        NumberToWords_273 obj = new NumberToWords_273();
        for (int i = 1123456789; i - 1 <= 1123456889; i++) {
            System.out.println(i + " : " + obj.numberToWords(i));
        }
    }
}
