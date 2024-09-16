package Contest.Biweekly_Contest._139;

import jdk.jfr.Description;

import java.util.List;

class FindSafeWalk_2_2 {
    public static void main(String[] args) {

    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int[][] temp = new int[grid.size()][grid.getFirst().size()];
        return solve(grid, 0, 0, health, temp);
    }

    @Description("Still Getting TLE")
    private boolean solve(List<List<Integer>> grid, int i, int j, int health, int[][] s2) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid.get(i).size() || s2[i][j] == -1) {
            return false;
        }
        int temp = grid.get(i).get(j);

        if (health - temp < 1) return false;
        health -= temp;

        if (i == grid.size() - 1 && j == grid.get(i).size() - 1) {
            return true;
        }

        s2[i][j] = -1;
        boolean ans = solve(grid, i + 1, j, health, s2)
                || solve(grid, i - 1, j, health, s2)
                || solve(grid, i, j + 1, health, s2)
                || solve(grid, i, j - 1, health, s2);
        s2[i][j] = 0;

        return ans;
    }
}