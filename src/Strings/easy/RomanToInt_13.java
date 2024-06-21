package Strings.easy;

import java.util.HashMap;

class RomanToInt_13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int sum = romanToInteger(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            int temp = romanToInteger(s.charAt(i));
            if (s.charAt(i) != s.charAt(i+1) && temp < sum) {
                sum -= temp;
            } else {
                sum += temp;
            }
        }
        return sum;
    }

    public static int romanToInteger(char s) {
        int res = 1;
        switch (s) {
            case 'V' -> res = 5;
            case 'X' -> res = 10;
            case 'L' -> res = 50;
            case 'C' -> res = 100;
            case 'D' -> res = 500;
            case 'M' -> res = 1000;
        }
        return res;
    }

    public static int romanToInteger2(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        return map.get(s);
    }
}