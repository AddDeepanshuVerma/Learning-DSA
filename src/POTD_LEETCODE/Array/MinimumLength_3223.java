package POTD_LEETCODE.Array;

class MinimumLength_3223 {
    public int minimumLength(String s) {
        int[] arr = new int[26];
        int count = 0;

        for (char ch : s.toCharArray()) {
            int i = ch - 'a';
            arr[i]++;
            if (arr[i] == 3) {
                arr[i] = 1;
                count++;
            }
        }

        return s.length() - (count << 1);
    }
}
