package Contest.Biweekly_Contest._139;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


class FindSafeWalk_2_5 {
    public static void main(String[] args) {
        FindSafeWalk_2_5 obj = new FindSafeWalk_2_5();
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1, 1, 1));
        int health = 4;

        System.out.println(obj.findSafeWalk(list, health));
    }

    record Pair<K, V, H>(K row, V cal, H health) {
    }

    @Description("this one worked : just Needed to use Priority queue")
    private boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.getFirst().size();

        final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] seen = new boolean[m][n];

        health -= grid.getFirst().getFirst();

        Queue<Pair<Integer, Integer, Integer>> q = new PriorityQueue<>((a, b) -> b.health - a.health);
        q.offer(new Pair<>(0, 0, health));
        seen[0][0] = true;

        while (!q.isEmpty()) {
            Pair<Integer, Integer, Integer> poll = q.poll();
            if (poll.health < 1) continue;
            if (poll.row == m - 1 && poll.cal == n - 1) return true;

            for (int[] dir : dirs) {
                final int x = poll.row + dir[0];
                final int y = poll.cal + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                if (seen[x][y]) continue;
                seen[x][y] = true;
                q.offer(new Pair<>(x, y, poll.health - grid.get(x).get(y)));
            }
        }
        return false;
    }

}