package POTD_LEETCODE.Dynamic_Programming;

import java.util.Arrays;

class TupleSameProduct_1726_2 {
    public static void main(String[] args) {
        var obj = new TupleSameProduct_1726_2();
//        int[] nums = {1, 2, 4, 5, 10};
        int[] nums = {2, 3, 4, 6, 8, 12};
        System.out.println(obj.tupleSameProduct(nums));
    }

    public int tupleSameProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] visited = new int[n + 1][n + 1];
        Arrays.stream(visited).forEach(vis -> Arrays.fill(vis, -1));
        return dfs(0, n - 1, nums, visited);
    }

    private int dfs(int start, int end, int[] nums, int[][] visited) {
        if (end - start <= 2) return 0;
        if (visited[start][end] != -1) {
            return 0;
        }

        int sum = 0;
        sum += search(start + 1, end - 1, nums[start] * nums[end], nums);
        sum += dfs(start + 1, end, nums, visited) + dfs(start, end - 1, nums, visited);
        return visited[start][end] = sum;
    }

    private int search(int i, int j, int target, int[] nums) {
        if (i >= j) return 0;

        int count = 0;
        if (nums[i] * nums[j] == target) {
            count = 8 + search(i + 1, j - 1, target, nums);
        } else if (nums[i] * nums[j] > target) {
            count = search(i, j - 1, target, nums);
        } else {
            count = search(i + 1, j, target, nums);
        }

        return count;
    }
}