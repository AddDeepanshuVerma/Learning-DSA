package POTD_LEETCODE.BackTracking;

import java.util.ArrayList;
import java.util.List;

class GetHappyString_1415_2 {
    public static void main(String[] args) {
        var obj = new GetHappyString_1415_2();
        System.out.println(obj.getHappyString(3, 9));
    }

    int count;

    public String getHappyString(int n, int k) {
        StringBuilder curr = new StringBuilder();
        count = 0;
        return dfs(curr, n, ' ', k) ? curr.toString() : "";
    }

    private boolean dfs(StringBuilder curr, int n, char prev, int k) {
        if (curr.length() == n) {
            return ++count == k;
        }

        for (char i = 'a'; i <= 'c'; i++) {
            if (prev == i) continue;
            curr.append(i);
            if (dfs(curr, n, i, k)) return true;
            curr.deleteCharAt(curr.length() - 1);
        }
        return false;
    }
}