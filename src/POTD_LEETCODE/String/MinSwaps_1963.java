package POTD_LEETCODE.String;

class MinSwaps_1963 {
    public int minSwaps(String s) {
        int open = 0, close = 0;
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '[' -> open++;
                case ']' -> {
                    if (open > 0) {
                        open--;
                    } else {
                        close++;
                    }
                }
            }
        }
        return close;
    }
}