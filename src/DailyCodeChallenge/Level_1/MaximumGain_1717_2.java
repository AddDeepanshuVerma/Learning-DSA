package DailyCodeChallenge.Level_1;

import java.util.Stack;

class MaximumGain_1717_2 {
    public static void main(String[] args) {
        String str = "aabbabkbbbfvybssbtaobaaaabataaadabbbmakgabbaoapbbbbobaabvqhbbzbbkapabaavbbeghacabamdpaaqbqabbjbababmbakbaabajabasaabbwabrbbaabbafubayaazbbbaababbaaha";
        System.out.println(maximumGain(str, 1, 5));
    }

    public static int maximumGain(String s, int x, int y) {
        if (x > y)
            return searchElements(s, "ab", x, "ba", y);
        else
            return searchElements(s, "ba", y, "ab", x);
    }

    private static int searchElements(String s, String s1, int x, String s2, int y) {
        int[] count = new int[2];
        String str = deleteString(s, s1, count, 0);
        deleteString(str, s2, count, 1);
        return (count[0] * x) + (count[1] * y);
    }

    private static String deleteString(String s, String s1, int[] count, int index) {
        Stack<Character> stack = new Stack<>();
        char e1 = s1.charAt(0);
        char e2 = s1.charAt(1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == e2 && !stack.isEmpty() && stack.peek() == e1) {
                stack.pop();
                count[index]++;
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}