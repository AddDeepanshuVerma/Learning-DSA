package Contest.Biweekly_Contest._140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ValidSequence_3 {
    public static void main(String[] args) {
        ValidSequence_3 obj = new ValidSequence_3();
        System.out.println(Arrays.toString(obj.validSequence("ghhgghhhhhh", "gg")));
    }

    List<Integer> ans;

    public int[] validSequence(String s1, String s2) {
        ans = new ArrayList<>();
        int idx = 0;
        int idx2 = 0;
        int count = 0;
        if (!solve(idx, count, s1, s2, idx2, ans)) {
            return new int[0];
        } else {
            int[] res = new int[ans.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = ans.get(i);
            }
            return res;
        }
    }

    private boolean solve(int idx, int count, String s1, String s2, int idx2, List<Integer> ans) {
        if (ans.size() == s2.length()) {
            return true;
        }

        if (count == 0) {
            ans.add(idx);
            if (solve(idx + 1, count + 1, s1, s2, idx2 + 1, ans)) {
                return true;
            }
            ans.removeLast();
        }
        for (int i = idx; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(idx2)) {
                ans.add(i);
                if (solve(i + 1, count, s1, s2, idx2 + 1, ans)) {
                    return true;
                }
                ans.removeLast();
            }
        }
        return false;
    }
}