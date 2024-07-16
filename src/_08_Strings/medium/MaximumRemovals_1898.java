package _08_Strings.medium;

class MaximumRemovals_1898 {
    public static void main(String[] args) {
        String s = "abcbddddd", p = "abcd";
        int[] removable = {3,2,1,4,5,6};
        System.out.println(maximumRemovals(s, p, removable));
    }

    public static int maximumRemovals(String s, String p, int[] removable) {
        int start = 0;
        int end = removable.length;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (isSequence(s, p, removable, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isSequence(String s, String p, int[] arr, int mid) {
        char[] s1 = s.toCharArray();
        char[] s2 = p.toCharArray();
        for (int i = 0; i < mid; i++) {
            s1[arr[i]] = Character.MIN_VALUE;
        }
        int i = 0, j = 0;
        for (i = 0; i < s1.length && j < s2.length; i++) {
            if (s1[i] == s2[j]) {
                j++;
            }
        }
        return j == s2.length;
    }
}