package Interesting;

import java.util.HashSet;
import java.util.Set;

class RobotSim_874_2 {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> obs = new HashSet<>();
        for (int[] o : obstacles) {
            obs.add(hash(o[0], o[1]));
        }
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] curr = {0, 0};
        int max = 0;
        int direction = 0;
        for (int c : commands) {
            if (c == -1) {
                direction = (direction + 1) % 4;
            } else if (c == -2) {
                direction = (direction + 3) % 4;
            } else {
                while (c > 0 && !obs.contains(hash(curr[0] + dir[direction][0], curr[1] + dir[direction][1]))) {
                    curr[0] += dir[direction][0];
                    curr[1] += dir[direction][1];
                    c--;
                }
            }
            max = Math.max(max, curr[0] * curr[0] + curr[1] * curr[1]);
        }
        return max;
    }

    private int hash(int x, int y) {
        return 40000 * x + y;
    }
}