package _13_Maths.Medium;

import jdk.jfr.Description;

import java.util.Arrays;

class CountPoints_1828 {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] queries = {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        CountPoints_1828 obj = new CountPoints_1828();
        System.out.println(Arrays.toString(obj.countPoints(points, queries)));
    }

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int X = queries[i][0], Y = queries[i][1], r = queries[i][2];
            int count = 0;
            for (int[] point : points) {
                int x = point[0] - X;
                int y = point[1] - Y;
                if ((x * x) + (y * y) <= (r * r)) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    @Description("Doesn't work as expected!!!")
    public int[] countPoints2(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int X = queries[i][0], Y = queries[i][1], delta = queries[i][2];
            int count = 0;
            for (int[] point : points) {
                int x = point[0];
                int y = point[1];
                if ((x >= X - delta) && (x <= X + delta) && (y >= Y - delta) && (y <= Y + delta)) count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}