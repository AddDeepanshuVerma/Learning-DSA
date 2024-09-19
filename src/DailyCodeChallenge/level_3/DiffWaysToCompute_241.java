package DailyCodeChallenge.level_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class DiffWaysToCompute_241 {

    public static void main(String[] args) {
        String str = "1+2-3+4-5+6-7+8-9+10";
        DiffWaysToCompute_241 obj = new DiffWaysToCompute_241();
        System.out.println(obj.diffWaysToCompute(str));
    }

    // Recursion without memoization
    public List<Integer> diffWaysToCompute(String str) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            // if given number is not digit then this is the index we will break it
            if (!Character.isDigit(str.charAt(i))) {
                List<Integer> left = diffWaysToCompute(str.substring(0, i));
                List<Integer> right = diffWaysToCompute(str.substring(i + 1));
                for (Integer l1 : left)
                    for (Integer r1 : right)
                        switch (str.charAt(i)) {
                            case '+' -> res.add(l1 + r1);
                            case '-' -> res.add(l1 - r1);
                            case '*' -> res.add(l1 * r1);
                        }
            }
        }
        return res.isEmpty() ? List.of(Integer.parseInt(str)) : res;
    }

}
