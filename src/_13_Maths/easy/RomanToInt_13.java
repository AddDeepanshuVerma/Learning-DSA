package _13_Maths.easy;

import javax.imageio.IIOImage;
import java.util.HashMap;

class RomanToInt_13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] arr = s.toCharArray();
        int sum = 0;
        int previousValues = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            Integer n = map.get(arr[i]);
            if (previousValues <= n) {
                sum += n;
            }else sum -= n;
            previousValues = n;
        }
        return sum;
    }
}