package Contest.Biweekly_Contest._139;

import jdk.jfr.Description;

import java.util.List;

class FindSafeWalk_2 {
    public static void main(String[] args) {
        boolean a = true;
        int b = 0;
        boolean ans2 = a || ++b > 1;
        System.out.println("b = " + b);
        boolean ans = a | ++b > 1;
        System.out.println("b = " + b);

    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        return solve(grid, 0, 0, health);
    }

    @Description("DFS approach getting TLE")
    private boolean solve(List<List<Integer>> grid, int i, int j, int health) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid.get(i).size() || grid.get(i).get(j) == -1) {
            return false;
        }
        if (health - grid.get(i).get(j) < 1) {
            return false;
        }
        health -= grid.get(i).get(j);
        if (i == grid.size() - 1 && j == grid.get(i).size() - 1) return true;

        int temp = grid.get(i).get(j);
        grid.get(i).set(j, -1);

        boolean ans = solve(grid, i + 1, j, health) | solve(grid, i - 1, j, health) |
                      solve(grid, i, j + 1, health) | solve(grid, i, j - 1, health);
        grid.get(i).set(j, temp);

        return ans;
    }
}