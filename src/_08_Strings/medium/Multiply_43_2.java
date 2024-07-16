package _08_Strings.medium;

import java.util.ArrayList;
import java.util.List;

class Multiply_43_2 {
    public static void main(String[] args) {
//        System.out.println(multiplyByChar("10", '9'));
        String s1 = "9999";
        String s2 = "9999";
        System.out.println("out    result: "+multiply(s1, s2));
    }

    public static String multiply(String s1, String s2) {
        if (s2.length() > s1.length()) {
            return multiply(s2, s1);
        }
        List<String> list = new ArrayList<>();
        StringBuilder zeros = new StringBuilder();
        for (int i = s2.length() - 1; i >= 0; i--) {
            String res = multiplyByChar(s1, s2.charAt(i));
            list.add(res + zeros);
            zeros.append("0");
        }
        // get sum of the list and store in String
        String result = sumOfList(list);
        System.out.println(list);
        System.out.println("Stream result: "+list.stream().mapToLong(Integer::parseInt).sum());
        return result;
    }

    private static String sumOfList(List<String> list) {
        StringBuilder sb = new StringBuilder();
        int maxLength = 0;
        for (String string : list) {
            maxLength = Math.max(string.length(), maxLength);
        }

        int temp = 0, carry = 0;
        for (int i = 0; i < maxLength; i++) {
            temp = 0;
            for (int j = 0; j < list.size(); j++) {
                int length = list.get(j).length();
                int val = (length - i - 1) < 0 ? 0 : list.get(j).charAt(length - i - 1) - '0';
                temp += val;
            }
            temp += carry;
            sb.append(temp % 10);
            carry = temp > 9 ? temp / 10 : 0;
        }
        return carry == 0
                ? sb.reverse().toString()
                : carry + sb.reverse().toString();
    }

    public static String multiplyByChar(String s1, char n) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            int temp = Character.getNumericValue(n) * Character.getNumericValue(s1.charAt(i)) + carry;
            ans.append(temp % 10);
            carry = temp > 9 ? temp / 10 : 0;
        }
        return carry == 0
                ? ans.reverse().toString()
                : carry + ans.reverse().toString();
    }

    public static String multiplyByDigit(String s1, String n) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            int temp = Integer.parseInt(n) * Character.getNumericValue(s1.charAt(i)) + carry;
            ans.append(temp % 10);
            carry = temp > 9 ? temp / 10 : 0;
        }
        return carry == 0
                ? ans.reverse().toString()
                : carry + ans.reverse().toString();
    }
}