package DailyCodeChallenge.Level_1;

class IsUgly_263 {
    public static void main(String[] args) {
        int n = -2147483648;
        IsUgly_263 obj = new IsUgly_263();
        System.out.println(obj.isUgly(n));
    }

    public boolean isUgly(int n) {
        if (n <= 0) return false;
        for (int i = 2; i < 6; i++)
            while (n % i == 0) n = n / i;
        return n == 1;
    }


    public boolean isUgly2(int n) {
        if (n == 0) return false;
        return solve(n);
    }

    public boolean solve(int n) {
        if (n == 1) return true;

        if (n % 2 == 0) return isUgly(n / 2);
        if (n % 3 == 0) return isUgly(n / 3);
        if (n % 5 == 0) return isUgly(n / 5);
        else return false;
    }
}