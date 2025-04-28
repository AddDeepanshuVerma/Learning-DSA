package Contest.Biweekly_Contest._140;

import com.sun.nio.sctp.AssociationChangeNotification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ValidSequence_3_2 {
    public static void main(String[] args) {
        ValidSequence_3_2 obj = new ValidSequence_3_2();
        System.out.println(Arrays.toString(obj.validSequence("ghhgghhhhhh", "gg")));
    }

    List<Integer> ans;
    List<List<Integer>> result;

    public int[] validSequence(String s1, String s2) {
        ans = new ArrayList<>();
        result = new ArrayList<>();
        int idx = 0;
        int idx2 = 0;
        int count = 0;
        solve(idx, count, s1, s2, idx2, ans);
        if (result.isEmpty()) {
            return new int[0];
        }
        System.out.println("result = " + result);

        result.sort((a, b) -> b.stream()
                               .map(String::valueOf)
                               .collect(Collectors.joining(""))
                               .compareTo(a.stream().map(String::valueOf).collect(Collectors.joining(""))));

        ans = result.getFirst();


            int[] res = new int[ans.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = ans.get(i);
            }
        return res;
    }

    private void solve(int idx, int count, String s1, String s2, int idx2, List<Integer> ans) {
        if (ans.size() == s2.length()) {
            result.add(new ArrayList<>(ans));
            return;
        }

        if (count == 0) {
            ans.add(idx);
            solve(idx + 1, count + 1, s1, s2, idx2 + 1, ans);
            ans.removeLast();
        }
        for (int i = idx; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(idx2)) {
                ans.add(i);
                solve(i + 1, count, s1, s2, idx2 + 1, ans);
                ans.removeLast();
            }
        }
    }
}