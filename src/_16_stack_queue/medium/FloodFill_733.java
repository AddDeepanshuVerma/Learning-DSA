package _16_stack_queue.medium;

import java.util.Arrays;

class FloodFill_733 {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] ar2r = {{0, 0, 0}, {0, 0, 0}};
        FloodFill_733 obj = new FloodFill_733();
        System.out.println(Arrays.deepToString(obj.floodFill(ar2r, 0, 0, 0)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) {
            solve(image, sr, sc, color, image[sr][sc]);
        }
        return image;
    }

    private void solve(int[][] image, int i, int j, int applyColor, int land) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != land) {
            return;
        }

        image[i][j] = applyColor;
        solve(image, i + 1, j, applyColor, land);
        solve(image, i - 1, j, applyColor, land);
        solve(image, i, j + 1, applyColor, land);
        solve(image, i, j - 1, applyColor, land);
        return;
    }
}