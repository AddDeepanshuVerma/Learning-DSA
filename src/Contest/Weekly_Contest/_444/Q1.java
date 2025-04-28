package Contest.Weekly_Contest._444;

import java.util.ArrayList;
import java.util.List;

public class Q1 {

    public int minimumPairRemoval(int[] nums) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);

        while (!inIncreasingOrder(list)) {
            // get the indexes of minimum element
            // And merge those values
            list = doTheThing(list);
            count++;
        }

        return count;
    }

    private List<Integer> doTheThing(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        int first = -1;

        for (int i = list.size() - 2; i >= 0; i--) {
            int diff = list.get(i) + list.get(i + 1);
            if (diff <= min) {
                first = i;
                min = diff;
            }
        }
        // now merge these value
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i == first) {
                ans.add(list.get(i) + list.get(i + 1));
                i++;
            } else {
                ans.add(list.get(i));
            }
        }
        return ans;
    }

    private boolean inIncreasingOrder(List<Integer> list) {
        int prev = -10000;
        for (Integer num : list) {
            if (num < prev) {
                return false;
            }
            prev = num;
        }
        return true;
    }


    public static void main(String[] args) {
        Q1 obj = new Q1();
        int[] nums = {5, 2, 3, 1};
        int count = obj.minimumPairRemoval(nums);
        System.out.println(count);
    }
}
