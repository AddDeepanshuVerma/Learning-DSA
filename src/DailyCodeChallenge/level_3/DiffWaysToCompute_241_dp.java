package DailyCodeChallenge.level_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class DiffWaysToCompute_241_dp {
    static HashMap<String, List<Integer>> dp;

    public static void main(String[] args) {
        dp = new HashMap<>();
        DiffWaysToCompute_241_dp obj = new DiffWaysToCompute_241_dp();
        System.out.println(obj.dfs("1+2-3+4-5+6-7+8-9+10"));
        System.out.println("dp = " + dp);
    }

    // Recursion + memoization
    public List<Integer> dfs(String str) {
        if (dp.containsKey(str)) return dp.get(str);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            // if given number is not digit then this is the index we will break it
            if (!Character.isDigit(str.charAt(i))) {
                List<Integer> left = dfs(str.substring(0, i));
                List<Integer> right = dfs(str.substring(i + 1));
                for (Integer l1 : left)
                    for (Integer r1 : right)
                        switch (str.charAt(i)) {
                            case '+' -> res.add(l1 + r1);
                            case '-' -> res.add(l1 - r1);
                            case '*' -> res.add(l1 * r1);
                        }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(str));
        }
        dp.put(str, res);
        return res;
    }
}
