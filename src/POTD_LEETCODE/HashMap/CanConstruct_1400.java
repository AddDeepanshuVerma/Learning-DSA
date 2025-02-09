package POTD_LEETCODE.HashMap;

class CanConstruct_1400 {
    public static void main(String[] args) {
        String s = "aabbcc";
        System.out.println(canConstruct(s, 1));
    }

    public static boolean canConstruct(String s, int k) {
        int maximumAllowed = s.length();
        if (k == maximumAllowed) return true;
        if (k > maximumAllowed) return false;

        // check odd count
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        int minimumAllowed = 0;
        for (int i = 0; i < 26; i++) {
            minimumAllowed += arr[i] & 1;
        }
        if (k < minimumAllowed) return false;

        return true;
    }
}