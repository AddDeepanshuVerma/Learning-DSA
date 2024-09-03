package _13_Maths.easy;

import jdk.jfr.Description;

import java.util.Arrays;

@Description("Using Recursion only")
class ClimbStairs_70 {

    public static void main(String[] args) {
        ClimbStairs_70 obj = new ClimbStairs_70();
        System.out.println(obj.climbStairs_2(5));
        System.out.println("loopRan = " + obj.loopRan);
    }

    int loopRan = 0;

    public int climbStairs_2(int n) {
        int count = 0;
        return solve_2(0, n, count);
    }

    private int solve_2(int target, int n, int count) {
        loopRan++;
        if (target == n) return count + 1;
        if (target > n) return 0;

        return solve_2(target + 1, n, count) + solve_2(target + 2, n, count);
    }


    int count = 0;

    public int climbStairs(int n) {
        solve(0, n);
        return count;
    }

    private void solve(int target, int n) {
        if (target == n) {
            count++;
            return;
        } else if (target > n) {
            return;
        }
        solve(target + 1, n);
        solve(target + 2, n);
    }
}

















