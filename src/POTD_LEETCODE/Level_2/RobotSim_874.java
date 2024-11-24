package POTD_LEETCODE.Level_2;

import java.util.HashSet;
import java.util.Set;

class RobotSim_874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int ans = 0;
        int d = 0; // 0 := north, 1 := east, 2 := south, 3 := west
        int x = 0; // the start x
        int y = 0; // the start y
        Set<Pair<Integer, Integer>> obstaclesSet = new HashSet<>();

        for (int[] o : obstacles)
            obstaclesSet.add(new Pair<>(o[0], o[1]));

        for (final int c : commands) {
            if (c == -1) {
                d = (d + 1) % 4;
            } else if (c == -2) {
                d = (d + 3) % 4;
            } else {
                for (int step = 0; step < c; ++step) {
                    if (obstaclesSet.contains(new Pair<>(x + dirs[d][0], y + dirs[d][1]))) break;
                    x += dirs[d][0];
                    y += dirs[d][1];
                }
            }
            ans = Math.max(ans, x * x + y * y);
        }

        return ans;
    }

    record Pair<K, V>(K r, V c) {

    }

    public int robotSim2(int[] commands, int[][] obstacles) {
        final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int ans = 0;
        int d = 0; // 0 := north, 1 := east, 2 := south, 3 := west
        int x = 0, y = 0;
        ; // the start x & start y
        Set<Pair<Integer, Integer>> obstaclesSet = new HashSet<>();

        for (int[] o : obstacles)
            obstaclesSet.add(new Pair<>(o[0], o[1]));

        for (final int c : commands) {
            switch (c) {
                case -1 -> d = (d + 1) % 4;
                case -2 -> d = (d + 3) % 4;
                default -> {
                    for (int step = 0; step < c; ++step) {
                        if (obstaclesSet.contains(new Pair<>(x + dirs[d][0], y + dirs[d][1]))) break;
                        x += dirs[d][0];
                        y += dirs[d][1];
                    }
                }
            }
            ans = Math.max(ans, x * x + y * y);
        }
        return ans;
    }
}