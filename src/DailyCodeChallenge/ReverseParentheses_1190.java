package DailyCodeChallenge;

import java.util.Stack;

class ReverseParentheses_1190 {
    public static void main(String[] args) {
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }

    public String reverseParentheses_N(String s) {
        int n = s.length();
        Stack<Integer> openBracket = new Stack<>();
        int[] door = new int[n];

        // First pass: Pair up parentheses
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                openBracket.push(i);
            } else if (s.charAt(i) == ')') {
                int j = openBracket.pop();
                door[i] = j;
                door[j] = i;
            }
        }

        // Second pass: Build the result string
        StringBuilder result = new StringBuilder();
        int direction = 1; // Left to Right
        for (int i = 0; i < n; i += direction) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = door[i];
                direction = -direction;
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public static String reverseParentheses(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> len = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            if (ch == '(')
                len.push(sb.length());
            else if (ch == ')')
                sb = reverseInRange2(sb, len.pop());
            else
                sb.append(ch);
        }
        return sb.toString();
    }


    private static StringBuilder reverseInRange(StringBuilder sb, Integer start) {
        char[] arr = sb.toString().toCharArray();
        int end = sb.length() - 1;
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new StringBuilder(String.valueOf(arr));
    }

    private static StringBuilder reverseInRange2(StringBuilder sb, Integer start) {
        String str = sb.substring(0, start);
        StringBuilder temp = new StringBuilder(sb.substring(start));
        return new StringBuilder(str + temp.reverse());
    }

    public String reverseParentheses2(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (final char c : s.toCharArray())
            if (c == '(') {
                stack.push(sb.length());
            } else if (c == ')') {

                StringBuilder reversed = new StringBuilder();
                for (int i = sb.length() - stack.pop(); i > 0; --i) {
                    reversed.append(sb.charAt(sb.length() - 1));
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(reversed);

            } else {
                sb.append(c);
            }

        return sb.toString();
    }
}