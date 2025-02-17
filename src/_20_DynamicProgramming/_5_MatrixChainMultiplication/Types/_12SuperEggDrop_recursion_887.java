package _20_DynamicProgramming._5_MatrixChainMultiplication.Types;

class _12SuperEggDrop_recursion_887 {
    public static void main(String[] args) {
        int eggs = 3;
        int floor = 14;
        System.out.println(superEggDrop(eggs, floor));
    }

    //Return the minimum number of moves that you need to determine with certainty what the value of f is.
    // OR ~ minimum number of moves out of maximum moves required to get the farthest threshold
    // hence need to calculate the minimum of maximums ~~ maximums : {5,4,8,5,4} then ans = 4.
    public static int superEggDrop(int e, int f) {
        return dfs(e, f);
    }

    private static int dfs(int e, int f) {
        if (f == 0 || f == 1) return f;
        if (e == 1) return f;
        int min = Integer.MAX_VALUE;
        for (int currFloor = 1; currFloor <= f; currFloor++) {
            int broke = dfs(e - 1, currFloor - 1);
            int unBroke = dfs(e, f - currFloor);
            min = Math.min(min, 1 + Math.max(unBroke, broke));
        }
        return min;
    }
}