package _17_SlidingWindow.easy_medium.VariableSize;

class NumberOfSubstrings_1358 {
    public int numberOfSubstrings(String s) {
        //Return the number of substrings containing at least one occurrence of all these characters a, b and c.

        char[] arr = s.toCharArray();
        int[] map = new int[3]; // stores the count for {a, b, c}

        int count = 0, ans = 0, n = arr.length;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (++map[arr[j] - 'a'] == 1) count++;

            while (count == 3) {
                ans += (n - j);
                if (--map[arr[i] - 'a'] == 0) count--;
                i++;
            }
        }
        return ans;
    }
}