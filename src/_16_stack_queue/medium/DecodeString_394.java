package _16_stack_queue.medium;

import jdk.jfr.Description;

class DecodeString_394 {
    public static void main(String[] args) {
        DecodeString_394 o = new DecodeString_394();
//        System.out.println(o.decodeString("3[a]2[bc]"));
        System.out.println(o.decodeString("3[abc]"));
//        System.out.println(o.decodeString("abc"));
    }


    public String decodeString(String s) {
        int index = 0;
        return solve(s.toCharArray(), index);
    }

    private String solve2(char[] arr, int index) {
        String res = "";
        while (index < arr.length) {
            if (arr[index] == ']') return res;

            if (!Character.isDigit(arr[index])) {
                res += arr[index++];
            } else {
                // count the total digit/times here and make a number
                int digit = 0;
                while (Character.isDigit(arr[index])) {
                    digit = digit * 10 + (arr[index] - '0');
                    index++;
                }
                // now we have digit/times now index'th element must be '[' hence index++
                index++;
                // now we need to get inner String
                String innerString = solve(arr, index);
                // now after inner string, index'th element must be ']' hence index++
                index++;

                // now repeat our innerString digit times in res
                while (digit > 0) {
                    res += innerString;
                    digit--;
                }
            }
        }
        return res;
    }

    @Description("Would not work")
    private String solve(char[] arr, int index) {
        StringBuilder res = new StringBuilder();
        while (index < arr.length && arr[index] != ']') {
            if (!Character.isDigit(arr[index])) {
                res.append(arr[index++]);
            } else {
                int digit = 0;
                while (Character.isDigit(arr[index]))
                    digit = digit * 10 + (arr[index++] - '0');
                String innerString = solve(arr, ++index);
                index++;
                while (digit-- > 0) res.append(innerString);
            }
        }
        return res.toString();
    }
}