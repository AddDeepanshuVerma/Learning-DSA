package DailyCodeChallenge.Level_1;

import java.util.Arrays;
import java.util.Stack;

class MinimumDeletions_1653 {
    public static void main(String[] args) {
        String str = "bbaaaaabb";
        System.out.println(minimumDeletions2(str));
    }

    public int minimumDeletions(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == 'b' && c == 'a') {
                stack.pop();
                count++;
            } else stack.add(c);
        }
        return count;
    }

    public static int minimumDeletions2(String s) {
        char[] arr = s.toCharArray();
        int[] leftB = new int[arr.length], rightA = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            leftB[i] = count;
            if (arr[i] == 'b') count++;
        }
        count = 0;
        for (int j = arr.length - 1; j >= 0; j--) {
            rightA[j] = count;
            if (arr[j] == 'a') count++;
        }
        System.out.println("arr    = " + Arrays.toString(arr));
        System.out.println("leftB  = " + Arrays.toString(leftB));
        System.out.println("rightA = " + Arrays.toString(rightA));
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < leftB.length; i++) {
            ans = Math.min(ans, leftB[i] + rightA[i]);
        }
        return ans;
    }

    public static int minimumDeletions3(String s) {
        char[] arr = s.toCharArray();
        int[] leftB = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            leftB[i] = count;
            if (arr[i] == 'b') count++;
        }
        count = 0;
        int ans = Integer.MAX_VALUE;
        for (int j = arr.length - 1; j >= 0; j--) {
            leftB[j] += count;
            if (arr[j] == 'a') count++;
            ans = Math.min(ans, leftB[j]);
        }
        return ans;
    }

    public static int minimumDeletions4(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int counta = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'a') counta++;
        }

        int count = Integer.MAX_VALUE;
        int countb = 0;

        for (char c : arr) {
            if (c == 'a') counta--;
            count = Math.min(count, countb + counta);
            if (c == 'b') countb++;
        }
        return count;
    }

}