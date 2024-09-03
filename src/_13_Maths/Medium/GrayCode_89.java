package _13_Maths.Medium;

import java.util.ArrayList;
import java.util.List;

class GrayCode_89 {
    public static void main(String[] args) {
        GrayCode_89 obj = new GrayCode_89();
        System.out.println(obj.grayCode(2));
    }
    public List<Integer> grayCode(int n) {
        return solve(n);
    }

    private List<Integer> solve(int n) {
        if (n == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        List<Integer> prev = solve(n - 1);
        List<Integer> curr = new ArrayList<>(prev);
        for (int i = prev.size() - 1; i >= 0; i--) {
            curr.add(prev.get(i) | 1 << (n - 1));
        }
        return curr;
    }
}