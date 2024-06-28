package Strings_08.medium;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Multiply_43 {
    public static void main(String[] args) {
//        System.out.println(multiplyByChar("10", '9'));
        String s1 = "99999999999";
        String s2 = "99999999999";
        System.out.println("out              result: " + multiply(s1, s2));
        System.out.println("using BigInteger result: "+ multiply_2(s1, s2));
        System.out.println("use only Biteger result: "+ multiply_3(s1, s2));
    }
    //using BigInteger only
    public static String multiply_3(String num1, String num2) {
        return new BigInteger(num1).multiply(new BigInteger(num2)) + "";
    }

    //using BigInteger & long
    public static String multiply_2(String num1, String num2) {
        return (num1.length() >= 10 || num2.length() >= 10
                ? new BigInteger(num1).multiply(new BigInteger(num2))
                : Long.parseLong(num1) * Long.parseLong(num2))
                .toString();
    }

    public static String multiply(String s1, String s2) {
        if (s1.equals("0") || s2.equals("0")) return "0";
        List<String> list = new ArrayList<>();
        StringBuilder zeros = new StringBuilder();
        for (int i = s2.length() - 1; i >= 0; i--) {
            String res = multiplyByChar(s1, s2.charAt(i));
            list.add(res + zeros);
            zeros.append("0");
        }
        System.out.println(list);
        try {
            System.out.println("Stream           result: " + list.stream().mapToLong(Long::parseLong).sum());
        } catch (Exception e) {
            System.out.println("Stream           result: 'out of range'");
        }
        return sumOfList(list);
    }

    private static String sumOfList(List<String> list) {
        StringBuilder sb = new StringBuilder();
        int maxLength = 0;
        for (String string : list) {
            maxLength = Math.max(string.length(), maxLength);
        }
        int carry = 0;
        for (int i = 0; i < maxLength; i++) {
            int temp = 0;
            for (int j = 0; j < list.size(); j++) {
                int length = list.get(j).length();
                int val = (length - i - 1) < 0 ? 0 : list.get(j).charAt(length - i - 1) - '0';
                temp += val;
            }
            temp += carry;
            sb.append(temp % 10);
            carry = temp > 9 ? temp / 10 : 0;
        }
        return carry == 0 ? sb.reverse().toString() : carry + sb.reverse().toString();
    }

    public static String multiplyByChar(String s1, char n) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            int temp = (n - '0') * (s1.charAt(i) - '0') + carry;
            ans.append(temp % 10);
            carry = temp > 9 ? temp / 10 : 0;
        }
        return carry == 0 ? ans.reverse().toString() : carry + ans.reverse().toString();
    }
}