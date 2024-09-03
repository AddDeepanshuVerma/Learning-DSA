package DailyCodeChallenge.Level_2;

import java.util.ArrayList;
import java.util.List;

class MaxDistance_624 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(List.of(1, 4));
        List<Integer> list2 = new ArrayList<>(List.of(0, 5));
        list.add(list1);
        list.add(list2);
        MaxDistance_624 obj = new MaxDistance_624();
        System.out.println(obj.maxDistance2(list));
    }

    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (List<Integer> array : arrays) {
            min = Math.min(array.getFirst(), min);
            max = Math.max(array.getLast(), max);
        }
        return max - min;
    }

    public int maxDistance2(List<List<Integer>> arrays) {
        int ans = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < arrays.size(); i++) {
            temp = arrays.get(i).getLast();
            for (int j = 0; j < arrays.size(); j++) {
                if (i != j) {
                    ans = Math.max(ans, temp - arrays.get(j).getFirst());
                }
            }
        }
        return ans;
    }
}
