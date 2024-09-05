package DailyCodeChallenge.Level_2;

import java.util.HashSet;
import java.util.Set;

class RobotSim_874_2 {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> obs = new HashSet<>();
        for (int[] item : obstacles) {
            obs.add(hash(item[0], item[1]));
        }
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0; // 0 := north, 1 := east, 2 := south, 3 := west
        int x = 0, y = 0;
        int max = 0;
        for (int c : commands) {
            switch (c) {
                case -1 -> d = (d + 1) % 4;
                case -2 -> d = (d + 3) % 4;
                default -> {
                    for (int step = 0; step < c; step++) {
                        if (obs.contains(hash(x + dir[d][0], y + dir[d][1]))) break;
                        x += dir[d][0];
                        y += dir[d][1];
                    }
                }
            }
            max = Math.max(max, x * x + y * y);
        }
        return max;
    }

    private int hash(int x, int y) {
        return 40000 * x + y;
    }
}