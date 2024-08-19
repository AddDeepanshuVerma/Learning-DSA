package DailyCodeChallenge.Level_2;

import jdk.jfr.Description;

class MinSteps_650 {
    int count;

    public static void main(String[] args) {
        MinSteps_650 obj = new MinSteps_650();
        System.out.println("minSteps = " + obj.minSteps(10));
    }

    public int minSteps(int n) {
        if (n == 1) return 0;
        count = Integer.MAX_VALUE;
        solve(n, 1, 0, 0);
        return count;
    }

    @Description("recursion with void return type")
    private void solve2(int val, int op, int ip, int operations) {
        if (op > val) return;

        if (op == val) {
            count = Math.min(count, operations);
            return;
        }

        //paste the ip to op
        if (ip != 0) solve(val, op + ip, ip, ++operations);

        // copy from op to ip
        if (op != ip) solve(val, op, op, ++operations);
    }

    @Description("recursion with int return type")
    private int solve3(int val, int op, int ip) {
        if (op > val) return 10000;

        if (op == val) return 0;

        int paste = 10000, copy = 10000;

        if (ip != 0) paste = 1 + solve3(val, op + ip, ip);
        if (op != ip) copy = 1 + solve3(val, op, op);

        return Math.min(copy, paste);
    }

    @Description("recursion with void return type")
    private void solve(int val, int op, int ip, int operations) {
        if (op > val) return;

        if (op == val) {
            count = Math.min(count, operations);
            return;
        }

        //paste the ip to op
        if (ip != 0) {
            op += ip;
            solve(val, op, ip, ++operations);
        }

        // copy from op to ip
        if (op != ip) {
            ip = op;
            solve(val, op, ip, ++operations);
        }
    }
}