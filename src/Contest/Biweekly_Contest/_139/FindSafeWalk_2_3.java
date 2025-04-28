package Contest.Biweekly_Contest._139;

import jdk.jfr.Description;

import java.util.*;

class FindSafeWalk_2_3 {
    public static void main(String[] args) {
        FindSafeWalk_2_3 obj = new FindSafeWalk_2_3();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sList = List.of(1, 1, 1);
        list.add(sList);
        System.out.println(obj.findSafeWalk(list, 4));
    }

    record Pair<K, V, H>(K key, V value, H health) {
    }

    @Description("this one failed few TC")
    private boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.getFirst().size();

        final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] seen = new boolean[m][n];

        if (grid.getFirst().getFirst() == 1) {
            health--;
        }

        Queue<Pair<Integer, Integer, Integer>> q = new ArrayDeque<>(List.of(new Pair<>(0, 0, health)));
        seen[0][0] = true;

        while (!q.isEmpty()) {
            final int i = q.peek().key();
            final int j = q.peek().value();
            final int h = q.poll().health;
            if (h < 1) continue;

            if (i == m - 1 && j == n - 1) return true;

            for (int[] dir : dirs) {
                final int x = i + dir[0];
                final int y = j + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                if (seen[x][y]) continue;
                q.offer(new Pair<>(x, y, h - grid.get(x).get(y)));
                seen[x][y] = true;
            }
        }
        return false;
    }
}