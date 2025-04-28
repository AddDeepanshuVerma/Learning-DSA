package POTD_LEETCODE.Array;

import java.util.*;

class CountCoveredBuildings_3531 {
    public static int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer, List<Integer>> row = new HashMap<>();
        HashMap<Integer, List<Integer>> col = new HashMap<>();

        for (int[] b : buildings) {
            int r = b[0], c = b[1];
            row.computeIfAbsent(r, list -> new ArrayList<>()).add(c);
            col.computeIfAbsent(c, list -> new ArrayList<>()).add(r);
        }

        for (List<Integer> value : row.values()) Collections.sort(value);
        for (List<Integer> value : col.values()) Collections.sort(value);

        int count = 0;

        for (int[] b : buildings) {
            int r = b[0], c = b[1];
            // first check if total elements in that up-down || left-right are less than 3
            List<Integer> rowList = row.getOrDefault(r, Collections.emptyList());
            List<Integer> colList = col.getOrDefault(c, Collections.emptyList());
            if (rowList.size() <= 2 || colList.size() <= 2) continue;

            if (rowList.getFirst() == c || rowList.getLast() == c) continue;
            if (colList.getFirst() == r || colList.getLast() == r) continue;

            count++;
        }
        return count;
    }

    public int countCoveredBuildings2(int n, int[][] buildings) {
        Map<Integer, TreeSet<Integer>> row = new HashMap<>();
        Map<Integer, TreeSet<Integer>> col = new HashMap<>();

        for (int[] coordinate : buildings) {
            int r = coordinate[0], c = coordinate[1];
            row.computeIfAbsent(r, set -> new TreeSet<>()).add(c);
            col.computeIfAbsent(c, set -> new TreeSet<>()).add(r);
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
        int n = 4;
        int[][] buildings = {{4, 4}, {2, 4}, {3, 4}, {4, 3}, {2, 3}, {3, 3}, {2, 2}, {3, 2}, {1, 3}};

        int ans = countCoveredBuildings(n, buildings);
        System.out.println("ans = " + ans);
    }
}