package _13_Maths.Medium;

import jdk.jfr.Description;

class IntegerBreak_343 {
    public static void main(String[] args) {
        IntegerBreak_343 obj = new IntegerBreak_343();
        System.out.println(obj.integerBreak(10));

    }

    public int integerBreak(int n) {
        return solve(n);
    }

    @Description("Recursion")
    private int solve(int n) {
        int max = 0;
        for (int i = 1; i < n; i++) {
            int curr = i * Math.max(n - i, solve(n - i));
            max = Math.max(max, curr);
        }
        return max;
    }

}