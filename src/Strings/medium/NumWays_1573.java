package Strings.medium;

class NumWays_1573 {
    public static void main(String[] args) {
        System.out.println(numWays("100100001"));
    }

    public static int numWays(String s) {
        long mod = 100_000_0007;
        long n = s.length();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) sum += Character.getNumericValue(s.charAt(i));

        if (sum % 3 != 0) return 0;
        if (sum == 0) return (int) ((n - 1) * (n - 2) / 2 % mod);

        int ones = sum / 3;
        int count = 0;
        long m = 0;
        long l = 0;
        for (int i = 0; i < n && count <= 2 * ones; i++) {
            if (count == ones && s.charAt(i) == '0') {
                m++;
            }else if(count == 2 * ones && s.charAt(i) == '0'){
                l++;
            }else count += s.charAt(i) - '0';
        }
        return (int) ((++m * ++l) % mod);
    }

    public int numWays2(String s) {
        long mod = 1000_000_007;
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) sum += Character.getNumericValue(s.charAt(i));

        if (sum % 3 != 0) return 0;
        if (sum == 0) return (int) ((n - 1) * (n - 2) / 2 % mod);

        int ones = sum / 3;

        int count = 0;
        long m = 0;
        for (int i = 0; i < n && count <= ones; i++) {
            if (count == ones && s.charAt(i) == '0') {
                m++;
            } else count += s.charAt(i) - '0';
        }

        count = 0;
        long l = 0;
        for (int i = n - 1; i >= 0 && count <= ones; i--) {
            if (count == ones && s.charAt(i) == '0') {
                l++;
            } else count += s.charAt(i) - '0';
        }
        System.out.println("m = " + m);
        System.out.println("l = " + l);
        return (int) ((++m * ++l) % mod);
    }
}