package _13_Maths.easy;

import jdk.jfr.Description;

import java.util.Arrays;
import java.util.stream.IntStream;

@Description("Recursion + Memoization")
class ClimbStairs_70_2 {
    public static void main(String[] args) {
        int n = 45;

        //Using only recursion + memoization
        ClimbStairs_70_2 obj = new ClimbStairs_70_2();
        System.out.print(obj.climbStairs_M(n) + " , ");
        System.out.println("loopRan = " + obj.loopRan);
/*

        IntStream.range(0, obj.dp.length)
                 .mapToObj(index -> index + ":" + obj.dp[index])
                 .filter(n -> Integer.parseInt(n.substring(n.indexOf(":") + 1)) != -1)
                 .forEach(System.out::println);

*/
        //Using only recursion
        ClimbStairs_70 obj2 = new ClimbStairs_70();
        System.out.print(obj2.climbStairs_2(n) + " , ");
        System.out.println("loopRan = " + obj2.loopRan);

    }

    int loopRan = 0;
    int[] dp = new int[100];

    public int climbStairs_M(int n) {
        int count = 0;
        Arrays.fill(dp, -1);
        return solve_M(0, n, count);
    }

    private int solve_M(int target, int n, int count) {
        loopRan++;
        if (dp[target] != -1) {
            return dp[target];
        }

        if (target == n) return count + 1;
        if (target > n) return 0;

        return dp[target] = solve_M(target + 1, n, count)
                + solve_M(target + 2, n, count);
    }

}

















