package _13_Maths.easy;

import java.util.ArrayList;
import java.util.List;

class SelfDividingNumbers_728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (check(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean check(int n) {
        if (n < 10) return true;
        int clone = n;
        while (n > 0) {
            int temp = n % 10;
            if (temp == 0 || clone % temp != 0) {
                break;
            }
            n /= 10;
        }
        return !(n > 0);
    }
}