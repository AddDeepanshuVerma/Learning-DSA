package POTD_LEETCODE.BackTracking;

import java.util.ArrayList;
import java.util.List;

class GetHappyString_1415 {
    public static void main(String[] args) {
        var obj = new GetHappyString_1415();
        System.out.println(obj.getHappyString(1, 4));
    }

    public String getHappyString(int n, int k) {
        List<String> ans = new ArrayList<>();

        dfs(new StringBuilder(), ans, n, ' ');
        System.out.println("ans = " + ans);
        return ans.size() >= k ? ans.get(k - 1) : "";
    }

    private void dfs(StringBuilder curr, List<String> ans, int n, char prev) {
        if (curr.length() == n) {
            ans.add(curr.toString());
            return;
        }

        for (char i = 'a'; i <= 'c'; i++) {
            if (prev == i) continue;
            curr.append(i);
            dfs(curr, ans, n, i);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}