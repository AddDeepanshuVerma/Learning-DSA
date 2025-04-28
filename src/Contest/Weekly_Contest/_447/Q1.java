package Contest.Weekly_Contest._447;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Q1 {

    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, TreeSet<Integer>> row = new HashMap<>(), col = new HashMap<>();

        for (int[] coordinate : buildings) {
            int u = coordinate[0], v = coordinate[1];
            row.computeIfAbsent(u, set -> new TreeSet<>()).add(v);
            col.computeIfAbsent(v, set -> new TreeSet<>()).add(u);
        }

        int covered = 0;

        for (int[] coordinate : buildings) {
            int x = coordinate[0], y = coordinate[1];

            TreeSet<Integer> r = row.get(x);
            TreeSet<Integer> c = col.get(y);

            Integer left = r.lower(y);
            Integer right = r.higher(y);
            Integer up = c.lower(x);
            Integer down = c.higher(x);

            if (left != null && right != null && up != null && down != null) {
                covered++;
            }
        }

        return covered;
    }

    public static void main(String[] args) {
        Q1 obj = new Q1();


    }
}
