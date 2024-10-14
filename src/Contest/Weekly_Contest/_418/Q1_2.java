package Contest.Weekly_Contest._418;

import java.util.ArrayList;
import java.util.List;

class Q1_2 {
    public static void main(String[] args) {
        // 100, 11 ( if we want to change the order / do the action : send a positive integer response  to sort function
        System.out.println("11100".compareTo("10011"));
        System.out.println("10011".compareTo("11100"));
        int[] arr = {4, 3};
        System.out.println(maxGoodNumber(arr));
    }

    public static int maxGoodNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int n : nums) {
            list.add(Integer.toBinaryString(n));
        }
        list.sort((a, c) -> (c + a).compareTo(a + c));
//        Collections.sort(list);
        StringBuilder r = new StringBuilder();
        for (String s : list) r.append(s);
        return Integer.parseInt(r.toString(), 2);
    }
}