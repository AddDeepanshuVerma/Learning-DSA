package Contest.Weekly_Contest._418;

import java.util.*;

public class Q2_2 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {0, 2}, {0, 1}, {3, 4}};
        int[][] arr2 = {{1, 2}, {0, 1}, {2, 0}};
        int[][] arr3 = {{1, 2}, {0, 1}, {3, 2}};
        int[][] arr4 = {{1, 0}, {2, 0}};
        Q2_2 q2 = new Q2_2();
        System.out.println(q2.remainingMethods(3, 2, arr4));
    }

    public List<Integer> remainingMethods(int n, int k, int[][] arr) {
        List<Integer> ans = new ArrayList<>();

        HashMap<Integer, Integer> pointing = new HashMap<>();
        HashMap<Integer, Set<Integer>> pointedBy = new HashMap<>();

        for (int[] item : arr) {
            Integer a = item[0];
            Integer b = item[1];
//            if (!pointing.containsKey(a)) {
//                pointing.put(a, Set.of(b));
//            } else {
//                pointing.computeIfAbsent(a, c -> new HashSet<>()).add(b);
//            }
            pointing.put(a, b);
            pointedBy.computeIfAbsent(b, c -> new HashSet<>()).add(a);

        }

        boolean hasCycle = false;
        Set<Integer> sus = new HashSet<>();
        sus.add(k);
        while (true) {
            if (pointing.containsKey(k)) {
                int val = pointing.get(k);
                if (sus.contains(val)) {
                    hasCycle = true;
                    break;
                }
                sus.add(val);
                k = val;
            } else break;
        }
        if (!hasCycle) {
            for (int i = 0; i < n; i++) {
                ans.add(i);
            }
            return ans;
        }

        Set<Integer> toBeRemoved = new HashSet<>();
        List<Integer> list = new ArrayList<>(sus);
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (pointedBy.containsKey(num)) {
                // this num is pointed by any value which is not in set then true
                if (!isValid(pointedBy.get(num), sus)) {
                    toBeRemoved.add(num);
                }
            } else {
                toBeRemoved.add(num);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!toBeRemoved.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean isValid(Set<Integer> pointedBy, Set<Integer> sus) {
        for (Integer num : pointedBy) {
            if (!sus.contains(num)) {
                return true;
            }
        }
        return false;
    }
}
