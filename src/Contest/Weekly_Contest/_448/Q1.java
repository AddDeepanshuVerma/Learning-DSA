package Contest.Weekly_Contest._448;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1 {

    public int maxProduct(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }

        Collections.sort(list);
        int size = list.size();

        return list.get(size - 1) * list.get(size - 2);

    }


    public static void main(String[] args) {
        Q1 obj = new Q1();
    }
}
