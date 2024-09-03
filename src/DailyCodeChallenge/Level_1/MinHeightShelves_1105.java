package DailyCodeChallenge.Level_1;

import jdk.jfr.Description;
import java.util.Arrays;

class MinHeightShelves_1105 {
    int totalW = 0;
    int count = 0;
    int[][] dp = new int[1001][1001];

    public static void main(String[] args) {
        MinHeightShelves_1105 ob = new MinHeightShelves_1105();
        int[][] books = {{1, 3}, {2, 6}, {3, 9}, {4, 12}, {5, 15}, {6, 18}, {7, 21}, {8, 24}, {9, 27}, {10, 30}, {11, 33}, {12, 36}, {13, 39}, {14, 42}, {15, 45}, {16, 48}, {17, 51}, {18, 54}, {19, 57}, {20, 60}, {21, 63}, {22, 66}, {23, 69}, {24, 72}, {25, 75}, {26, 78}, {27, 81}, {28, 84}, {29, 87}, {30, 90}, {31, 93}, {32, 96}, {33, 99}, {34, 102}, {35, 105}, {36, 108}, {37, 111}, {38, 114}, {39, 117}, {40, 120}, {41, 123}, {42, 126}, {43, 129}, {44, 132}, {45, 135}, {46, 138}, {47, 141}, {48, 144}, {49, 147}, {50, 150}, {1, 3}, {2, 6}, {3, 9}, {4, 12}, {5, 15}, {6, 18}, {7, 21}, {8, 24}, {9, 27}, {10, 30}, {11, 33}, {12, 36}, {13, 39}, {14, 42}, {15, 45}, {16, 48}, {17, 51}, {18, 54}, {19, 57}, {20, 60}, {21, 63}, {22, 66}, {23, 69}, {24, 72}, {25, 75}, {26, 78}, {27, 81}, {28, 84}, {29, 87}, {30, 90}, {31, 93}, {32, 96}, {33, 99}, {34, 102}, {35, 105}, {36, 108}, {37, 111}, {38, 114}, {39, 117}, {40, 120}, {41, 123}, {42, 126}, {43, 129}, {44, 132}, {45, 135}, {46, 138}, {47, 141}, {48, 144}, {49, 147}, {50, 150}};
        System.out.println(ob.minHeightShelves(books, 200));
        System.out.println("length = " + books.length);
        System.out.println("count = " + ob.count);
    }

    public int minHeightShelves(int[][] books, int shelf_width) {
        int index = 0;
        this.totalW = shelf_width;
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
        return solveMemo(books, index, shelf_width, 0);
    }

    @Description("Recursion + Memoization")
    private int solveMemo(int[][] books, int i, int remaiW, int maxHt) {
        count++;
        if (i >= books.length) {
            return maxHt;
        }
        if (dp[i][remaiW] != -1) {
            return dp[i][remaiW];
        }

        int bookW = books[i][0];
        int bookH = books[i][1];
        int keep = Integer.MAX_VALUE, skip = Integer.MAX_VALUE;

        // keep the book in same shelf
        if (bookW <= remaiW) keep = solveMemo(books, i + 1, remaiW - bookW, Math.max(maxHt, bookH));
        // pass the book to next shelf
        skip = solveMemo(books, i + 1, totalW - bookW, bookH) + maxHt;

        return dp[i][remaiW] = Math.min(keep, skip);
    }

    @Description("Recursion")
    private int solve(int[][] books, int i, int remaiW, int maxHt) {
        count++;
        if (i >= books.length) {
            return maxHt;
        }

        int bookW = books[i][0];
        int bookH = books[i][1];
        int keep = Integer.MAX_VALUE, skip = Integer.MAX_VALUE;

        // keep the book in same shelf
        if (bookW <= remaiW) keep = solve(books, i + 1, remaiW - bookW, Math.max(maxHt, bookH));
        // pass the book to next shelf
        skip = solve(books, i + 1, totalW - bookW, bookH) + maxHt;

        return Math.min(keep, skip);
    }
}