package Contest.Weekly_Contest._420;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        Q1 obj = new Q1();
        System.out.println(obj.stringSequence("abc"));
    }

    public List<String> stringSequence(String target) {
        ArrayList<String> list = new ArrayList<>();
        char[] arr = target.toCharArray();
        StringBuilder ans = new StringBuilder();

        for (char ch : arr) {
            char start = 'a';
            while (start <= ch) {
                list.add(ans.toString() + start);
                start++;
            }
            ans.append(--start);
        }
        return list;
    }
}
