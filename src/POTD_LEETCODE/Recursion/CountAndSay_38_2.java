package POTD_LEETCODE.Recursion;

class CountAndSay_38_2 {
    public static String countAndSay(int n) {
        return solve(n, "1");
    }

    private static String solve(int n, String s) {
        return (n == 1) ? s : solve(n - 1, convert(s));
    }

    private static String convert(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();

        char prev = s.charAt(0);
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == prev) {
                count++;
            } else {
                sb.append(count).append(prev);
                prev = arr[i];
                count = 1;
            }
        }
        sb.append(count).append(prev);

        return sb.toString();
    }

    public static void main(String[] args) {
        String ans3 = countAndSay(7);
        System.out.println(ans3);
    }
}