package _12_BitManipulation_NumSYS.easy;

import com.sun.source.doctree.SummaryTree;

class AddBinary_67 {
    public static void main(String[] args) {
        System.out.println(addBinary2("100", "110010"));
    }

    public static String addBinary1(String a, String b) {
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry = 0, base = 2;
        int n1, n2;
        int p1 = s1.length - 1;
        int p2 = s2.length - 1;
        while (p1 >= 0 || p2 >= 0) {
            n1 = p1 >= 0 ? s1[p1] - '0' : 0;
            n2 = p2 >= 0 ? s2[p2] - '0' : 0;
            int sum = n1 + n2 + carry;
            sb.append(sum % base);
            carry = sum / base;
            p1--;
            p2--;
        }
        return carry == 1 ? sb.append('1')
                              .reverse()
                              .toString() : sb.reverse()
                                              .toString();
    }

    public static String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, base = 2;
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        while (p1 >= 0 || p2 >= 0 || carry == 1) {
            int n1 = p1 >= 0 ? a.charAt(p1--) - '0' : 0;
            int n2 = p2 >= 0 ? b.charAt(p2--) - '0' : 0;
            int sum = n1 + n2 + carry;
            sb.append(sum % base);
            carry = sum / base;
        }
        return sb.reverse().toString();
    }

    private static String addBinary3(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) carry += a.charAt(i--) - '0';
            if (j >= 0) carry += b.charAt(j--) - '0';
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }

    private static String addBinary4(String s1, String s2) {
        int num1 = Integer.parseInt(s1, 2);
        int num2 = Integer.parseInt(s2, 2);
        return Integer.toBinaryString(num1 + num2);
    }

}