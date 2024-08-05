package _13_Maths.easy;

import java.util.HashSet;
import java.util.Set;

class IsHappy_202 {
    Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        IsHappy_202 obj = new IsHappy_202();
        for (int i = 0; i <= 50; i++) {
            System.out.println(obj.isHappy(i));
//            System.out.println("obj.set = " + obj.set);
            obj.set.clear();
        }
    }

    public boolean isHappy(int n) {
        return solve(n);
    }

    private boolean solve(int n) {
        if (n == 1) return true;
        if (set.contains(n)) return false;
        set.add(n);
        n = process(n);
        return solve(n);
    }

    private int process(int n) {
        int temp = 0;
        while (n > 0) {
            temp += (n % 10) * (n % 10);
            n = n / 10;
        }
        return temp;
    }
}