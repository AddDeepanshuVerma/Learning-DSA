package _08_Strings.medium;

class NumSub_1513 {
    public static void main(String[] args) {
        System.out.println(new NumSub_1513().numSub5("111111"));

    }

    // someone else's solution
    public int numSub5(String s) {
        int i = 0, k, n = s.length();
        long res = 0;
        while (i < n) {
            k = 0;
            while (i < n && s.charAt(i) == '1') {
                i++;
                k++;
            }
            while (k > 0) {
                res += k;
                k--;
            }
            i++;
        }
        return (int) (res % (Math.pow(10, 9) + 7));
    }

    private int numSub4(String s) {
        long res = 0;
        long n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                n++;
            }
            if (s.charAt(i) == '0' || i == s.length() - 1) {
                res += n * (n + 1) >>> 1;
                n = 0;
            }
        }
        return (int) (res % 1_000_000_007);
    }

    public int numSub3(String s) {
        String[] str = s.split("0", 0);
        long res = 0;
        for (String string : str) {
            long n = string.length();
            long temp = n * (n + 1) >>> 1;
            res += temp;
        }
        return (int) (res % 1_000_000_007);
    }
}